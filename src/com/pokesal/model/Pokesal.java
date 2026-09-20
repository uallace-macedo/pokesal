package com.pokesal.model;

import java.util.ArrayList;

/**
 * Representa um Pokesal com seus atributos e habilidades.
 */
public class Pokesal {

  private String nome;

  private int hp;

  private int defesa;

  private int ataque;

  private int velocidade;

  private ArrayList<Habilidade> habilidades;

  private TipoElemento tipoElemento;

  /**
   * Cria um novo Pokesal.
   *
   * @param nome nome do Pokesal
   * @param hp pontos de vida do Pokesal
   * @param defesa defesa do Pokesal
   * @param ataque ataque do Pokesal
   * @param velocidade velocidade do Pokesal
   * @param tipoElemento tipo de elemento do Pokesal
   * @param habilidades habilidades do Pokesal
   */
  public Pokesal(String nome, int hp, int defesa, int ataque, int velocidade,
      TipoElemento tipoElemento, ArrayList<Habilidade> habilidades) {
    this.nome = nome;
    this.hp = hp;
    this.defesa = defesa;
    this.ataque = ataque;
    this.velocidade = velocidade;
    this.habilidades = habilidades;
    this.tipoElemento = tipoElemento;
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
   * Retorna os pontos de vida do Pokesal.
   *
   * @return pontos de vida
   */
  public int getHp() {
    return hp;
  }

  /**
   * Retorna a defesa do Pokesal.
   *
   * @return defesa
   */
  public int getDefesa() {
    return defesa;
  }

  /**
   * Retorna o ataque do Pokesal.
   *
   * @return ataque
   */
  public int getAtaque() {
    return ataque;
  }

  /**
   * Retorna a velocidade do Pokesal.
   *
   * @return velocidade
   */
  public int getVelocidade() {
    return velocidade;
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
   * Define as habilidades do Pokesal.
   *
   * @param habilidades novas habilidades
   */
  public void setHabilidades(ArrayList<Habilidade> habilidades) {
    this.habilidades = habilidades;
  }
}