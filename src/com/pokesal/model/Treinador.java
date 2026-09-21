package com.pokesal.model;

import java.util.ArrayList;

/**
 * Representa um treinador e seus recursos no jogo.
 */
public class Treinador {

  private String treinadorNome;

  private Pokesal pokesal;

  private ArrayList<Item> mochila;

  /**
   * Cria um novo treinador.
   *
   * @param treinadorNome nome do treinador
   * @param pokesal Pokesal do treinador
   * @param mochila itens disponíveis na mochila
   */
  public Treinador(String treinadorNome, Pokesal pokesal,
      ArrayList<Item> mochila) {
    this.treinadorNome = treinadorNome;
    this.pokesal = pokesal;
    this.mochila = mochila;
  }

  /**
   * Retorna o nome do treinador.
   *
   * @return nome do treinador
   */
  public String getNome() {
    return treinadorNome;
  }

  /**
   * Define o nome do treinador.
   *
   * @param treinadorNome novo nome do treinador
   */
  public void setNome(String treinadorNome) {
    this.treinadorNome = treinadorNome;
  }

  /**
   * Retorna o Pokesal do treinador.
   *
   * @return Pokesal do treinador
   */
  public Pokesal getPokesal() {
    return pokesal;
  }

  /**
   * Define o Pokesal do treinador.
   *
   * @param pokesal novo Pokesal
   */
  public void setPokesal(Pokesal pokesal) {
    this.pokesal = pokesal;
  }

  /**
   * Retorna os itens disponíveis na mochila.
   *
   * @return lista de itens
   */
  public ArrayList<Item> getMochila() {
    return mochila;
  }

  /**
   * Define os itens disponíveis na mochila.
   *
   * @param mochila nova lista de itens
   */
  public void setMochila(ArrayList<Item> mochila) {
    this.mochila = mochila;
  }

  /**
   * Prepara o Pokesal do treinador para uma batalha.
   *
   * @return Pokesal preparado para batalha
   */
  public PokeDeBatalha armarParaBatalha() {
    final Pokesal pokesal = this.getPokesal();

    return new PokeDeBatalha(
        this,
        pokesal.getNome(),
        pokesal.getHp(),
        pokesal.getDefesa(),
        pokesal.getAtaque(),
        pokesal.getVelocidade(),
        pokesal.getTipoElemento(),
        pokesal.getHabilidades()
    );
  }

  /**
   * Retorna uma representação textual do treinador.
   *
   * @return representação textual do treinador
   */
  @Override
  public String toString() {
    return "Treinador{"
        + "nome do treinador='" + treinadorNome + '\''
        + ", pokesal='" + pokesal + '\''
        + ", mochila=" + mochila
        + '}';
  }
}