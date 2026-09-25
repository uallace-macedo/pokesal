package com.pokesal.model;

/**
 * Representa um ambiente que pode alterar os atributos de um Pokémon.
 */
public class Ambiente {

  private String ambienteNome;

  private TipoElemento tipoElemento;

  private double aumentaAtk;

  private double aumentaDef;

  private double aumentaSpd;

  /**
   * Cria um novo ambiente.
   *
   * @param ambienteNome nome do ambiente
   * @param tipoElemento tipo de elemento associado ao ambiente
   * @param aumentaAtk aumento no ataque
   * @param aumentaDef aumento na defesa
   * @param aumentaSpd aumento na velocidade
   */
  public Ambiente(String ambienteNome, TipoElemento tipoElemento,
      double aumentaAtk, double aumentaDef, double aumentaSpd) {
    this.ambienteNome = ambienteNome;
    this.tipoElemento = tipoElemento;
    this.aumentaAtk = aumentaAtk;
    this.aumentaDef = aumentaDef;
    this.aumentaSpd = aumentaSpd;
  }

  /**
   * Retorna o nome do ambiente.
   *
   * @return nome do ambiente
   */
  public String getNome() {
    return ambienteNome;
  }

  /**
   * Define o nome do ambiente.
   *
   * @param ambienteNome novo nome do ambiente
   */
  public void setNome(String ambienteNome) {
    this.ambienteNome = ambienteNome;
  }

  /**
   * Retorna o tipo de elemento do ambiente.
   *
   * @return tipo de elemento
   */
  public TipoElemento getTipoElemento() {
    return tipoElemento;
  }

  /**
   * Define o tipo de elemento do ambiente.
   *
   * @param tipoElemento novo tipo de elemento
   */
  public void setTipoElemento(TipoElemento tipoElemento) {
    this.tipoElemento = tipoElemento;
  }

  /**
   * Retorna o aumento de ataque.
   *
   * @return aumento de ataque
   */
  public double getAumentaAtk() {
    return aumentaAtk;
  }

  /**
   * Define o aumento de ataque.
   *
   * @param aumentaAtk novo aumento de ataque
   */
  public void setAumentaAtk(double aumentaAtk) {
    this.aumentaAtk = aumentaAtk;
  }

  /**
   * Retorna o aumento de defesa.
   *
   * @return aumento de defesa
   */
  public double getAumentaDef() {
    return aumentaDef;
  }

  /**
   * Define o aumento de defesa.
   *
   * @param aumentaDef novo aumento de defesa
   */
  public void setAumentaDef(double aumentaDef) {
    this.aumentaDef = aumentaDef;
  }

  /**
   * Retorna o aumento de velocidade.
   *
   * @return aumento de velocidade
   */
  public double getAumentaSpd() {
    return aumentaSpd;
  }

  /**
   * Define o aumento de velocidade.
   *
   * @param aumentaSpd novo aumento de velocidade
   */
  public void setAumentaSpd(double aumentaSpd) {
    this.aumentaSpd = aumentaSpd;
  }

  /**
   * Retorna uma representação textual do ambiente.
   *
   * @return representação textual do ambiente
   */
  @Override
  public String toString() {
    return "Ambiente{"
        + "nome do ambiente='" + ambienteNome + '\''
        + ", tipoElemento=" + tipoElemento
        + ", aumentaAtk=" + aumentaAtk
        + ", aumentaDef=" + aumentaDef
        + ", aumentaSpd=" + aumentaSpd
        + '}';
  }
}