package com.example.back_restaurante.repository;

import com.example.back_restaurante.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
    Optional<Cardapio> findByNome(String nome);
}
