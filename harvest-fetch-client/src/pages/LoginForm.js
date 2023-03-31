
import { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { authenticate } from "../services/authService";
import AuthContext from "../contexts/AuthContext";
import './LoginForm.css';

export default function LoginForm() {

    const [credentials, setCredentials] = useState({ username: "", password: ""});
    const [hasError, setHasError] = useState(false);
    const { login } = useContext(AuthContext);
    const navigate = useNavigate();

    function handleChange(evt) {
        const next = { ...credentials };
        next[evt.target.name] = evt.target.value;
        setCredentials(next);
    }

    function handleSubmit(evt) {
        evt.preventDefault();
        authenticate(credentials)
            .then(user => {
                login(user);
                navigate("/");
            })
            .catch(() => setHasError(true));
    }

    function handleCreateAccountClick() {
        navigate("/signupform");
    }


    return (

        <form onSubmit={handleSubmit}>
            <div className="form-container">
                    <h2>Login</h2>
                    <div className="mb-3 ">
                        <label className= "form-label" htmlFor="username">UserName</label>
                        <input type="text" className="form-control" id="username" name="username"
                            value={credentials.username} onChange={handleChange} />
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="password">Password</label>
                        <input type="password" className="form-control" id="password" name="password"
                            value={credentials.password} onChange={handleChange} />
                    </div>
                    <div className="mb-3">
                        <Link to="/" className="btn btn-warning me-1">Cancel</Link>
                        <button type="submit" className="btn btn-primary">Login</button>
                    </div>
                    <div>
                        <h5>Click Create Account to Sign Up</h5>
                        <button type="button" className="btn btn-outline-success me-1" onClick={handleCreateAccountClick}>Create Account</button>
                    </div>
                    {hasError && <div className="alert alert-danger">
                        Bad Credentials.
                    </div>}
            </div>        

        </form>
    );
}




