import { useState } from 'react'
import axios from 'axios'
import './styles.css'

export default function CadastroPrato() {
  const [form, setForm] = useState({
    nome: '',
    descricao: '',
    preco: '',
    categoria: '',
    disponibilidade: '',
    imagem: ''
  })

  const handleChange = (e) => {
    const { name, value } = e.target
    setForm(prev => ({ ...prev, [name]: value }))
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      await axios.post('https://sua-api.com/pratos', form)
      alert('Prato cadastrado com sucesso!')
      setForm({
        nome: '',
        descricao: '',
        preco: '',
        categoria: '',
        disponibilidade: '',
        imagem: ''
      })
    } catch (err) {
      alert('Erro ao cadastrar prato.')
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <input name="nome" placeholder="Nome do Prato" value={form.nome} onChange={handleChange} required />
      <textarea name="descricao" placeholder="Descrição" value={form.descricao} onChange={handleChange} required />
      <input name="preco" type="number" step="0.01" placeholder="Preço" value={form.preco} onChange={handleChange} required />
      <select name="categoria" value={form.categoria} onChange={handleChange} required>
        <option value="">Selecione a Categoria</option>
        <option value="Entrada">Entrada</option>
        <option value="Prato Principal">Prato Principal</option>
        <option value="Sobremesa">Sobremesa</option>
        <option value="Bebida">Bebida</option>
      </select>
      <select name="disponibilidade" value={form.disponibilidade} onChange={handleChange} required>
        <option value="">Disponibilidade</option>
        <option value="Em estoque">Em estoque</option>
        <option value="Esgotado">Esgotado</option>
      </select>
      <input name="imagem" placeholder="URL da Imagem" value={form.imagem} onChange={handleChange} required />
      <button type="submit">Cadastrar Prato</button>
    </form>
  )
}
