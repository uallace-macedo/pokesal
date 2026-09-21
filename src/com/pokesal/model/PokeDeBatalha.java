package com.pokesal.model;

import java.util.ArrayList;

/**
 * Representa um Pokesal preparado para participar de uma batalha.
 */
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

  /**
   * Cria um Pokesal preparado para uma batalha.
   *
   * @param treinador treinador responsável pelo Pokesal
   * @param nome nome do Pokesal
   * @param hp pontos de vida do Pokesal
   * @param defesa defesa do Pokesal
   * @param ataque ataque do Pokesal
   * @param velocidade velocidade do Pokesal
   * @param tipoElemento tipo de elemento do Pokesal
   * @param habilidades habilidades disponíveis para o Pokesal
   */
  public PokeDeBatalha(Treinador treinador, String nome, int hp, int defesa,
      int ataque, int velocidade, TipoElemento tipoElemento,
      ArrayList<Habilidade> habilidades) {
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

  /**
   * Retorna o treinador responsável pelo Pokesal.
   *
   * @return treinador responsável
   */
  public Treinador getTreinador() {
    return treinador;
  }

  /**
   * Define o treinador responsável pelo Pokesal.
   *
   * @param treinador novo treinador responsável
   */
  public void setTreinador(Treinador treinador) {
    this.treinador = treinador;
  }

  /**
   * Retorna o nome do Pokesal.
   *
   * @return nome do Pokesal
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome do Pokesal.
   *
   * @param nome novo nome do Pokesal
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Retorna os pontos de vida máximos do Pokesal.
   *
   * @return pontos de vida máximos
   */
  public int getHpMaximo() {
    return hpMaximo;
  }

  /**
   * Retorna os pontos de vida atuais do Pokesal.
   *
   * @return pontos de vida atuais
   */
  public int getHpAtual() {
    return hpAtual;
  }

  /**
   * Define os pontos de vida atuais do Pokesal.
   *
   * @param hpAtual novos pontos de vida atuais
   */
  public void setHpAtual(int hpAtual) {
    this.hpAtual = hpAtual;
  }

  /**
   * Retorna a defesa do Pokesal.
   *
   * @return defesa do Pokesal
   */
  public int getDefesa() {
    return defesa;
  }

  /**
   * Define a defesa do Pokesal.
   *
   * @param defesa nova defesa
   */
  public void setDefesa(int defesa) {
    this.defesa = defesa;
  }

  /**
   * Retorna o ataque do Pokesal.
   *
   * @return ataque do Pokesal
   */
  public int getAtaque() {
    return ataque;
  }

  /**
   * Define o ataque do Pokesal.
   *
   * @param ataque novo ataque
   */
  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  /**
   * Retorna a velocidade do Pokesal.
   *
   * @return velocidade do Pokesal
   */
  public int getVelocidade() {
    return velocidade;
  }

  /**
   * Define a velocidade do Pokesal.
   *
   * @param velocidade nova velocidade
   */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  /**
   * Retorna o tipo de elemento do Pokesal.
   *
   * @return tipo de elemento
   */
  public TipoElemento getTipoElemento() {
    return tipoElemento;
  }

  /**
   * Retorna as habilidades do Pokesal.
   *
   * @return lista de habilidades
   */
  public ArrayList<Habilidade> getHabilidades() {
    return habilidades;
  }

  /**
   * Retorna o efeito ativo no Pokesal.
   *
   * @return efeito ativo
   */
  public EfeitoAtivo getEfeitoAtivo() {
    return efeitoAtivo;
  }

  /**
   * Define o efeito ativo no Pokesal.
   *
   * @param efeitoAtivo novo efeito ativo
   */
  public void setEfeitoAtivo(EfeitoAtivo efeitoAtivo) {
    this.efeitoAtivo = efeitoAtivo;
  }

  /**
   * Restaura os pontos de vida do Pokesal ao máximo.
   */
  public void curarTotal() {
    setHpAtual(getHpMaximo());
  }

  /**
   * Remove o efeito ativo do Pokesal.
   */
  public void removerEfeito() {
    setEfeitoAtivo(null);
  }

  /**
   * Aumenta a velocidade do Pokesal.
   *
   * @param valor valor a ser acrescentado à velocidade
   */
  public void aumentarVelocidade(int valor) {
    setVelocidade(getVelocidade() + valor);
  }
}