import React from 'react';
import '../App.css';
import { Route } from 'react-router-dom';
import Home from "../page/Home";
import Login from "../page/Login";
import Join from "../page/Join";
import TeamSearch from "../page/TeamProjectSearch";


const App = () => {
  return (
    <>
      <Route path="/" component={Home} exact={true} />
      <Route path="/login" component={Login}/>
      <Route path="/join" component={Join}/>
      <Route path="/team-project" component={TeamSearch} exact={true}/>

        {/*Asset*/}
    </>
  );
}

export default App;
