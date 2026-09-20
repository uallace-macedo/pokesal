package com.pokesal.model;

/**
 * Representa um efeito de ataque ativo durante uma batalha.
 */
public class EfeitoAtivo {

  private EfeitoAtk efeito;

  private int rodadasRestantes;

  /**
   * Cria um efeito ativo a partir de um efeito de ataque.
   *
   * @param efeito efeito de ataque a ser ativado
   */
  public EfeitoAtivo(EfeitoAtk efeito) {
    this.efeito = efeito;
    this.rodadasRestantes = efeito.getRodadas();
  }

  /**
   * Retorna o efeito de ataque ativo.
   *
   * @return efeito de ataque
   */
  public EfeitoAtk getEfeito() {
    return efeito;
  }

  /**
   * Retorna a quantidade de rodadas restantes do efeito.
   *
   * @return quantidade de rodadas restantes
   */
  public int getRodadasRestantes() {
    return rodadasRestantes;
  }

  /**
   * Diminui em uma unidade a quantidade de rodadas restantes.
   */
  public void diminuirRodada() {
    rodadasRestantes--;
  }
}