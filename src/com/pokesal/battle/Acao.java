package com.pokesal.battle;

import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;

public class Acao {

  private TipoAcao tipo;
  private Habilidade habilidade;
  private Item item;

  public Acao(TipoAcao tipo, Habilidade habilidade, Item item) {
    this.tipo = tipo;
    this.habilidade = habilidade;
    this.item = item;
  }

  public TipoAcao getTipo() {
    return tipo;
  }

  public Habilidade getHabilidade() {
    return habilidade;
  }

  public Item getItem() {
    return item;
  }
}
