import { useNavigate } from 'react-router-dom';
import './styles.css'

function Tela() {
  const navigate = useNavigate();

  return (
   
    
    <div className="container">
      <div className="welcome-banner">
        <h1>Bem-vindo ao Restaurante Saboroso!</h1>
        <p>Experimente o melhor da culinária com a gente.</p>
      </div>
      <div className="options">
        <button className="btn" onClick={() => navigate('/cadastro')}>Ver Cardápio</button>
        <button className="btn" onClick={() => navigate('/usuarios')}>Cadastar Pratos</button>
      </div>
    </div>
  );
}

export default Tela;
