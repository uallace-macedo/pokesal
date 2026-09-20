package com.pokesal.data;

import java.util.ArrayList;
import java.util.List;

import com.pokesal.model.Habilidade;
import com.pokesal.model.Pokesal;
import com.pokesal.model.TipoElemento;

public class PokesalData {

    public static final Pokesal BULBASAL = new Pokesal(
		"BulbaSal", 380, 25, 35, 60, TipoElemento.PLANTA,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.QUEDA_DE_MANGA,
			HabilidadeData.FOLHA_SECA,
			HabilidadeData.TRABALHO_EM_GRUPO,
			HabilidadeData.MUITA_FOME
		))
	);

    public static final Pokesal CHARSAL = new Pokesal(
		"CharSal", 330, 15, 50, 100, TipoElemento.FOGO,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.CURTO_CIRCUITO,
			HabilidadeData.FUMACA_DE_CIGARRO,
			HabilidadeData.PROVA_SURPRESA,
			HabilidadeData.ATRASADINHO
		))
	);

    public static final Pokesal SQUIRTSAL = new Pokesal(
		"SquirtSal", 450, 30, 35, 45, TipoElemento.AGUA,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.GOTEIRA,
			HabilidadeData.MEIA_MOLHADA,
			HabilidadeData.TRABALHO_EM_GRUPO,
			HabilidadeData.APRESENTACAO
		))
	);

    public static final Pokesal CHIKOSAL = new Pokesal(
		"ChikoSal", 400, 30, 30, 70, TipoElemento.PLANTA,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.FOLHA_SECA,
			HabilidadeData.QUEDA_DE_MANGA,
			HabilidadeData.FACIAL_NAO_RECONHECIDA,
			HabilidadeData.MUITA_FOME
		))
	);

    public static final Pokesal CYNDASAL = new Pokesal(
		"CyndaSal", 320, 10, 50, 120, TipoElemento.FOGO,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.CURTO_CIRCUITO,
			HabilidadeData.FUMACA_DE_CIGARRO,
			HabilidadeData.ATRASADINHO,
			HabilidadeData.PROVA_SURPRESA
		))
	);

    public static final Pokesal TOTOSAL = new Pokesal(
		"TotoSal", 470, 28, 40, 35, TipoElemento.AGUA,
		new ArrayList<Habilidade>(List.of(
			HabilidadeData.GOTEIRA,
			HabilidadeData.MEIA_MOLHADA,
			HabilidadeData.TRABALHO_EM_GRUPO,
			HabilidadeData.FACIAL_NAO_RECONHECIDA
		))
	);
  
    public static ArrayList<Pokesal> gerar() {
        return new ArrayList<Pokesal>(List.of(
			BULBASAL,
			CHARSAL,
			SQUIRTSAL,
			CHIKOSAL,
			CYNDASAL,
			TOTOSAL
		));
    }
}
