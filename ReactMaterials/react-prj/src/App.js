import { createContext, useState } from 'react';
import './App.css';
import Parent from './components/Parent';

export const MyContext = createContext();
function App() {
  let str = 'hello';
  const [number, setNumber] = useState(0);
  return (
    <div>
      <MyContext.Provider value={{str, number, setNumber, str1:'하하하'}}>
        <Parent/>
      </MyContext.Provider>
    </div>
  );
}

export default App;
