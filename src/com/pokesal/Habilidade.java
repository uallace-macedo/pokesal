package com.pokesal;

public class Habilidade {
	
	private String nome;
	private double dano;
	private TipoHabilidades tipoHabilidade;
	private double ativacaoDeEfeito = 0.8;
	private EfeitoAtk efeitoAtk;
	
	public Habilidade(String nome, double dano, TipoHabilidades tipoHabilidade, double ativacaoDeEfeito, EfeitoAtk efeitoAtk) {
		this.nome = nome;
		this.dano = dano;
		this.tipoHabilidade = tipoHabilidade;
		this.ativacaoDeEfeito = ativacaoDeEfeito;
		this.efeitoAtk = efeitoAtk;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getDano() {
		return dano;
	}
	
	public void setDano(double dano) {
		this.dano = dano;
	}
	
	public TipoHabilidades getTipoHabilidade() {
		return tipoHabilidade;
	}
	
	public void setTipoHabilidade(TipoHabilidades tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}
	
	public double getAtivacaoDeEfeito() {
		return ativacaoDeEfeito;
	}
	
	public void setAtivacaoDeEfeito(double ativacaoDeEfeito) {
		this.ativacaoDeEfeito = ativacaoDeEfeito;
	}


	public EfeitoAtk getEfeitoAtk() {
		return efeitoAtk;
	}

	public void setEfeitoAtk(EfeitoAtk efeitoAtk) {
		this.efeitoAtk = efeitoAtk;
	}
}
