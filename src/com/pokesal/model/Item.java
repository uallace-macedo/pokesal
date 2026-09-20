package com.pokesal.model;

public class Item {

    private String nome;
    private String descricao;
    private TipoEfeitoItem tipoEfeito;
    private int valor;
    
    public Item(String nome, String descricao, TipoEfeitoItem tipoEfeito, int valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoEfeito = tipoEfeito;
        this.valor = valor;
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

    public TipoEfeitoItem getTipoEfeito() {
        return tipoEfeito;
    }

    public void setTipoEfeito(TipoEfeitoItem tipoEfeito) {
        this.tipoEfeito = tipoEfeito;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}