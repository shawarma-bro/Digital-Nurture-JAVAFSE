import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const average = props.total / props.goal;

  return (
    <div className="score-box">
      <h2>Student Score Calculator</h2>
      <p>Name: {props.name}</p>
      <p>School: {props.school}</p>
      <p>Total Marks: {props.total}</p>
      <p>Number of Subjects: {props.goal}</p>
      <p>Average Score: {average}</p>
    </div>
  );
}

export default CalculateScore;
