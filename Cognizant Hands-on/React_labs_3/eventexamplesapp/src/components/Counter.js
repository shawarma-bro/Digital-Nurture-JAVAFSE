import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      message: ''
    };
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handlePress = this.handlePress.bind(this);
  }

  incrementValue() {
    this.setState({ count: this.state.count + 1 });
  }

  sayHello() {
    this.setState({ message: 'Hello, this is a static message' });
  }

  handleIncrement() {
    this.incrementValue();
    this.sayHello();
  }

  handleDecrement() {
    this.setState({ count: this.state.count - 1 });
  }

  sayWelcome(name) {
    this.setState({ message: 'Welcome ' + name });
  }

  handlePress(event) {
    this.setState({ message: 'I was clicked' });
  }

  render() {
    return (
      <div>
        <h2>Counter Value: {this.state.count}</h2>
        <button onClick={this.handleIncrement}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
        <br /><br />
        <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
        <br /><br />
        <button onClick={this.handlePress}>Click Me</button>
        <h3>{this.state.message}</h3>
      </div>
    );
  }
}

export default Counter;
