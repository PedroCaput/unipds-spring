package br.com.nomedaempresa.iniciandojava.model;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private Double preco;
    private String nome;

    public Produto(int id, Double preco, String nome) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
    }
    public Produto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
