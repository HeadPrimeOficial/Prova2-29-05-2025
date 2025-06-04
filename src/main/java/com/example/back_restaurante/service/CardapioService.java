package com.example.back_restaurante.service;

import com.example.back_restaurante.model.Cardapio;
import com.example.back_restaurante.repository.CardapioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class CardapioService {
    private CardapioRepository cardapioRepository;

    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public List<Cardapio> listarTodos() {
        return cardapioRepository.findAll();
    }

    public Cardapio salvar(@Valid Cardapio cardapio) {
        if (cardapioRepository.findByNome(cardapio.getNome()).isPresent()) {
            throw new RuntimeException("Prato já cadastrado!");
        }

        return cardapioRepository.save(cardapio);
    }

    public Cardapio atualizar(@Valid Cardapio cardapio) {
        Cardapio cardapioAtualizar = cardapioRepository.findByNome(cardapio.getNome()).orElseThrow(() -> new IllegalArgumentException("Prato não encontrado!"));

        cardapioAtualizar.setNome(cardapio.getNome());
        cardapioAtualizar.setDescricao(cardapio.getDescricao());
        cardapioAtualizar.setPreco(cardapio.getPreco());
        cardapioAtualizar.setCategoria(cardapio.getCategoria());
        cardapioAtualizar.setDisponibilidade(cardapio.getDisponibilidade());
        cardapioAtualizar.setUrlImagem(cardapio.getUrlImagem());

        return  cardapioRepository.save(cardapioAtualizar);
    }

    public void deletar(Long id) {
        Cardapio cardapioDeletar = cardapioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Prato não encontrado "));

        cardapioRepository.deleteById(cardapioDeletar.getId());
    }
}
