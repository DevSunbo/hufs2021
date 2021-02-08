import logo from './logo.svg';
import React, {Component, useState, useEffect} from "react";
import './App.css';
import axios from 'axios';

axios.get('/api/hello')

async function App() {
  const [message, setMessage] = useState("");
  const response = await axios.get('http://localhots:8080/api/hello');
  setMessage(response.data);
  useEffect(() => {

  })
  return (
      <div>안녕하세요</div>
  );
}

export default App;
