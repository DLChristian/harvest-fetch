import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Footer from './components/Footer';
import Terms from './components/Terms';
import FAQ from './components/FAQ';
import ContactUs from './components/ContactUs';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <div>
          <Routes>
            <Route path="/" element={<Home />}/>
            <Route path="/terms" element={<Terms />} />
            <Route path="/faq" element={<FAQ />} />
            <Route path ="/contact" element={<ContactUs />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
