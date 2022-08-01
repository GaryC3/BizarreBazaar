import './App.css';
// import { UserList } from './components/UserComponent';
import React from "react";
import { BrowserRouter, Route, Routes} from "react-router-dom";

import { Home, Merchant, Purchase, Confirmation, SignUp, OwnedGames} from "./pages";


export const App = () => {
  return (
    <>
      {/* <UserList /> */}
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/merchant" element={<Merchant />} />
            <Route path="purchase" element={<Purchase />} />
            <Route path="/confirmation" element={<Confirmation />} />
            <Route path="/sign" element={<SignUp />} />
            <Route path="owned" element={<OwnedGames />} />
          </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}


//If you want to use the default react setup, uncomment below

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;
