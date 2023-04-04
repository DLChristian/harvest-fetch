import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import './LoginForm.css';

export default function CreateUserForm() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [hasError, setHasError] = useState(false);
    const [errorMsg, setErrorMsg] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();

        
        if (password !== confirmPassword) {
            setHasError(true);
            setErrorMsg('Passwords do not match.');
            return;
        }

        
        const formData = {
            username,
            password
        };

       
        fetch('http://localhost:8080/api', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if(response.ok) {
                navigate('/');
            } else {
                return response.json();
            }
        })
        .then(errorData => {
            setHasError(true);
            setErrorMsg(errorData.message);
        })
        .catch(error => {
            setHasError(true);
            setErrorMsg('Create user failed.');
        });
    };

    return (

        <form onSubmit={handleSubmit}>
            <div className="form-container-login">
                    <h2>Create User Account</h2>
                    <div className="mb-3">
                        <label className= "form-label" htmlFor="username">Username</label>
                        <input type="text" className="form-control" id="username" name="username"
                            value={username} onChange={(event) => setUsername(event.target.value)} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="password">Password</label>
                        <input type="password" className="form-control" id="password" name="password"
                            value={password} onChange={(event) => setPassword(event.target.value)}  />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="confirmPassword">Confirm Password</label>
                        <input type="password" className="form-control" id="confirmPassword" name="confirmPassword"
                            value={confirmPassword} onChange={(event) => setConfirmPassword(event.target.value)}  />
                    </div>
                    
                    <div className="mb-3">
                        <Link to="/" className="btn btn-warning me-1">Cancel</Link>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </div>
                    {hasError && <div className="alert alert-danger">
                        {errorMsg}
                    </div>}
                                        
            </div>        
        </form>
    );    
}
