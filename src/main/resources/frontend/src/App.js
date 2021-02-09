import React from 'react';
import './App.css';
import { Route } from 'react-router-dom';
import Home from './page/Home';
import Login from './page/Login';
import Join from './page/Join';
import TeamSearch from './page/TeamProjectSearch';


async function App() {
  const [message, setMessage] = useState("");
  const response = await axios.get('http://localhots:8080/api/hello');
  setMessage(response.data);
  useEffect(() => {

  })
  return (
    <>
      <Route path="/" component={Home} exact={true} />
      <Route path="/login" component={Login}/>
      <Route path="/join" component={Join}/>
      <Route path="/team-project" component={TeamSearch} exact={true}/>
    </>
  );
}

export default App;
