import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore name="Ravi Kumar" school="Green Valley School" total={450} goal={5} />
    </div>
  );
}

export default App;
