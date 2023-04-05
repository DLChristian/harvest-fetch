import './App.css';
import { useState, useEffect} from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import { refresh } from "./services/authService";
import AuthContext from "./contexts/AuthContext";
import LoginForm from "./pages/LoginForm";
import SignupForm from "./pages/SignupForm";
import Footer from './components/Footer';
import Terms from './components/Terms';
import FAQ from './components/FAQ';
import Farmer from './pages/Farmer';
import ContactUs from './components/ContactUs';
import FarmerProfile from './pages/FarmerProfile';
import Cart from './components/Cart';
import Success from './stripe/Success.js';
import Error from './stripe/Error.js';
import FarmerProfileTest from './components/test/FarmerProfileTest';
import FarmerFormTest from './components/test/FarmerFormTest';
import  CartContextProvider  from './contexts/CartContext';
import Search from './pages/Search';

function App() {

  const [appUser, setAppUser] = useState();

  useEffect(() => {
    refresh().then(login).catch();
  }, [])

  function login(appUserArg) {
    setAppUser(appUserArg);
    localStorage.setItem("HF_JWT", appUserArg.jwt);
  }

  function logout() {
    setAppUser();
    localStorage.removeItem("HF_JWT");
  }

  const auth = {
    appUser,
    login,
    logout

  };

  return (
    
    <div className="App">
      <AuthContext.Provider value={auth}>
        <CartContextProvider >
          <Router>
            <Navbar />
            <div>
              <Routes>
                <Route path="/" element={<Home />}/>
                <Route path="/loginform" element={<LoginForm />} />
                <Route path="/farmers" element={<Farmer />}/>
                <Route path="/signupform" element={<SignupForm />} />
                <Route path="/farmerform" element={<FarmerFormTest />} />
                <Route path="/farmerProfile/:farmerId" element={<FarmerProfile />}/>
                <Route path="/cart" element={<Cart />} />
                <Route path="/success" element={<Success />} />
                <Route path="/error" element={<Error />} />
                <Route path="/terms" element={<Terms />} />
                <Route path="/faq" element={<FAQ />} />
                <Route path ="/contact" element={<ContactUs />} />
                <Route path ="/profiletest" element={<FarmerProfileTest />} />
                <Route path ="/search" element={<Search />} />
              </Routes>
            </div>
            <Footer />
          </Router>
        </CartContextProvider>  
      </AuthContext.Provider>
    </div>
  );
}

export default App;
