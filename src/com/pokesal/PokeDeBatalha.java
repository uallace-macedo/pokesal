package com.pokesal;

import java.util.ArrayList;

public class PokeDeBatalha {
	
	private Treinador treinador;
	private String nome;
	private int hp;
	private int defesa;
	private int ataque;
	private int velocidade;
	private TipoElemento tipoElemento;
	private ArrayList<Habilidade> habilidades;
	private EfeitoAtk efeitoatk;

	public PokeDeBatalha(Treinador treinador, String nome, int hp, int defesa, int ataque, int velocidade,
			TipoElemento tipoElemento, ArrayList<Habilidade> habilidades, EfeitoAtk efeitoatk) {
		super();
		this.treinador = treinador;
		this.nome = nome;
		this.hp = hp;
		this.defesa = defesa;
		this.ataque = ataque;
		this.velocidade = velocidade;
		this.tipoElemento = tipoElemento;
		this.habilidades = habilidades;
		this.efeitoatk = efeitoatk;
	}
	
	public void usarItem(Item item) {
		setHp(getHp() + item.getAdicionaHP());
		setVelocidade(getVelocidade() + item.getAumentaSpeed());
		if (item.isRemoveEfeito()) {
				setEfeitoatk(null);
		}
    	treinador.getMochila().remove(item);
	}

	public PokeDeBatalha pegarPokeDeBatalha(Treinador treinador){
		Pokesal pokesal = treinador.getPokesal();
		return.treinadorPokesal = new PokeDeBatalha(
			treinador,
			pokesal.getNome();
			pokesal.getHp();
			pokesal.getDefesa();
			pokesal.getAtaque();
			pokesal.getTipoElemento();
			pokesal.getHabilidade();
			null;

		);
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
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
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
}
