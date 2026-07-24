import React from 'react';

const teamPlayers = ['Rohit', 'Virat', 'Rahul', 'Pant', 'Hardik', 'Jadeja', 'Bumrah', 'Shami'];

const [oddPlayer1, evenPlayer1, oddPlayer2, evenPlayer2, oddPlayer3, evenPlayer3, oddPlayer4, evenPlayer4] = teamPlayers;

const oddTeamPlayers = [oddPlayer1, oddPlayer2, oddPlayer3, oddPlayer4];
const evenTeamPlayers = [evenPlayer1, evenPlayer2, evenPlayer3, evenPlayer4];

const T20players = ['Rohit', 'Virat', 'Rahul', 'Pant'];
const RanjiTrophyPlayers = ['Prithvi', 'Mayank', 'Shreyas', 'Ishan'];
const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

function IndianPlayers() {
  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        {oddTeamPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenTeamPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>T20 Players</h2>
      <ul>
        {T20players.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Ranji Trophy Players</h2>
      <ul>
        {RanjiTrophyPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Merged Players</h2>
      <ul>
        {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
}

export default IndianPlayers;
