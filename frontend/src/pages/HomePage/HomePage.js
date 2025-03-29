import React from 'react';
import './HomePage.css';

const HomePage = () => {
  return (
    <div className="home-container">
      <div className="content">
        <div className="header">
          <h1>IRSystem</h1>
        </div>
        <div className="buttons-container">
          <button 
            className="action-button"
            onClick={() => console.log('Add business clicked')}
          >
            Add business
          </button>
          <button 
            className="action-button"
            onClick={() => console.log('Access business clicked')}
          >
            Access business
          </button>
        </div>
      </div>
    </div>
  );
};

export default HomePage; 