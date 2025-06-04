package com.example.back_restaurante.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@RequestMapping("/Cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do prato é obrigatório.")
    private String nome;

    @NotBlank(message = "A descrição do pedido é obrigatório.")
    private String descricao;


    private Double preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @NotBlank(message = "A imagem do prato é obrigatório.")
    private String urlImagem;


    public Cardapio() {
    }

    public Cardapio(Long id, String nome, String descricao, Double preco, Categoria categoria, Disponibilidade disponibilidade, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
        this.urlImagem = urlImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome do prato é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome do prato é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A descrição do pedido é obrigatório.") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição do pedido é obrigatório.") String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public @NotBlank(message = "A imagem do prato é obrigatório.") String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(@NotBlank(message = "A imagem do prato é obrigatório.") String urlImagem) {
        this.urlImagem = urlImagem;
    }
}