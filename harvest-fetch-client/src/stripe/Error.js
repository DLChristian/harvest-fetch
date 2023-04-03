import React from 'react';
import { useNavigate } from 'react-router-dom';

function Error() {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate('/cart');
  };

  return (
    <div>
      <h1>Payment Error</h1>
      <p>There was an error processing your payment.</p>
      <p><button onClick={handleClick}>Return to Cart</button></p>
    </div>
  );
}

export default Error;
