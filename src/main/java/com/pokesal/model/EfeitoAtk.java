package com.pokesal.model;

/**
 * Representa um efeito causado por uma habilidade de ataque.
 */
public class EfeitoAtk {

  private String nome;

  private int dano;

  private int redSpeed;

  private int redDef;

  private int rodadas;

  /**
   * Cria um novo efeito de ataque.
   *
   * @param nome nome do efeito
   * @param dano dano causado pelo efeito
   * @param redSpeed redução de velocidade causada pelo efeito
   * @param redDef redução de defesa causada pelo efeito
   * @param rodadas quantidade de rodadas do efeito
   */
  public EfeitoAtk(String nome, int dano, int redSpeed, int redDef,
      int rodadas) {
    this.nome = nome;
    this.dano = dano;
    this.redSpeed = redSpeed;
    this.redDef = redDef;
    this.rodadas = rodadas;
  }

  /**
   * Retorna o nome do efeito.
   *
   * @return nome do efeito
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome do efeito.
   *
   * @param nome novo nome do efeito
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Retorna o dano causado pelo efeito.
   *
   * @return dano do efeito
   */
  public int getDano() {
    return dano;
  }

  /**
   * Define o dano causado pelo efeito.
   *
   * @param dano novo dano do efeito
   */
  public void setDano(int dano) {
    this.dano = dano;
  }

  /**
   * Retorna a redução de velocidade causada pelo efeito.
   *
   * @return redução de velocidade
   */
  public int getRedSpeed() {
    return redSpeed;
  }

  /**
   * Define a redução de velocidade causada pelo efeito.
   *
   * @param redSpeed nova redução de velocidade
   */
  public void setRedSpeed(int redSpeed) {
    this.redSpeed = redSpeed;
  }

  /**
   * Retorna a redução de defesa causada pelo efeito.
   *
   * @return redução de defesa
   */
  public int getRedDef() {
    return redDef;
  }

  /**
   * Define a redução de defesa causada pelo efeito.
   *
   * @param redDef nova redução de defesa
   */
  public void setRedDef(int redDef) {
    this.redDef = redDef;
  }

  /**
   * Retorna a quantidade de rodadas do efeito.
   *
   * @return quantidade de rodadas
   */
  public int getRodadas() {
    return rodadas;
  }

  /**
   * Define a quantidade de rodadas do efeito.
   *
   * @param rodadas nova quantidade de rodadas
   */
  public void setRodadas(int rodadas) {
    this.rodadas = rodadas;
  }

  /**
   * Retorna uma representação textual do efeito.
   *
   * @return representação textual do efeito
   */
  @Override
  public String toString() {
    return "EfeitoAtk{"
        + "nome='" + nome + '\''
        + ", dano=" + dano
        + ", redSpeed=" + redSpeed
        + ", redDef=" + redDef
        + ", rodadas=" + rodadas
        + '}';
  }
}