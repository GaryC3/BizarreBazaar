import './App.css';
import { UserList } from './components/UserComponent';
import React from "react";
import * as ReactDOM from "react-dom";
import { BrowserRouter as Router, Route } from "react-router-dom";


export const App = () => {
  return (
    <>
      <UserList />
        <BrowserRouter>
          <Switch>
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
          </Switch>
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
