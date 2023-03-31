import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";

export default function SignupForm() {

    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [address, setAddress] = useState('');
    const [zipCode, setZipCode] = useState('');
    const [city, setCity] = useState('');
    const [state, setState] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [photoUrl, setPhotoUrl] = ('');
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

    

    const handleSubmit =  (event) => {
        event.preventDefault();
            
    };
    return (

        <form onSubmit={handleSubmit}>
            <div className="form-container">
                    <h2>Create Account</h2>
                    <div className="mb-3">
                        <label className= "form-label" htmlFor="firstname">First Name</label>
                        <input type="text" className="form-control" id="firstname" name="firstname"
                            value={firstname}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="lastname">Last Name</label>
                        <input type="text" className="form-control" id="lastname" name="lastname"
                            value={lastname}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="address">Address</label>
                        <input type="text" className="form-control" id="address" name="address"
                            value={address}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="zipCode">Zip Code</label>
                        <input type="text" className="form-control" id="zipCode" name="zipCode"
                            value={zipCode}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="city">City</label>
                        <input type="text" className="form-control" id="city" name="city"
                            value={city}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="state">State</label>
                        <input type="text" className="form-control" id="state" name="state"
                            value={state}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <input type="email" className="form-control" id="email" name="email"
                            value={email}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="phone">Phone Number</label>
                        <input type="text" className="form-control" id="phone" name="phone"
                            value={phone}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="photoUrl">Photo</label>
                        <input type="text" className="form-control" id="photoUrl" name="photoUrl"
                            value={photoUrl}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="userName">UserName</label>
                        <input type="text" className="form-control" id="userName" name="userName"
                            value={userName}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="password">Password</label>
                        <input type="password" className="form-control" id="password" name="password"
                            value={password}  />
                    </div>
                    <div className="mb-3">
                        <Link to="/" className="btn btn-warning me-1">Cancel</Link>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </div>
                                        
            </div>        
        </form>
    );    
    
}
