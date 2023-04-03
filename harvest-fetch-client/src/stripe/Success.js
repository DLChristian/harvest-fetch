import React from 'react';
import { useNavigate } from 'react-router-dom';
import "./Success.css";

function Success() {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate('/');
  };

  return (
    <div className="success-container">
      <h1 className= "success-title">Payment Successful</h1>
      <p className="success-message">Thank you for your purchase!</p>
      <p><button className="success-button" onClick={handleClick}>Return to Homepage</button></p>
    </div>
  );
}

export default Success;

