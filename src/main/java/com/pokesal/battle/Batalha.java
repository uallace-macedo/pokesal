package com.pokesal.battle;

import com.pokesal.model.Ambiente;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.ui.Console;
import java.util.ArrayList;

/**
 * Controla o fluxo e as regras de uma batalha entre dois Pokesals.
 */
public class Batalha {

  private static final int LIMITE_ITENS = 2;

  private Ambiente ambiente;

  private PokeDeBatalha jogador;

  private PokeDeBatalha oponente;

  private int itensUsadosJogador;

  private int itensUsadosOponente;

  private Combate combate;

  private Console console;

  /**
   * Cria uma nova batalha.
   *
   * @param ambiente ambiente da batalha
   * @param jogador Pokesal controlado pelo jogador
   * @param oponente Pokesal adversário
   */
  public Batalha(Ambiente ambiente, PokeDeBatalha jogador,
      PokeDeBatalha oponente) {
    this.ambiente = ambiente;
    this.jogador = jogador;
    this.oponente = oponente;
    this.combate = new Combate();
    this.console = new Console();
  }
  
  public Batalha(
		    Ambiente ambiente,
		    PokeDeBatalha jogador,
		    PokeDeBatalha oponente,
		    Console console
		) {
		  this.ambiente = ambiente;
		  this.jogador = jogador;
		  this.oponente = oponente;
		  this.combate = new Combate();
		  this.console = console;
		}

  /**
   * Inicia a batalha e executa suas rodadas até que um dos Pokesals seja
   * derrotado.
   */
  public void iniciar() {
    int rodada = 1;

    while (!terminou()) {
      console.mostrarInicioRodada(rodada);

      Acao acaoJogador = obterAcao(jogador);
      console.mostrarAcaoEscolhida(jogador);

      Acao acaoOponente = obterAcao(oponente);
      console.mostrarAcaoEscolhida(oponente);

      executarRodada(acaoJogador, acaoOponente);

      rodada++;
    }

    finalizar();
  }

  /**
   * Executa as ações escolhidas pelos participantes na rodada.
   *
   * @param acaoJogador ação escolhida pelo jogador
   * @param acaoOponente ação escolhida pelo oponente
   */
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

    if (terminou()) {
      return;
    }

    executarAcao(segundo, primeiro, acaoSegundo);
  }

  /**
   * Retorna o Pokesal com maior velocidade efetiva.
   *
   * @return Pokesal que realizará a primeira ação
   */
  private PokeDeBatalha obterMaisRapido() {
    int velocidadeJogador = combate.calcularVelocidadeEfetiva(
        jogador,
        ambiente
    );
    int velocidadeOponente = combate.calcularVelocidadeEfetiva(
        oponente,
        ambiente
    );

    if (velocidadeJogador >= velocidadeOponente) {
      return jogador;
    }

    return oponente;
  }

  /**
   * Obtém uma ação escolhida pelo Pokesal.
   *
   * @param atacante Pokesal que realizará a ação
   * @return ação escolhida
   */
  private Acao obterAcao(PokeDeBatalha atacante) {
    while (true) {
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

  /**
   * Obtém a ação previamente escolhida pelo participante.
   *
   * @param poke Pokesal cuja ação será obtida
   * @param acaoJogador ação escolhida pelo jogador
   * @param acaoOponente ação escolhida pelo oponente
   * @return ação correspondente ao Pokesal
   */
  private Acao obterAcao(PokeDeBatalha poke, Acao acaoJogador,
      Acao acaoOponente) {
    if (poke == jogador) {
      return acaoJogador;
    }

    return acaoOponente;
  }

  /**
   * Obtém uma ação de ataque escolhendo uma habilidade.
   *
   * @param atacante Pokesal que realizará o ataque
   * @return ação de ataque escolhida
   */
  private Acao obterAcaoAtaque(PokeDeBatalha atacante) {
    ArrayList<Habilidade> habilidades = atacante.getHabilidades();

    while (true) {
      console.mostrarHabilidades(atacante);
      int opcao = console.lerOpcao();

      if (opcao == 0) {
        return obterAcao(atacante);
      }

      if (opcao < 1 || opcao > habilidades.size()) {
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

  /**
   * Obtém uma ação de utilização de item.
   *
   * @param atacante Pokesal que utilizará o item
   * @return ação de utilização de item escolhida
   */
  private Acao obterAcaoItem(PokeDeBatalha atacante) {
    if (!podeUsarItem(atacante)) {
      console.mostrarMensagem(
          "Você já utilizou o limite de itens nesta batalha!"
      );
      return obterAcao(atacante);
    }

    ArrayList<Item> mochila = atacante.getTreinador().getMochila();

    if (mochila.isEmpty()) {
      console.mostrarMensagem("Você não possui itens!");
      return obterAcao(atacante);
    }

    while (true) {
      console.mostrarItens(mochila);
      int opcao = console.lerOpcao();

      if (opcao == 0) {
        return obterAcao(atacante);
      }

      if (opcao < 1 || opcao > mochila.size()) {
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

  /**
   * Executa uma ação de um Pokesal contra outro.
   *
   * @param atacante Pokesal que realiza a ação
   * @param alvo Pokesal que recebe a ação
   * @param acao ação a ser executada
   * @return true se a ação foi executada
   */
  private boolean executarAcao(PokeDeBatalha atacante, PokeDeBatalha alvo,
      Acao acao) {
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

  /**
   * Verifica se o Pokesal ainda pode utilizar um item na batalha.
   *
   * @param atacante Pokesal que deseja utilizar o item
   * @return true se o Pokesal ainda pode utilizar itens
   */
  private boolean podeUsarItem(PokeDeBatalha atacante) {
    if (atacante == jogador) {
      return itensUsadosJogador < LIMITE_ITENS;
    }

    return itensUsadosOponente < LIMITE_ITENS;
  }

  /**
   * Registra a utilização de um item pelo Pokesal.
   *
   * @param atacante Pokesal que utilizou o item
   */
  private void registrarUsoDeItem(PokeDeBatalha atacante) {
    if (atacante == jogador) {
      itensUsadosJogador++;
    } else {
      itensUsadosOponente++;
    }
  }

  /**
   * Obtém o Pokesal adversário do atacante.
   *
   * @param atacante Pokesal que realizou a ação
   * @return Pokesal adversário
   */
  private PokeDeBatalha obterAlvo(PokeDeBatalha atacante) {
    if (atacante == jogador) {
      return oponente;
    }

    return jogador;
  }

  /**
   * Finaliza a batalha e exibe o vencedor.
   */
  private void finalizar() {
    PokeDeBatalha vencedor = obterVencedor();
    console.mostrarMensagem(vencedor.getNome() + " venceu a batalha!");
  }

  /**
   * Obtém o Pokesal vencedor da batalha.
   *
   * @return Pokesal vencedor
   */
  private PokeDeBatalha obterVencedor() {
    if (jogador.getHpAtual() <= 0) {
      return oponente;
    }

    return jogador;
  }

  /**
   * Verifica se a batalha terminou.
   *
   * @return true se algum dos Pokesals foi derrotado
   */
  private boolean terminou() {
    return jogador.getHpAtual() <= 0 || oponente.getHpAtual() <= 0;
  }
}