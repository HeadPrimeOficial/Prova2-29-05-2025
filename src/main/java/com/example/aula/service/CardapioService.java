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

    public Cardapio atualizar(Cardapio cardapioAtualizado) {
        return cardapioRepository.findById(cardapioAtualizado.getId())
                .map(cardapio -> {
                    cardapio.setNome(cardapioAtualizado.getNome());
                    cardapio.setDescricao(cardapioAtualizado.getDescricao());
                    cardapio.setPreco(cardapioAtualizado.getPreco());
                    cardapio.setCategoria(cardapioAtualizado.getCategoria());
                    cardapio.setDisponibilidade(cardapioAtualizado.getDisponibilidade());
                    cardapio.setUrlImagem(cardapioAtualizado.getUrlImagem());
                    return cardapioRepository.save(cardapio);
                })
                .orElseThrow(() -> new RuntimeException("Prato não encontrado com ID: " + cardapioAtualizado.getId()));
    }


    public void deletar(Long id) {
        cardapioRepository.deleteById(id);
    }
}
