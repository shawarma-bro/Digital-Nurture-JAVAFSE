import React, { Component } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import LoginControl from './components/LoginControl';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
  }

  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    return (
      <div>
        <h1>Ticket Booking App</h1>
        <LoginControl
          isLoggedIn={this.state.isLoggedIn}
          handleLoginClick={this.handleLoginClick}
          handleLogoutClick={this.handleLogoutClick}
        />
        {this.state.isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default App;
