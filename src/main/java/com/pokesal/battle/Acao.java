package com.pokesal.battle;

import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;

/**
 * Representa uma ação escolhida por um participante da batalha.
 */
public class Acao {

  private TipoAcao tipo;

  private Habilidade habilidade;

  private Item item;

  /**
   * Cria uma nova ação.
   *
   * @param tipo tipo da ação
   * @param habilidade habilidade utilizada, quando aplicável
   * @param item item utilizado, quando aplicável
   */
  public Acao(TipoAcao tipo, Habilidade habilidade, Item item) {
    this.tipo = tipo;
    this.habilidade = habilidade;
    this.item = item;
  }

  /**
   * Retorna o tipo da ação.
   *
   * @return tipo da ação
   */
  public TipoAcao getTipo() {
    return tipo;
  }

  /**
   * Retorna a habilidade associada à ação.
   *
   * @return habilidade associada
   */
  public Habilidade getHabilidade() {
    return habilidade;
  }

  /**
   * Retorna o item associado à ação.
   *
   * @return item associado
   */
  public Item getItem() {
    return item;
  }
}