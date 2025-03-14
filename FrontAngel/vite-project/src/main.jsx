import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import { BrowserRouter } from 'react-router-dom';
import Modal from 'react-modal';

// Asegúrate de que el appElement se configure antes de renderizar
Modal.setAppElement('#root');

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </BrowserRouter>
);
