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
	private EfeitoAtk efeitoatk;

	public PokeDeBatalha(
		Treinador treinador,
		String nome,
		int hp,
		int defesa,
		int ataque,
		int velocidade,
		TipoElemento tipoElemento,
		ArrayList<Habilidade> habilidades,
		EfeitoAtk efeitoatk
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
		this.efeitoatk = efeitoatk;
	}

	public void atacar(PokeDeBatalha alvo, Habilidade habilidade) {

		double multiplicador = 1.0;

		TipoHabilidades tipoAtaque = habilidade.getTipoHabilidade();
		TipoElemento tipoAlvo = alvo.getTipoElemento();

		if (tipoAtaque == TipoHabilidades.FOGO) {
			if (tipoAlvo == TipoElemento.PLANTA) {
				multiplicador = 2.0;
			}
			else if (tipoAlvo == TipoElemento.AGUA) {
				multiplicador = 0.5;
			}
		}
		else if (tipoAtaque == TipoHabilidades.AGUA){
			if (tipoAlvo == TipoElemento.PLANTA){
				multiplicador = 0.5;
			}
			else if (tipoAlvo == TipoElemento.FOGO){
				multiplicador = 2.0;
			}
		}
		else if (tipoAtaque == TipoHabilidades.PLANTA){
			if (tipoAlvo == TipoElemento.AGUA){
				multiplicador = 2.0;
			}
			else if (tipoAlvo == TipoElemento.FOGO){
				multiplicador = 0.5;
			}
		}

		double dano = (habilidade.getDano() * multiplicador) - (alvo.getDefesa() / 2.0);

		if (dano < 1) {
			dano = 1;
		}

		int novoHp = (int) (alvo.getHpAtual() - dano);
		if (novoHp < 0){
			novoHp = 0;
		}
		alvo.setHpAtual(novoHp);

	}
	
	public void usarItem(Item item) {
		switch (item.getTipoEfeito()) {
			case CURA_TOTAL:
				setHpAtual(getHpMaximo());	
				break;

			case REMOVE_EFEITO:
				setEfeitoatk(null);
				break;

			case AUMENTA_SPEED:
				setVelocidade(getVelocidade() + item.getValor());
				break;
		}

		treinador.getMochila().remove(item);
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
	
	public void setTipoElemento(TipoElemento tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	
	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(ArrayList<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
	public EfeitoAtk getEfeitoatk() {
		return efeitoatk;
	}
	
	public void setEfeitoatk(EfeitoAtk efeitoatk) {
		this.efeitoatk = efeitoatk;
	}

	public int getHpMaximo() {
		return hpMaximo;
	}

	public void setHpMaximo(int hpMaximo) {
		this.hpMaximo = hpMaximo;
	}

	public int getHpAtual() {
		return hpAtual;
	}

	public void setHpAtual(int hpAtual) {
		this.hpAtual = hpAtual;
	}
}
