package com.pokesal.ui;

import java.util.ArrayList;
import java.util.Scanner;

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
      "======= AÇÃO =======%n" +
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
        "%d. %s",
        (i + 1),
        habilidade.getNome()
      );
    }

    System.out.printf(
      "===========================%n" +
      "Escolha: "
    );
  }

  public void mostrarItens(ArrayList<Item> itens) {
    System.out.println("\n======= ITENS =======");

    for(int i = 0; i < itens.size(); i++) {
      Item item = itens.get(i);
      System.out.printf(
        "%d. %s",
        (i + 1),
        item.getNome()
      );
    }

    System.out.printf(
      "=====================%n" +
      "Escolha: "
    );
  }
}
