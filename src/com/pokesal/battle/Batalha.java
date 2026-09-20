package com.pokesal.battle;

import java.util.ArrayList;

import com.pokesal.model.Ambiente;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.ui.Console;

public class Batalha {

  private static final int LIMITE_ITENS = 2;

  private Ambiente ambiente;

  private PokeDeBatalha jogador;
  private PokeDeBatalha oponente;

  private int itensUsadosJogador;
  private int itensUsadosOponente;

  private Combate combate;
  private Console console;

  private PokeDeBatalha ultimoQueJogou;

  public Batalha(Ambiente ambiente, PokeDeBatalha jogador, PokeDeBatalha oponente) {
    this.ambiente = ambiente;
    this.jogador = jogador;
    this.oponente = oponente;

    this.combate = new Combate();
    this.console = new Console();
  }

  public void iniciar() {    

    ultimoQueJogou = null;

    while (!terminou()) {
      PokeDeBatalha proximo = obterProximoJogador();
      executarTurno(proximo);
      ultimoQueJogou = proximo;
      
      if (terminou()) {
        break;
      }
    }

    finalizar();
  }

  private PokeDeBatalha obterProximoJogador() {
    if(ultimoQueJogou == null) return obterMaisRapido();
    if(ultimoQueJogou == jogador) return oponente;
    return jogador;
  }

  private PokeDeBatalha obterMaisRapido() {
    int velocidadeJogador = combate.calcularVelocidadeEfetiva(jogador, ambiente);
    int velocidadeOponente = combate.calcularVelocidadeEfetiva(oponente, ambiente);

    if(velocidadeJogador >= velocidadeOponente) return jogador;
    return oponente;
  }

  private void executarTurno(PokeDeBatalha atacante) {
    System.out.println("Turno de " + atacante.getNome());
    PokeDeBatalha alvo = obterAlvo(atacante);

    while(true) {
      Acao acao = obterAcao(atacante);
      if(executarAcao(atacante, alvo, acao)) break;
    }
  }

  private Acao obterAcao(PokeDeBatalha atacante) {
    while(true) {
      console.mostrarMenuAcao();
      int opcao = console.lerOpcao();
  
      switch (opcao) {
        case 1:
          return obterAcaoAtaque(atacante);
  
        case 2:
          return obterAcaoItem(atacante);
      
        default:
          console.mostrarMensagem("Opção inválida!");
      }
    }
  }

  private Acao obterAcaoAtaque(PokeDeBatalha atacante) {
    ArrayList<Habilidade> habilidades = atacante.getHabilidades();

    while(true) {
      console.mostrarHabilidades(habilidades);
      int opcao = console.lerOpcao();

      if(opcao == 0) return obterAcao(atacante);
  
      if(opcao < 1 || opcao > habilidades.size()) {
        console.mostrarMensagem("Habilidade inválida!");
        continue;
      }

      Habilidade habilidade = habilidades.get(opcao - 1);
      return new Acao(
        TipoAcao.ATACAR,
        habilidade,
        null
      );
    }
  }

  private Acao obterAcaoItem(PokeDeBatalha atacante) {
    ArrayList<Item> mochila = atacante.getTreinador().getMochila();
    if(mochila.isEmpty()) {
      console.mostrarMensagem("Você não possui itens!");
      return obterAcao(atacante);
    }

    while(true) {
      console.mostrarItens(mochila);
      int opcao = console.lerOpcao();

      if(opcao == 0) return obterAcao(atacante);
  
      if(opcao < 1 || opcao > mochila.size()) {
        console.mostrarMensagem("Item inválido");
        continue;
      }

      Item item = mochila.get(opcao - 1);
      return new Acao(
        TipoAcao.USAR_ITEM,
        null,
        item
      );
    }
  }

  private boolean executarAcao(PokeDeBatalha atacante, PokeDeBatalha alvo, Acao acao) {
    switch (acao.getTipo()) {

      case ATACAR:
        ResultadoAtaque resultadoAtaque = combate.atacar(
          atacante,
          alvo,
          acao.getHabilidade(),
          ambiente
        );

        console.mostrarResultadoAtaque(resultadoAtaque);
        return true;

      case USAR_ITEM:
        if (!podeUsarItem(atacante)) {
          console.mostrarMensagem("Você já utilizou o limite de itens nesta batalha!");
          return false;
        }

        Item item = acao.getItem();
        
        ResultadoItem resultadoItem = combate.usarItem(atacante, item);
        registrarUsoDeItem(atacante);

        console.mostrarResultadoItem(resultadoItem);
        return true;

      default:
        return false;
    }
  }

  private boolean podeUsarItem(PokeDeBatalha atacante) {
    if (atacante == jogador) return itensUsadosJogador < LIMITE_ITENS;
    return itensUsadosOponente < LIMITE_ITENS;
  }

  private void registrarUsoDeItem(PokeDeBatalha atacante) {
    if (atacante == jogador) {
      itensUsadosJogador++;
    } else {
      itensUsadosOponente++;
    }
  }

  private PokeDeBatalha obterAlvo(PokeDeBatalha atacante) {
    if (atacante == jogador) return oponente;
    return jogador;
  }

  private void finalizar() {
    PokeDeBatalha vencedor = obterVencedor();
    console.mostrarMensagem(vencedor.getNome() + " venceu a batalha!");
  }

  private PokeDeBatalha obterVencedor() {
    if (jogador.getHpAtual() <= 0) return oponente;
    return jogador;
  }

  private boolean terminou() {
    return jogador.getHpAtual() <= 0 || oponente.getHpAtual() <= 0;
  }
}
