package com.pokesal;

import java.util.ArrayList;

public class Treinador {

    private String treinadorNome;
    private Pokesal pokesal;
    private ArrayList<Item> mochila;
    private int itensUsados;

    public Treinador(String treinadorNome, Pokesal pokesal, ArrayList<Item> mochila) {
        this.treinadorNome = treinadorNome;
        this.pokesal = pokesal;
        this.mochila = mochila;
        this.itensUsados = 0;
    }

    public int getItensUsados() {
        return itensUsados;
    }

    public boolean podeUsarItem() {
        return itensUsados < 2;
    }

    public void usarItem(Item item) {
        if (!podeUsarItem()) {
            System.err.println("Número de Itens Usáveis Excedidos");
        } else {
            pokesal.setHp(pokesal.getHp() + item.getAdicionaHP());
            pokesal.setVelocidade(pokesal.getVelocidade() + item.getAumentaSpeed());
            if (item.isRemoveEfeito()) {
                pokesal.setEfeitoAtivo(null);
            }
            itensUsados++;
            mochila.remove(item);
        }
    }

    public String getNome() {
        return treinadorNome;
    }

    public void setNome(String treinadorNome) {
        this.treinadorNome = treinadorNome;
    }

    public Pokesal getPokesal() {
        return pokesal;
    }

    public void setPokesal(Pokesal pokesal) {
        this.pokesal = pokesal;
    }

    public ArrayList<Item> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Item> mochila) {
        this.mochila = mochila;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Treinador{" +
                "nome do treinador='" + treinadorNome + '\'' +
                ", pokesal='" + pokesal + '\'' +
                ", mochila=" + mochila +
                ", itensUsados=" + itensUsados +
                '}';
    }
}