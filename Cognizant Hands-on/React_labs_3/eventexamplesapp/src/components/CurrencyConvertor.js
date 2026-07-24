import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: null
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const euroValue = this.state.rupees * 0.011;
    this.setState({ euro: euroValue.toFixed(2) });
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>Enter amount in Rupees: </label>
          <input type="number" value={this.state.rupees} onChange={this.handleChange} />
          <button type="submit">Convert</button>
        </form>
        {this.state.euro !== null && (
          <h3>{this.state.rupees} INR = {this.state.euro} Euro</h3>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
