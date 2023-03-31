import { useState } from "react";
import { Link } from "react-router-dom";

function LoginForm() {
    const [user_name, setUser_name] = useState('');
    const [password, setPassword] = useState('');

    const handleUserNameChange = (event) => {
        setUser_name(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handelSubmit = (event) => {
        event.preventDefault();
        //TODO handle login submission
    };

    return (
        <form onSubmit={handelSubmit}>
            <h2>Login</h2>
            <label>
                UserName:
                <input type="user_name" value={user_name} onChange={handleUserNameChange} />
            </label>
            <label>
                Password:
                <input type="password" value={password} onChange={handlePasswordChange} />
            </label>
            <button type="submit">Login</button>
            <p>
                Do not have an account?<Link to="/signup">Create Account</Link>
            </p>
        </form>
    );
}

export default LoginForm;