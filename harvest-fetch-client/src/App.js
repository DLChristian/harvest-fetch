import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <div>
          <Routes>
            <Route path="/" element={<Home />}/>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
