import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Cart.css';

function Cart() {
  const [orderItems, setOrderItems] = useState([]);
  const navigate = useNavigate();

  
  const handleRemoveFromCart = (orderItem) => {
    const updatedOrderItems = orderItems.filter((i) => i.id !== orderItem.id);
    setOrderItems(updatedOrderItems);
  };

  const handleCheckout = async () => {
    const displayOrderItems = orderItems.map((i) => ({ priceCode: i.priceCode, quantity: i.quantity }));
    const config = {
      method: 'POST',
      body: JSON.stringify(displayOrderItems),
      headers: {
        'Content-Type': 'application/json',
      },
    };

    const response = await fetch('/api/create/session', config);

    if (response.ok) {
      const url = await response.text();
      window.location.href= url;
    } else {
      navigate('/error');
    }
  };

  const total = orderItems.reduce((acc, orderItem) => acc + orderItem.price * orderItem.quantity, 0);

  return (
    <div className="cart-container">
      <h1 className="cart-title">Shopping Cart</h1>
      <h3 className="cart-subtitle">Your Items</h3>
      <ul className="cart-items">
        {orderItems.map((orderItem) => (
          <li key={orderItem.id}>
            {orderItem.name} - ${orderItem.price} - {orderItem.quantity}{' '}
            <button onClick={() => handleRemoveFromCart(orderItem)}>Remove</button>
          </li>
        ))}
      </ul>
      <div>
        <p className="cart-total">Total: ${total.toFixed(2)}</p>
        <button className="cart-checkout-btn" onClick={handleCheckout}>Checkout</button>
        <button className ="cart-continue-shopping" onClick={() => navigate('/')}>Continue Shopping</button>
      </div>
    </div>
  );
}

export default Cart