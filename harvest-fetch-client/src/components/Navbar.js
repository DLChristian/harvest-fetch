import "./NavbarStyles.css";
import { Link } from "react-router-dom";


function Navbar(){
    return(
        <>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <Link className="navbar-brand" to="/">Harvest Fetch</Link>
            <div className="nav">
                <ul className="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <Link to="/" className="nav-link">Home</Link>
                    </li>
                    <li className="nav-item">
                        <a class="nav-link" href="#">Select Your Address</a>
                    </li>
                    <li className="nav-item">
                        <a class="nav-link" href="#">Login</a>
                    </li>
                </ul>
                <form className="form-inline">
                    <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <div id="banner">
        </div>
        </>
        );
}

export default Navbar;
