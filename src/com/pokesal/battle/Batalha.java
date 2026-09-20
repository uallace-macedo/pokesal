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

  public Batalha(Ambiente ambiente, PokeDeBatalha jogador, PokeDeBatalha oponente) {
    this.ambiente = ambiente;
    this.jogador = jogador;
    this.oponente = oponente;

    this.combate = new Combate();
    this.console = new Console();
  }

  public void iniciar() {
    
    int rodada = 1;

    while (!terminou()) {

      console.mostrarInicioRodada(rodada);

      Acao acaoJogador = obterAcao(jogador);
      console.mostrarAcaoEscolhida(jogador);

      Acao acaoOponente = obterAcao(oponente);
      console.mostrarAcaoEscolhida(oponente);

      executarRodada(
        acaoJogador,
        acaoOponente
      );

      rodada++;
    }

    finalizar();
  }

  private void executarRodada(Acao acaoJogador, Acao acaoOponente) {
    
    console.mostrarExecucaoRodada();

    PokeDeBatalha primeiro = obterMaisRapido();
    PokeDeBatalha segundo = obterAlvo(primeiro);

    Acao acaoPrimeiro = obterAcao(
      primeiro,
      acaoJogador,
      acaoOponente
    );

    Acao acaoSegundo = obterAcao(
      segundo,
      acaoJogador,
      acaoOponente
    );

    executarAcao(primeiro, segundo, acaoPrimeiro);
    if(terminou()) return;

    executarAcao(segundo, primeiro, acaoSegundo);
    processarEfeitos();
  }

  private void processarEfeitos() {
    console.mostrarInicioEfeitos();
    console.mostrarMensagem("em construção...\n\n");

    // implementar processamento dos efeitos
  }

  private PokeDeBatalha obterMaisRapido() {
    int velocidadeJogador = combate.calcularVelocidadeEfetiva(jogador, ambiente);
    int velocidadeOponente = combate.calcularVelocidadeEfetiva(oponente, ambiente);

    if(velocidadeJogador >= velocidadeOponente) return jogador;
    return oponente;
  }

  private Acao obterAcao(PokeDeBatalha atacante) {
    while(true) {
      console.mostrarMenuAcao(atacante);
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

  private Acao obterAcao(PokeDeBatalha poke, Acao acaoJogador, Acao acaoOponente) {
    if(poke == jogador) return acaoJogador;
    return acaoOponente;
  }

  private Acao obterAcaoAtaque(PokeDeBatalha atacante) {
    ArrayList<Habilidade> habilidades = atacante.getHabilidades();

    while(true) {
      console.mostrarHabilidades(atacante);
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

    if(!podeUsarItem(atacante)) {
      console.mostrarMensagem("Você já utilizou o limite de itens nesta batalha!");
      return obterAcao(atacante);
    }

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
