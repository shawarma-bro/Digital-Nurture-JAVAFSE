import React from 'react';

const office = {
  name: 'Prestige Business Park',
  rent: 55000,
  address: 'MG Road, Bangalore'
};

const officeSpaces = [
  { name: 'Prestige Business Park', rent: 55000, address: 'MG Road, Bangalore' },
  { name: 'DLF Cyber City', rent: 75000, address: 'Gurugram, Haryana' },
  { name: 'RMZ Ecoworld', rent: 62000, address: 'Bellandur, Bangalore' },
  { name: 'One Indiabulls Centre', rent: 48000, address: 'Lower Parel, Mumbai' },
  { name: 'Godrej BKC', rent: 90000, address: 'Bandra Kurla Complex, Mumbai' }
];

const headingElement = React.createElement('h1', null, 'Office Space Rental');

function App() {
  return (
    <div>
      {headingElement}
      <img src="https://via.placeholder.com/400x200" alt="office space" width="400" />

      <h2>Featured Office</h2>
      <p>Name: {office.name}</p>
      <p>Address: {office.address}</p>
      <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>Rent: {office.rent}</p>

      <h2>All Office Spaces</h2>
      <ul>
        {officeSpaces.map((space, index) => (
          <li key={index}>
            {space.name} - {space.address} -{' '}
            <span style={{ color: space.rent < 60000 ? 'red' : 'green' }}>
              Rent: {space.rent}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
