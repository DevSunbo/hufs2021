import React from 'react';
import '../App.css';
import { Route } from 'react-router-dom';
<<<<<<< HEAD:src/main/resources/frontend/src/shared/App.js
import Home from '../page/Home';
import Login from '../page/Login';
import Join from '../page/Join';


async function App() {
  /*const [message, setMessage] = useState("");
  const response = await axios.get('http://localhots:8080/api/hello');
  setMessage(response.data);
  useEffect(() => {

  })*/
=======
import Home from './page/Home';
import Login from './page/Login';
import Join from './page/Join';
import TeamSearch from './page/TeamProjectSearch';


const App = () => {
>>>>>>> 124272b655dc281b7a9d642b9895f05999f6c5e0:src/main/resources/frontend/src/App.js
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
