import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom'; 

import Main from './pages/Main';
import CreateAccount from './pages/CreateAccount';
import Login from './pages/Login';
import Account from './pages/Account';
import ChangePassword from './pages/ChangePassword';

import './css/index.css';
import reportWebVitals from './reportWebVitals';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Main /> 
  },
  {
    path: "/create_account.html",
    element: <CreateAccount/>
  },
  {
    path: "/login.html",
    element: <Login />
  },
  {
    path: "/account.html",
    element: <Account />
  },
  {
    path: "/change_password.html",
    element: <ChangePassword />
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <RouterProvider router = {router} />
  </React.StrictMode>
);

reportWebVitals();
