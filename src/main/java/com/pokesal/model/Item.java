package com.pokesal.model;

/**
 * Representa um item que pode ser utilizado durante o jogo.
 */
public class Item {

  private String nome;

  private String descricao;

  private TipoEfeitoItem tipoEfeito;

  private int valor;

  /**
   * Cria um novo item.
   *
   * @param nome nome do item
   * @param descricao descrição do item
   * @param tipoEfeito tipo de efeito causado pelo item
   * @param valor valor do efeito do item
   */
  public Item(String nome, String descricao, TipoEfeitoItem tipoEfeito, int valor) {
    this.nome = nome;
    this.descricao = descricao;
    this.tipoEfeito = tipoEfeito;
    this.valor = valor;
  }

  /**
   * Retorna o nome do item.
   *
   * @return nome do item
   */
  public String getNome() {
    return nome;
  }

  /**
   * Define o nome do item.
   *
   * @param nome novo nome do item
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Retorna a descrição do item.
   *
   * @return descrição do item
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * Define a descrição do item.
   *
   * @param descricao nova descrição do item
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
   * Retorna o tipo de efeito do item.
   *
   * @return tipo de efeito do item
   */
  public TipoEfeitoItem getTipoEfeito() {
    return tipoEfeito;
  }

  /**
   * Define o tipo de efeito do item.
   *
   * @param tipoEfeito novo tipo de efeito do item
   */
  public void setTipoEfeito(TipoEfeitoItem tipoEfeito) {
    this.tipoEfeito = tipoEfeito;
  }

  /**
   * Retorna o valor do efeito do item.
   *
   * @return valor do efeito
   */
  public int getValor() {
    return valor;
  }

  /**
   * Define o valor do efeito do item.
   *
   * @param valor novo valor do efeito
   */
  public void setValor(int valor) {
    this.valor = valor;
  }
}