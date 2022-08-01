import './App.css';
import { UserList } from './components/UserComponent';
import React from "react";
import { BrowserRouter, Route} from "react-router-dom";

import { Home, Merchant, Purchase, Confirmation, SignUp, OwnedGames} from "./pages";


export const App = () => {
  return (
    <>
      <UserList />
        <BrowserRouter>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/merchant">
              <Merchant />
            </Route>
            <Route path="/purchase">
              <Purchase />
            </Route>
            <Route path="/confirmation">
              <Confirmation />
            </Route>
            <Route path="/sign">
              <SignUp />
            </Route>
            <Route path="/owned">
              <OwnedGames />
            </Route>
        </BrowserRouter>
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
