package com.pokesal.model;

import java.util.ArrayList;

public class PokeDeBatalha {
	
	private Treinador treinador;
	private String nome;
	private int hpMaximo;
	private int hpAtual;
	private int defesa;
	private int ataque;
	private int velocidade;
	private TipoElemento tipoElemento;
	private ArrayList<Habilidade> habilidades;
	private EfeitoAtivo efeitoAtivo;

	public PokeDeBatalha(
		Treinador treinador,
		String nome,
		int hp,
		int defesa,
		int ataque,
		int velocidade,
		TipoElemento tipoElemento,
		ArrayList<Habilidade> habilidades
	) {
		this.treinador = treinador;
		this.nome = nome;

		this.hpMaximo = hp;
		this.hpAtual = hp;
		this.defesa = defesa;
		this.ataque = ataque;
		this.velocidade = velocidade;

		this.tipoElemento = tipoElemento;
		this.habilidades = habilidades;
		this.efeitoAtivo = null;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHpMaximo() {
		return hpMaximo;
	}

	public int getHpAtual() {
		return hpAtual;
	}

	public void setHpAtual(int hpAtual) {
		this.hpAtual = hpAtual;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}

	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}

	public EfeitoAtivo getEfeitoAtivo() {
		return efeitoAtivo;
	}

	public void setEfeitoAtivo(EfeitoAtivo efeitoAtivo) {
		this.efeitoAtivo = efeitoAtivo;
	}

	public void curarTotal() {
		setHpAtual(getHpMaximo());
	}

	public void removerEfeito() {
		setEfeitoAtivo(null);
	}

	public void aumentarVelocidade(int valor) {
		setVelocidade(getVelocidade() + valor);
	}
}
