package com.pokesal.data;

import com.pokesal.model.EfeitoAtk;
import com.pokesal.model.Habilidade;
import com.pokesal.model.TipoHabilidades;

public class HabilidadeData {
  
    public static final Habilidade GOTEIRA = new Habilidade(
			"Goteira", 42, TipoHabilidades.AGUA, 0.75,
			new EfeitoAtk("Pingos Insistentes", 5, 5, 0, 3)
	);

    public static final Habilidade MEIA_MOLHADA = new Habilidade(
		    "Meia Molhada", 31, TipoHabilidades.AGUA, 0.9,
		    new EfeitoAtk("Desconforto Aquático", 3, 15, 0, 2)
	);

    public static final Habilidade CURTO_CIRCUITO = new Habilidade(
		    "Curto-circuito", 47, TipoHabilidades.FOGO, 0.65,
		    new EfeitoAtk("Pane Geral", 8, 10, 5, 3)
    );

    public static final Habilidade FUMACA_DE_CIGARRO = new Habilidade(
		    "Fumaça de Cigarro", 33, TipoHabilidades.FOGO, 0.85,
		    new EfeitoAtk("Pulmão de Papel", 4, 20, 0, 3)
    );

    public static final Habilidade QUEDA_DE_MANGA = new Habilidade(
		    "Queda de Manga", 47, TipoHabilidades.PLANTA, 0.60,
		    new EfeitoAtk("Manga na Cabeça", 7, 0, 10, 2)
    );

    public static final Habilidade FOLHA_SECA = new Habilidade(
		    "Folha Seca", 36, TipoHabilidades.PLANTA, 0.8,
		    new EfeitoAtk("Alergia Botânica", 5, 10, 5, 3)
    );

    public static final Habilidade PROVA_SURPRESA = new Habilidade(
    		"Prova Surpresa", 50, TipoHabilidades.NORMAL, 0, null
    );

    public static final Habilidade APRESENTACAO = new Habilidade(
    		"Apresentação", 48, TipoHabilidades.NORMAL, 0, null
    );

    public static final Habilidade TRABALHO_EM_GRUPO = new Habilidade(
    		"Trabalho em Grupo", 44, TipoHabilidades.NORMAL, 0, null
    );

    public static final Habilidade FACIAL_NAO_RECONHECIDA = new Habilidade(
    		"Facial não Reconhecida", 38, TipoHabilidades.NORMAL, 0, null
    );

    public static final Habilidade MUITA_FOME = new Habilidade(
    		"Muita Fome", 34, TipoHabilidades.NORMAL, 0, null
    );

    public static final Habilidade ATRASADINHO = new Habilidade(
    		"Atrasadinho", 30, TipoHabilidades.NORMAL, 0, null
    );
}
