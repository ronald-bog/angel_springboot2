import './styles.scss';
import { Navigate, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Seccion from './components/Seccion';
import Secciont from './components/Secciont';

function App() {

  return (
    <>
      <Header />
      <Routes>
        <Route path='/' element={<Seccion />} />
        <Route path='secciont' element={<Secciont />} />
        <Route path='/*' element={<Navigate to='/' />} />
      </Routes>
      <Footer />

    </>
  );
}

export default App;



{/*       <Header />
      <Routes>
        <Route path='/' element={<Seccion />} />
        <Route path='seccion1' element={<Secciont />} />
        <Route path='/*' element={<Navigate to='/' />} />
      </Routes>
      <Footer /> */}