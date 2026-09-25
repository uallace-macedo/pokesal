package com.pokesal.ui;

import com.pokesal.battle.ResultadoAtaque;
import com.pokesal.battle.ResultadoItem;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.Pokesal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Responsável pela interação entre o jogo e o usuário através do console.
 */
public class Console {

  private Scanner scan;

  /**
   * Cria um novo console para entrada e saída de dados.
   */
  public Console() {
    scan = new Scanner(System.in);
  }

  /**
   * Lê uma opção numérica informada pelo usuário.
   *
   * @return opção informada pelo usuário
   */
  public int lerOpcao() {
    while (true) {
      String entrada = scan.nextLine();

      try {
        return Integer.parseInt(entrada);
      } catch (NumberFormatException e) {
        System.out.println("Digite um número válido!");
        System.out.println("Escolha: ");
      }
    }
  }

  /**
   * Lê um texto digitado pelo usuário.
   *
   * @param mensagem mensagem exibida antes da entrada
   * @return texto informado pelo usuário
   */
  public String lerTexto(String mensagem) {
    System.out.print(mensagem);
    return scan.nextLine();
  }

  /**
   * Exibe o título do jogo.
   */
  public void mostrarTitulo() {
    System.out.printf(
        "-".repeat(52)
        +
        "%n"
        +
        "POKESAL - UCSal Gaming (Java Testers)%n"
        +
        "-".repeat(52)
        +
        "%n%n"
    );
  }

  /**
   * Permite ao usuário escolher um PokeSal.
   *
   * @param pokesals lista de PokeSal disponíveis
   * @return PokeSal escolhido
   */
  public Pokesal selecionarPokesal(ArrayList<Pokesal> pokesals) {
    while (true) {
      mostrarPokesals(pokesals);

      int opcao = lerOpcao();

      if (opcao < 1 || opcao > pokesals.size()) {
        mostrarMensagem("PokeSal inválido!");
        continue;
      }

      Pokesal escolhido = pokesals.get(opcao - 1);

      System.out.printf(
          "-".repeat(52)
          +
          "%nVocê escolheu %s!%n"
          +
          "=".repeat(52)
          +
          "%n%n",
          escolhido.getNome()
      );

      return escolhido;
    }
  }

  /**
   * Exibe os PokeSal disponíveis e seus atributos.
   *
   * @param pokesals lista de PokeSal disponíveis
   */
  public void mostrarPokesals(ArrayList<Pokesal> pokesals) {
    System.out.printf(
        "Escolha seu Pokesal%n"
        +
        "-".repeat(52)
        +
        "%n"
    );

    for (int i = 0; i < pokesals.size(); i++) {
      Pokesal pokesal = pokesals.get(i);

      System.out.printf(
          "%d. %s%n",
          i + 1,
          pokesal.getNome()
      );
    }

    System.out.printf(
        "%n====================================================%n"
            + "Escolha: "
    );
  }

  /**
   * Exibe o início de uma rodada.
   *
   * @param rodada número da rodada
   */
  public void mostrarInicioRodada(int rodada) {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n"
            + "RODADA %d%n",
        rodada
    );
  }

  /**
   * Exibe o início da execução das ações da rodada.
   */
  public void mostrarExecucaoRodada() {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n%n%n"
            + "EXECUTANDO RODADA%n"
            + "=".repeat(52) + "%n"
    );
  }

  /**
   * Exibe uma mensagem no console.
   *
   * @param mensagem mensagem a ser exibida
   */
  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }

  /**
   * Exibe o menu de ações disponíveis para um Pokesal.
   *
   * @param poke Pokesal que realizará a ação
   */
  public void mostrarMenuAcao(PokeDeBatalha poke) {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n%n%n"
            + "AÇÃO DE %S%n"
            + "=".repeat(52) + "%n"
            + "1. Atacar%n"
            + "2. Usar item%n"
            + "-".repeat(52) + "%n"
            + "Escolha: ",
        poke.getNome().toUpperCase()
    );
  }

  /**
   * Exibe as habilidades disponíveis para um Pokesal.
   *
   * @param poke Pokesal cujas habilidades serão exibidas
   */
  public void mostrarHabilidades(PokeDeBatalha poke) {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n%n%n"
            + "HABILIDADES DE %s%n"
            + "=".repeat(52) + "%n",
        poke.getNome().toUpperCase()
    );

    ArrayList<Habilidade> habilidades = poke.getHabilidades();

    for (int i = 0; i < habilidades.size(); i++) {
      Habilidade habilidade = habilidades.get(i);

      System.out.printf(
          "%d. %s%n",
          i + 1,
          habilidade.getNome()
      );
    }

    System.out.printf(
        "0. Voltar%n"
            + "-".repeat(52) + "%n"
            + "Escolha: "
    );
  }

  /**
   * Exibe os itens disponíveis para utilização.
   *
   * @param itens itens a serem exibidos
   */
  public void mostrarItens(ArrayList<Item> itens) {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n%n%n"
            + "ITENS%n"
            + "=".repeat(52) + "%n"
    );

    for (int i = 0; i < itens.size(); i++) {
      Item item = itens.get(i);

      System.out.printf(
          "%d. %s (%s)%n",
          i + 1,
          item.getNome(),
          item.getDescricao()
      );
    }

    System.out.printf(
        "0. Voltar%n"
            + "-".repeat(52) + "%n"
            + "Escolha: "
    );
  }

  /**
   * Exibe a ação escolhida por um Pokesal.
   *
   * @param poke Pokesal que escolheu a ação
   */
  public void mostrarAcaoEscolhida(PokeDeBatalha poke) {
    System.out.printf(
        "---___---___---___---___---___---___---___---___---_%n%n"
            + "%n>>> %s escolheu sua ação!%n",
        poke.getNome()
    );
  }

  /**
   * Exibe o resultado de um ataque.
   *
   * @param resultado resultado do ataque
   */
  public void mostrarResultadoAtaque(ResultadoAtaque resultado) {
    System.out.printf(
        "%n%s usou %s!%n",
        resultado.getAtacante().getNome(),
        resultado.getHabilidade().getNome()
    );

    System.out.printf(
        "Dano causado: %d%n%n",
        resultado.getDano()
    );

    System.out.printf(
        "%s: %d/%d HP%n%n",
        resultado.getAlvo().getNome(),
        resultado.getHpRestante(),
        resultado.getAlvo().getHpMaximo()
    );
  }

  /**
   * Exibe o resultado da utilização de um item.
   *
   * @param resultado resultado da utilização do item
   */
  public void mostrarResultadoItem(ResultadoItem resultado) {
    System.out.printf(
        "%n"
            + "%s usou %s!%n",
        resultado.getUsuario().getNome(),
        resultado.getItem().getNome()
    );

    switch (resultado.getItem().getTipoEfeito()) {
      case CURA_TOTAL:
        System.out.printf(
            "HP restaurado: %d/%d%n%n",
            resultado.getUsuario().getHpAtual(),
            resultado.getUsuario().getHpMaximo()
        );
        break;

      case AUMENTA_SPEED:
        System.out.printf(
            "Velocidade aumentada em 30pts!%n%n"
        );
        break;

      case REMOVE_EFEITO:
        System.out.println("Todos os efeitos foram removidos!%n%n");
        break;

      default:
        break;
    }
  }
}