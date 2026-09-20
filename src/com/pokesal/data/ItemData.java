package com.pokesal.data;

import java.util.ArrayList;
import java.util.List;

import com.pokesal.model.Item;

public class ItemData {
  
  public final static Item SEGUNDA_CHAMADA = new Item(
    "Segunda Chamada",
    "Remove qualquer efeito",
    0,
    true,
    0
  );

  public final static Item BENCA_DO_PADRE = new Item(
    "Bença do Padre",
    "Regenera 100% do HP",
    999,
    false,
    0
  );

  public final static Item REDBULL = new Item(
    "RedBull",
    "Aumenta em 30 pontos o speed do pokesal",
    0,
    false,
    30
  );

  public static ArrayList<Item> gerar() {
    return new ArrayList<Item>(List.of(
      SEGUNDA_CHAMADA,
      BENCA_DO_PADRE,
      REDBULL
    ));
  }
}
