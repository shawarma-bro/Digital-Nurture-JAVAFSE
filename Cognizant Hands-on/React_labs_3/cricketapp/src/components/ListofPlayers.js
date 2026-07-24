import React from 'react';

const players = [
  { name: 'Rohit Sharma', score: 85 },
  { name: 'Virat Kohli', score: 92 },
  { name: 'KL Rahul', score: 45 },
  { name: 'Shreyas Iyer', score: 60 },
  { name: 'Rishabh Pant', score: 78 },
  { name: 'Hardik Pandya', score: 55 },
  { name: 'Ravindra Jadeja', score: 40 },
  { name: 'Jasprit Bumrah', score: 30 },
  { name: 'Mohammed Shami', score: 25 },
  { name: 'Kuldeep Yadav', score: 65 },
  { name: 'Ishan Kishan', score: 72 }
];

function ListofPlayers() {
  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with Score Below 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
