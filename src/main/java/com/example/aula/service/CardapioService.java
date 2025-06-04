package com.example.aula.service;
import com.example.aula.repository.CardapioRepository;
import com.example.aula.model.Cardapio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    public List<Cardapio> listarTodos() {
        return cardapioRepository.findAll();
    }

    public Optional<Cardapio> buscarPorId(Long id) {
        return cardapioRepository.findById(id);
    }

    public Cardapio salvar(Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    public Cardapio atualizar(Long id) {
        return cardapioRepository.findById(id)
                .map(cardapio -> {
                    cardapio.setNome(cardapio.getNome());
                    cardapio.setDescricao(cardapio.getDescricao());
                    cardapio.setPreco(cardapio.getPreco());
                    cardapio.setCategoria(cardapio.getCategoria());
                    cardapio.setDisponibilidade(cardapio.getDisponibilidade());
                    cardapio.setUrlImagem(cardapio.getUrlImagem());
                    return cardapioRepository.save(cardapio);
                }).orElseThrow(() -> new RuntimeException("Prato não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        cardapioRepository.deleteById(id);
    }
}
