import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PaginaCadastro from './pages/Cadastro';
import PaginaListaUsuarios from './pages/Lista';
import TelaInicial from './pages/TelaInicial';  // Certifique-se de que o nome é "Tela"

import './App.css'; // Para estilos globais, se necessário

function App() {
  return (
    <Router >
     <Routes>
        {/* Página Inicial */}
        <Route path="/" element={<TelaInicial />} />
        <Route path="/cadastro" element={<PaginaListaUsuarios />} />
        <Route path="/usuarios" element={<PaginaCadastro />} />
      </Routes>
    </Router>
  );
}

export default App;