import React from 'react';

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

function LoginControl(props) {
  if (props.isLoggedIn) {
    return <LogoutButton onClick={props.handleLogoutClick} />;
  }
  return <LoginButton onClick={props.handleLoginClick} />;
}

export default LoginControl;
