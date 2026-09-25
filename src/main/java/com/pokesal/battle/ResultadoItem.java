package com.pokesal.battle;

import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;

/**
 * Representa o resultado da utilização de um item durante uma batalha.
 */
public class ResultadoItem {

  private PokeDeBatalha usuario;

  private Item item;

  /**
   * Cria um resultado para a utilização de um item.
   *
   * @param usuario Pokesal que utilizou o item
   * @param item item utilizado
   */
  public ResultadoItem(PokeDeBatalha usuario, Item item) {
    this.usuario = usuario;
    this.item = item;
  }

  /**
   * Retorna o Pokesal que utilizou o item.
   *
   * @return usuário do item
   */
  public PokeDeBatalha getUsuario() {
    return usuario;
  }

  /**
   * Retorna o item utilizado.
   *
   * @return item utilizado
   */
  public Item getItem() {
    return item;
  }
}