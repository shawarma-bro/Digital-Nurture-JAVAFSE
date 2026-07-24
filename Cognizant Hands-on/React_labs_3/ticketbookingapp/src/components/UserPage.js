import React from 'react';

function UserPage() {
  return (
    <div>
      <h2>Welcome back!</h2>
      <p>You can now book your flight tickets</p>
      <ul>
        <li>Indigo 6E-202 - Chennai to Delhi - 10:00 AM <button>Book</button></li>
        <li>Air India AI-440 - Mumbai to Bangalore - 1:30 PM <button>Book</button></li>
        <li>SpiceJet SG-123 - Delhi to Kolkata - 5:00 PM <button>Book</button></li>
      </ul>
    </div>
  );
}

export default UserPage;
