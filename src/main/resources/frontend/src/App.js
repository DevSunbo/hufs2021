// import _ from './logo.svg';
import React from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Home from './page/Home';
import Login from './page/Login';

const App = () => {
  return (
    <>
      <Route path="/" component={Home} exact={true} />
      <Route path="/login" component={Login}/>
    </>
  );
}

export default App;
