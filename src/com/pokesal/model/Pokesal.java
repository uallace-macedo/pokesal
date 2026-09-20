package com.pokesal.model;

import java.util.ArrayList;

public class Pokesal {
	private String nome;
	private int hp;
	private int defesa;
	private int ataque;
	private int velocidade;
	private ArrayList<Habilidade> habilidades;
	
	private TipoElemento tipoElemento;
	
	public Pokesal(String nome, int hp, int defesa, int ataque, int velocidade, TipoElemento tipoElemento, ArrayList<Habilidade> habilidades) {
		this.nome = nome;
		this.hp = hp;
		this.defesa = defesa;
		this.ataque = ataque;
		this.velocidade = velocidade;
		this.habilidades = habilidades;
		this.tipoElemento = tipoElemento;
	}

	public String getNome() {
		return nome;
	}

	public int getHp() {
		return hp;
	}

	public int getDefesa() {
		return defesa;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}

	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
}
