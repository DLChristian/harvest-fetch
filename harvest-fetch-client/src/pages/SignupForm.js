import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import './SignupForm.css';

export default function SignupForm() {

    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [address, setAddress] = useState('');
    const [zipCode, setZipCode] = useState('');
    const [city, setCity] = useState('');
    const [state, setState] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [photoUrl, setPhotoUrl] = useState('');
    const [hasError, setHasError] = useState(false);
    const [errorMsg, setErrorMsg] = useState('');

    const navigate = useNavigate();


    const handleSubmit =  (event) => {
        event.preventDefault();
        const formData = {
            firstname,
            lastname,
            address,
            zipCode,
            city,
            state,
            email,
            phone,
            photoUrl
        };

        fetch('/api/app_user_info', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if(response.ok) {
                navigate('/createuserform');
            }else{
                return response.json();
            }
        })
        .then(errorData => {
            setHasError(true);
            setErrorMsg(errorData.message);
        })
        .catch(error => {
            setHasError(true);
            setErrorMsg('Sign Up Failed');
        });
            
    };

    return (

        <form onSubmit={handleSubmit}>
            <div className="form-signup">
                    <h2>Create Account</h2>
                    <div className="mb-3">
                        <label className= "form-label" htmlFor="firstname">First Name</label>
                        <input type="text" className="form-control" id="firstname" name="firstname"
                            value={firstname} onChange={(event) => setFirstName(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="lastname">Last Name</label>
                        <input type="text" className="form-control" id="lastname" name="lastname"
                            value={lastname} onChange={(event) => setLastName(event.target.value)}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="address">Address</label>
                        <input type="text" className="form-control" id="address" name="address"
                            value={address}  onChange={(event) => setAddress(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="zipCode">Zip Code</label>
                        <input type="text" className="form-control" id="zipCode" name="zipCode"
                            value={zipCode}  onChange={(event) => setZipCode(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="city">City</label>
                        <input type="text" className="form-control" id="city" name="city"
                            value={city}  onChange={(event) => setCity(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="state">State</label>
                        <input type="text" className="form-control" id="state" name="state"
                            value={state}  onChange={(event) => setState(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <input type="email" className="form-control" id="email" name="email"
                            value={email}  onChange={(event) => setEmail(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="phone">Phone Number</label>
                        <input type="text" className="form-control" id="phone" name="phone"
                            value={phone}  onChange={(event) => setPhone(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="photoUrl">Photo</label>
                        <input type="url" className="form-control" id="photoUrl" name="photoUrl"
                            value={photoUrl}  onChange={(event) => setPhotoUrl(event.target.value)} />
                    </div>
                    
                    <div className="mb-3">
                        <Link to="/" className="btn btn-warning me-1">Cancel</Link>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </div>
                    {hasError && <div className="alert alert-danger">
                        {errorMsg}.
                    </div>}
                                        
            </div>        
        </form>
    );    
    
}
