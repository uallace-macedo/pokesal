package com.pokesal.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.pokesal.battle.ResultadoAtaque;
import com.pokesal.battle.ResultadoItem;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;

public class Console {
  private Scanner scan;

  public Console() {
    scan = new Scanner(System.in);
  }

  public int lerOpcao() {
    while(true) {
      String entrada = scan.nextLine();

      try {
        return Integer.parseInt(entrada);
      } catch (NumberFormatException e) {
        System.out.println("Digite um número válido!");
        System.out.println("Escolha: ");
      }
    }
  }

  public void mostrarMensagem(String mensagem) {
    System.out.println(mensagem);
  }

  public void mostrarMenuAcao() {
    System.out.printf(
      "%n======= AÇÃO =======%n" +
      "1. Atacar%n" +
      "2. Usar item%n" +
      "====================%n" +
      "Escolha: " 
    );
  }

  public void mostrarHabilidades(ArrayList<Habilidade> habilidades) {
    System.out.println("\n======= HABILIDADES =======");

    for(int i = 0; i < habilidades.size(); i++) {
      Habilidade habilidade = habilidades.get(i);
      System.out.printf(
        "%d. %s%n",
        (i + 1),
        habilidade.getNome()
      );
    }

    System.out.printf(
      "0. Voltar%n" +
      "===========================%n" +
      "Escolha: "
    );
  }

  public void mostrarItens(ArrayList<Item> itens) {
    System.out.println("\n======= ITENS =======");

    for(int i = 0; i < itens.size(); i++) {
      Item item = itens.get(i);
      System.out.printf(
        "%d. %s (%s)%n",
        (i + 1),
        item.getNome(),
        item.getDescricao()
      );
    }

    System.out.printf(
      "0. Voltar%n" +
      "=====================%n" +
      "Escolha: "
    );
  }

  public void mostrarResultadoAtaque(ResultadoAtaque resultado) {
    System.out.printf(
      "%n" +
      "%s usou %s!%n",
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

  public void mostrarResultadoItem(ResultadoItem resultado) {
    System.out.printf(
      "%n" +
      "%s usou %s!%n",
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
        System.out.printf("Velocidade aumentada em 30pts!%n");
        break;

      case REMOVE_EFEITO:
        System.out.println("Todos os efeitos foram removidos!");
        break;
    }
  }
}
