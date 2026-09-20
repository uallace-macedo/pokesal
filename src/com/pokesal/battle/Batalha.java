package com.pokesal.battle;

import com.pokesal.model.Ambiente;
import com.pokesal.model.PokeDeBatalha;

public class Batalha {

  private static final int LIMITE_ITENS = 2;

  private Ambiente ambiente;

  private PokeDeBatalha jogador;
  private PokeDeBatalha oponente;

  private PokeDeBatalha primeiro;
  private PokeDeBatalha segundo;

  private int itensUsadosJogador;
  private int itensUsadosOponente;

  private Combate combate;

  public Batalha(Ambiente ambiente, PokeDeBatalha jogador, PokeDeBatalha oponente) {
    this.ambiente = ambiente;
    this.jogador = jogador;
    this.oponente = oponente;
    this.combate = new Combate();
  }

  private void definirOrdem() {
      int velocidadeJogador = combate.calcularVelocidadeEfetiva(jogador, ambiente);
      int velocidadeOponente = combate.calcularVelocidadeEfetiva(oponente, ambiente);

      if (velocidadeJogador >= velocidadeOponente) {
        primeiro = jogador;
        segundo = oponente;
      } else {
        primeiro = oponente;
        segundo = jogador;
      }
  }

  private boolean terminou() {
    return jogador.getHpAtual() <= 0 || oponente.getHpAtual() <= 0;
  }

  private PokeDeBatalha obterVencedor() {
    if (jogador.getHpAtual() <= 0) return oponente;
    return jogador;
  }

  public void iniciar() {
    definirOrdem();

    while (!terminou()) {
      executarTurno(primeiro);

      if (terminou()) {
        break;
      }

      executarTurno(segundo);
    }

    finalizar();
  }

  private void executarTurno(PokeDeBatalha atacante) {
    PokeDeBatalha alvo = obterAlvo(atacante);
    Acao acao = obterAcao(atacante);

    executarAcao(atacante, alvo, acao);
  }

  private Acao obterAcao(PokeDeBatalha atacante) {
    return null;
  }

  private void executarAcao(PokeDeBatalha atacante, PokeDeBatalha alvo, Acao acao) {
    switch (acao.getTipo()) {

      case ATACAR:
        combate.atacar(atacante, alvo, acao.getHabilidade(), ambiente);
        break;

      case USAR_ITEM:
        if (!podeUsarItem(atacante)) {
          // informar que não pode usar mais itens
          break;
        }

        atacante.usarItem(acao.getItem());
        registrarUsoDeItem(atacante);
        break;
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

    System.out.println(vencedor.getNome() + " venceu a batalha!");
  }
}
