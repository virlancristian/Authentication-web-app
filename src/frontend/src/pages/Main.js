import { useLocation } from 'react-router-dom';

import Header from '../components/header/Header.js'
import Home from '../components/home/Home.js';

const Main = () => {
  const location = useLocation();
  const username = location.state?.username || null;

  return (
    <>
    <Header username={username}/>
    <Home username={username}/>
    </>
  );
}

export default Main;
