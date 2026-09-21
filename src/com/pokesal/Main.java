package com.pokesal;

import com.pokesal.battle.Batalha;
import com.pokesal.data.AmbienteData;
import com.pokesal.data.ItemData;
import com.pokesal.data.PokesalData;
import com.pokesal.model.Ambiente;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.Pokesal;
import com.pokesal.model.Treinador;
import com.pokesal.ui.Console;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ponto de entrada da aplicação PokeSal.
 */
public class Main {

  /**
   * Inicia a aplicação e configura uma nova batalha.
   *
   * @param args argumentos da linha de comando
   */
  public static void main(String[] args) {

    Random random = new Random();
    Console console = new Console();
    console.mostrarTitulo();

    String nomeJogador = console.lerTexto(
        "Treinador 1: "
    );

    Pokesal pokesalJogador = console.selecionarPokesal(
        PokesalData.gerar()
    );

    String nomeOponente = console.lerTexto(
        "Treinador 2: "
    );

    Pokesal pokesalOponente = console.selecionarPokesal(
        PokesalData.gerar()
    );

    Treinador jogador = new Treinador(
        nomeJogador,
        pokesalJogador,
        ItemData.gerar()
    );

    Treinador oponente = new Treinador(
        nomeOponente,
        pokesalOponente,
        ItemData.gerar()
    );

    PokeDeBatalha pokeJogador = jogador.armarParaBatalha();

    PokeDeBatalha pokeOponente = oponente.armarParaBatalha();

    ArrayList<Ambiente> ambientes = AmbienteData.gerar();
    Ambiente ambiente = ambientes.get(
        random.nextInt(ambientes.size())
    );

    Batalha batalha = new Batalha(
        ambiente,
        pokeJogador,
        pokeOponente
    );

    batalha.iniciar();
  }
}
