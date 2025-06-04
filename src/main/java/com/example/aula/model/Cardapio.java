package com.example.aula.model;


import jakarta.persistence.*;

@Entity
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private com.example.aula.model.categoria categoria;

    @Enumerated(EnumType.STRING)
    private com.example.aula.model.disponibilidade disponibilidade;

    private String urlImagem;

    // CONSTRUTOR VAZIO PARA O JACKSON
    public Cardapio() {
    }

    public Cardapio(Long id) {
        this.id = id;
    }

    public Cardapio(Long id, String nome, String descricao, Double preco, com.example.aula.model.categoria categoria, com.example.aula.model.disponibilidade disponibilidade, String urlImagem) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public com.example.aula.model.categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(com.example.aula.model.categoria categoria) {
        this.categoria = categoria;
    }

    public com.example.aula.model.disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(com.example.aula.model.disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    // getters e setters ...
}
