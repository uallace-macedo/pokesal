package com.pokesal.model;

import java.util.ArrayList;

public class Treinador {

    private String treinadorNome;
    private Pokesal pokesal;
    private ArrayList<Item> mochila;

    public Treinador(String treinadorNome, Pokesal pokesal, ArrayList<Item> mochila) {
        this.treinadorNome = treinadorNome;
        this.pokesal = pokesal;
        this.mochila = mochila;
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
    
    public PokeDeBatalha armarParaBatalha() {
		Pokesal pokesal = this.getPokesal();
		return new PokeDeBatalha(
			this,
			pokesal.getNome(),
			pokesal.getHp(),
			pokesal.getDefesa(),
			pokesal.getAtaque(),
			pokesal.getVelocidade(),
			pokesal.getTipoElemento(),
			pokesal.getHabilidades(),
			null
		);
	}

    @java.lang.Override
    public java.lang.String toString() {
        return "Treinador{" +
                "nome do treinador='" + treinadorNome + '\'' +
                ", pokesal='" + pokesal + '\'' +
                ", mochila=" + mochila +
                '}';
    }
}
