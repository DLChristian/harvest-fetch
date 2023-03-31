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
import SignupForm from "./pages/SignupForm"

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
      <Router>
        <Navbar />
        <div>
          <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/loginform" element={<LoginForm />} />
            <Route path="/signupform" element={<SignupForm />} />
          </Routes>
        </div>
      </Router>
      </AuthContext.Provider>
    </div>
  );
}

export default App;
