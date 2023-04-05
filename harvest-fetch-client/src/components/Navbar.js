import "./NavbarStyles.css";
import { useContext, useState } from "react";
import { Link } from "react-router-dom";
import AuthContext from "../contexts/AuthContext";

function Navbar() {

    const { appUser, logout } = useContext(AuthContext);

    function handleLogout(evt) {
        evt.preventDefault();
        logout();
    }
    
    return (
        <>
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <Link class="navbar-brand" to="/">Harvest Fetch</Link>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item"><Link class="nav-link active" aria-current="page" to="/">Home</Link></li>
                            <li class="nav-item"><Link class="nav-link" to="/farmers">Farmers</Link></li>
                            <li class="nav-item">{appUser ? <>
                                <a href="#logout" className="nav-link" onClick={handleLogout}>Logout</a>
                                {/* {appUser.sub} */}
                            </>
                                : <Link class="nav-link" to="/loginform">Login</Link>
                            }</li>

                        </ul>
                        <form class="d-flex bar" role="search">
                            <div class="location">
                                <input class="form-control me-2" placeholder="Zip Code" aria-label="Search" />
                            </div>
                            <div class="search">
                                <input
                                    type="text"
                                    class="form-control me-2"
                                    placeholder="search"
                                // value={searchInput}
                                />
                            </div>
                            <button class="btn btn-outline-success green-button nav-item" type="submit"><Link class="nav-link" to="/search">Search</Link></button>
                        </form>
                    </div>
                </div>
            </nav>
        </>
    );
}

export default Navbar;
