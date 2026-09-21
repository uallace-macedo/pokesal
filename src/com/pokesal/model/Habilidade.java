package com.pokesal.model;

/**
 * Representa uma habilidade que pode ser utilizada por um Pokémon.
 */
public class Habilidade {

  private String nome;

  private double dano;

  private TipoHabilidades tipoHabilidade;

  private double ativacaoDeEfeito = 0.8;

  private EfeitoAtk efeitoAtk;

  /**
   * Cria uma nova habilidade.
   *
   * @param nome nome da habilidade
   * @param dano dano causado pela habilidade
   * @param tipoHabilidade tipo da habilidade
   * @param ativacaoDeEfeito chance de ativação do efeito
   * @param efeitoAtk efeito de ataque associado à habilidade
   */
  public Habilidade(String nome, double dano, TipoHabilidades tipoHabilidade,
      double ativacaoDeEfeito, EfeitoAtk efeitoAtk) {
    this.nome = nome;
    this.dano = dano;
    this.tipoHabilidade = tipoHabilidade;
    this.ativacaoDeEfeito = ativacaoDeEfeito;
    this.efeitoAtk = efeitoAtk;
  }

  /**
   * Retorna o nome da habilidade.
   *
   * @return nome da habilidade
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome da habilidade.
   *
   * @param nome novo nome da habilidade
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Retorna o dano da habilidade.
   *
   * @return dano da habilidade
   */
  public double getDano() {
    return dano;
  }

  /**
   * Define o dano da habilidade.
   *
   * @param dano novo dano da habilidade
   */
  public void setDano(double dano) {
    this.dano = dano;
  }

  /**
   * Retorna o tipo da habilidade.
   *
   * @return tipo da habilidade
   */
  public TipoHabilidades getTipoHabilidade() {
    return tipoHabilidade;
  }

  /**
   * Define o tipo da habilidade.
   *
   * @param tipoHabilidade novo tipo da habilidade
   */
  public void setTipoHabilidade(TipoHabilidades tipoHabilidade) {
    this.tipoHabilidade = tipoHabilidade;
  }

  /**
   * Retorna a chance de ativação do efeito.
   *
   * @return chance de ativação do efeito
   */
  public double getAtivacaoDeEfeito() {
    return ativacaoDeEfeito;
  }

  /**
   * Define a chance de ativação do efeito.
   *
   * @param ativacaoDeEfeito nova chance de ativação
   */
  public void setAtivacaoDeEfeito(double ativacaoDeEfeito) {
    this.ativacaoDeEfeito = ativacaoDeEfeito;
  }

  /**
   * Retorna o efeito de ataque associado à habilidade.
   *
   * @return efeito de ataque
   */
  public EfeitoAtk getEfeitoAtk() {
    return efeitoAtk;
  }

  /**
   * Define o efeito de ataque associado à habilidade.
   *
   * @param efeitoAtk novo efeito de ataque
   */
  public void setEfeitoAtk(EfeitoAtk efeitoAtk) {
    this.efeitoAtk = efeitoAtk;
  }
}