package com.pokesal;

import java.util.List;
import java.util.ArrayList;

public class DadosBase {
	public static ArrayList<Ambiente> gerarAmbientes() {
		Ambiente asfaltoQuente = new Ambiente("Asfalto Quente", TipoElemento.FOGO, 0.15, 0.05, 0);
		Ambiente diaChuvoso = new Ambiente("Dia Chuvoso", TipoElemento.AGUA, 0.10, 0, 0.8);
		Ambiente reservaDePituacu = new Ambiente("Reserva de Pituaçu", TipoElemento.PLANTA, 0.5, 0.2, 0);
		
		return new ArrayList<Ambiente>(List.of(asfaltoQuente, diaChuvoso, reservaDePituacu));
	}
	
	public static ArrayList<Pokesal> gerarPokesals() {
		Habilidade goteira = new Habilidade(
				"Goteira", 42, TipoHabilidades.AGUA, 0.75,
				new EfeitoAtk("Pingos Insistentes", 5, 5, 0, 3)
		);
		
		Habilidade meiaMolhada = new Habilidade(
				"Meia Molhada", 31, TipoHabilidades.AGUA, 0.9,
				new EfeitoAtk("Desconforto Aquático", 3, 15, 0, 2)
		);
		
		Habilidade curtoCircuito = new Habilidade(
			"Curto-circuito", 47, TipoHabilidades.FOGO, 0.65,
			new EfeitoAtk("Pane Geral", 8, 10, 5, 3)
		);
	
		Habilidade fumacaDeCigarro = new Habilidade(
			"Fumaça de Cigarro", 33, TipoHabilidades.FOGO, 0.85,
			new EfeitoAtk("Pulmão de Papel", 4, 20, 0, 3)
		);
		
		Habilidade quedaDeManga = new Habilidade(
			"Queda de Manga", 47, TipoHabilidades.PLANTA, 0.60,
			new EfeitoAtk("Manga na Cabeça", 7, 0, 10, 2)
		);
		
		Habilidade folhaSeca = new Habilidade(
			"Folha Seca", 36, TipoHabilidades.PLANTA, 0.8,
			new EfeitoAtk("Alergia Botânica", 5, 10, 5, 3)
		);
		
		Habilidade provaSurpresa = new Habilidade(
				"Prova Surpresa", 50, TipoHabilidades.NORMAL, 0, null
		);
		
		Habilidade apresentacao = new Habilidade(
				"Apresentacao", 48, TipoHabilidades.NORMAL, 0, null
		);
		
		Habilidade trabalhoEmGrupo = new Habilidade(
				"Trabalho em Grupo", 44, TipoHabilidades.NORMAL, 0, null
		);
		
		Habilidade facialNaoReconhecida = new Habilidade(
			"Facial não Reconhecida", 38, TipoHabilidades.NORMAL, 0, null
		);

		Habilidade muitaFome = new Habilidade(
			"Muita Fome", 34, TipoHabilidades.NORMAL, 0, null
		);

		Habilidade atrasadinho = new Habilidade(
			"Atrasadinho", 30, TipoHabilidades.NORMAL, 0, null
		);
		
		Pokesal bulbaSal = new Pokesal("BulbaSal", 380, 25, 35, 60, TipoElemento.PLANTA,
		        new ArrayList<>(List.of(quedaDeManga, folhaSeca, trabalhoEmGrupo, muitaFome))
		);

		Pokesal charSal = new Pokesal("CharSal", 330, 15, 50, 100, TipoElemento.FOGO,
		        new ArrayList<>(List.of(curtoCircuito, fumacaDeCigarro, provaSurpresa, atrasadinho))
		);

		Pokesal squirtSal = new Pokesal(
				"SquirtSal", 450, 30, 35, 45, TipoElemento.AGUA,
				new ArrayList<>(List.of(goteira, meiaMolhada, trabalhoEmGrupo, apresentacao))
		);
		
		Pokesal chikoSal = new Pokesal(
				"ChikoSal", 400, 30, 30, 70, TipoElemento.PLANTA,
				new ArrayList<>(List.of(folhaSeca, quedaDeManga, facialNaoReconhecida, muitaFome))
		);
		
		Pokesal cyndaSal = new Pokesal(
				"CyndaSal", 320, 10, 50, 120, TipoElemento.FOGO,
				new ArrayList<>(List.of(curtoCircuito, fumacaDeCigarro, atrasadinho,provaSurpresa))
		);

		Pokesal totoSal = new Pokesal("TotoSal", 470, 28, 40, 35, TipoElemento.AGUA,
		        new ArrayList<>(List.of(goteira, meiaMolhada, trabalhoEmGrupo, facialNaoReconhecida))
		);
		
		return new ArrayList<Pokesal>(List.of(
			bulbaSal,
		    charSal,
		    squirtSal,
		    chikoSal,
		    cyndaSal,
		    totoSal
		));
	}
	
	public static ArrayList<Item> gerarItens() {
		Item segundaChamada = new Item("Segunda Chamada", "Remove qualquer efeito", 0, true, 0);
		Item bencaDoPadre = new Item("Bença do Padre", "Regenera 100% do HP", 999, false, 0);
		Item redBull = new Item("Redbull", "Aumenta em 30 pontos o speed do pokesal", 0, false, 30);
		
		return new ArrayList<Item>(List.of(segundaChamada, bencaDoPadre, redBull));
	}
	
}
