package com.pokesal.data;

import java.util.ArrayList;
import java.util.List;

import com.pokesal.model.Item;
import com.pokesal.model.TipoEfeitoItem;

public class ItemData {
  
    public static final Item SEGUNDA_CHAMADA = new Item(
    	"Segunda Chamada",
    	"Remove qualquer efeito",
    	TipoEfeitoItem.REMOVE_EFEITO,
    	0
    );

    public static final Item BENCA_DO_PADRE = new Item(
    	"Bença do Padre",
    	"Regenera 100% do HP",
    	TipoEfeitoItem.CURA_TOTAL,
    	0
    );

    public static final Item REDBULL = new Item(
    	"RedBull",
    	"Aumenta em 30 pontos o speed do pokesal",
    	TipoEfeitoItem.AUMENTA_SPEED,
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
