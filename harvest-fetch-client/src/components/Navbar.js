import "./NavbarStyles.css";
import { Link } from "react-router-dom";

// const authButton = () => {
//     if (currentUser === null) {
//         return (
//             <div>
//                 <button variant="secondary" as={Link} to="/loginform">Login</button>
//                 <button variant="secondary" as={Link} to="/signupform">Signup</button>
//             </div>
//         )
//     } else {
//         return <button variant="secondary" onClick={handleLogoutClick}>Logout</button>
//     }
// }


function Navbar(){
    return(
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
                        <li class="nav-item"><Link class="nav-link" to="/loginform">Login</Link></li>
                        {/* <li>{authButton()}</li> */}
                    </ul>
                    <form class="d-flex bar" role="search">
                        <div class="location">
                            <input class="form-control me-2" placeholder="Where are you?" aria-label="Search"/>
                        </div>
                        <div class="search">
                            <input type="text" class="form-control me-2" placeholder="search"/>
                        </div>
                        <button class="btn btn-outline-success green-button" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        </>
        );
}

export default Navbar;
