package com.pokesal;

public class Item {

    private String nome;
    private String descricao;
    private int adicionaHP;
    private boolean removeEfeito;
    private int reduzSpeed;

    public Itens(String nome, String descricao, int adicionaHP, boolean removeEfeito, int reduzSpeed) {
        this.nome = nome;
        this.descricao = descricao;
        this.adicionaHP = adicionaHP;
        this.removeEfeito = removeEfeito;
        this.reduzSpeed = reduzSpeed;
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

    public int getAdicionaHP() {
        return adicionaHP;
    }

    public void setAdicionaHP(int adicionaHP) {
        this.adicionaHP = adicionaHP;
    }

    public boolean isRemoveEfeito() {
        return removeEfeito;
    }

    public void setRemoveEfeito(boolean removeEfeito) {
        this.removeEfeito = removeEfeito;
    }

    public int getReduzSpeed() {
        return reduzSpeed;
    }

    public void setReduzSpeed(int reduzSpeed) {
        this.reduzSpeed = reduzSpeed;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Itens{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", adicionaHP=" + adicionaHP +
                ", removeEfeito=" + removeEfeito +
                ", reduzSpeed=" + reduzSpeed +
                '}';
    }
}