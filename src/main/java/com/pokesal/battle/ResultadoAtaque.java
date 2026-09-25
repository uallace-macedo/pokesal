package com.pokesal.battle;

import com.pokesal.model.Habilidade;
import com.pokesal.model.PokeDeBatalha;

/**
 * Representa o resultado de um ataque realizado durante uma batalha.
 */
public class ResultadoAtaque {

  private PokeDeBatalha atacante;

  private PokeDeBatalha alvo;

  private Habilidade habilidade;

  private int dano;

  private int hpRestante;

  /**
   * Cria um resultado para um ataque realizado.
   *
   * @param atacante Pokesal que realizou o ataque
   * @param alvo Pokesal que recebeu o ataque
   * @param habilidade habilidade utilizada no ataque
   * @param dano dano causado pelo ataque
   * @param hpRestante pontos de vida restantes do alvo
   */
  public ResultadoAtaque(PokeDeBatalha atacante, PokeDeBatalha alvo,
      Habilidade habilidade, int dano, int hpRestante) {
    this.atacante = atacante;
    this.alvo = alvo;
    this.habilidade = habilidade;
    this.dano = dano;
    this.hpRestante = hpRestante;
  }

  /**
   * Retorna o Pokesal atacante.
   *
   * @return atacante
   */
  public PokeDeBatalha getAtacante() {
    return atacante;
  }

  /**
   * Retorna o Pokesal alvo.
   *
   * @return alvo
   */
  public PokeDeBatalha getAlvo() {
    return alvo;
  }

  /**
   * Retorna a habilidade utilizada.
   *
   * @return habilidade utilizada
   */
  public Habilidade getHabilidade() {
    return habilidade;
  }

  /**
   * Retorna o dano causado.
   *
   * @return dano causado
   */
  public int getDano() {
    return dano;
  }

  /**
   * Retorna os pontos de vida restantes do alvo.
   *
   * @return pontos de vida restantes
   */
  public int getHpRestante() {
    return hpRestante;
  }
}