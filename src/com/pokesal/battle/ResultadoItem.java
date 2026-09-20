package com.pokesal.battle;

import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;

public class ResultadoItem {
  
  private PokeDeBatalha usuario;
  private Item item;

  public ResultadoItem(PokeDeBatalha usuario, Item item) {
    this.usuario = usuario;
    this.item = item;
  }

  public PokeDeBatalha getUsuario() {
    return usuario;
  }

  public Item getItem() {
    return item;
  }
}
