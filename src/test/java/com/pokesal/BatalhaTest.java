package com.pokesal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pokesal.battle.Batalha;
import com.pokesal.battle.ResultadoAtaque;
import com.pokesal.battle.ResultadoItem;
import com.pokesal.model.Ambiente;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.Pokesal;
import com.pokesal.model.TipoEfeitoItem;
import com.pokesal.model.TipoElemento;
import com.pokesal.model.TipoHabilidades;
import com.pokesal.model.Treinador;
import com.pokesal.ui.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class BatalhaTest {

  private static class ConsoleDeTeste extends Console {

    private final Queue<Integer> opcoes = new LinkedList<>();
    private final ArrayList<String> ataquesExecutados = new ArrayList<>();
    private final ArrayList<String> mensagens = new ArrayList<>();

    void adicionarOpcoes(Integer... valores) {
      opcoes.addAll(List.of(valores));
    }

    ArrayList<String> getAtaquesExecutados() {
      return ataquesExecutados;
    }

    ArrayList<String> getMensagens() {
      return mensagens;
    }

    @Override
    public int lerOpcao() {
      if (opcoes.isEmpty()) {
        throw new IllegalStateException(
            "Não há mais opções configuradas para o teste."
        );
      }

      return opcoes.remove();
    }

    @Override
    public void mostrarInicioRodada(int rodada) {
      // Intencionalmente vazio: evita saída no console durante os testes.
    }

    @Override
    public void mostrarExecucaoRodada() {
      // Intencionalmente vazio: evita saída no console durante os testes.
    }

    @Override
    public void mostrarMenuAcao(PokeDeBatalha poke) {
      // Intencionalmente vazio: o teste fornece as opções diretamente.
    }

    @Override
    public void mostrarHabilidades(PokeDeBatalha poke) {
      // Intencionalmente vazio: o teste fornece a habilidade diretamente.
    }

    @Override
    public void mostrarItens(ArrayList<Item> itens) {
      // Intencionalmente vazio: o teste controla os itens pela fila de opções.
    }

    @Override
    public void mostrarAcaoEscolhida(PokeDeBatalha poke) {
      // Intencionalmente vazio: não é necessário exibir a ação durante o teste.
    }

    @Override
    public void mostrarResultadoItem(ResultadoItem resultado) {
        // Intencionalmente vazio: não é necessário exibir a ação durante o teste.
    }

    @Override
    public void mostrarResultadoAtaque(ResultadoAtaque resultado) {
      ataquesExecutados.add(resultado.getAtacante().getNome());
    }

    @Override
    public void mostrarMensagem(String mensagem) {
      mensagens.add(mensagem);
    }
  }

  private PokeDeBatalha criarPoke(
      String nome,
      int hp,
      int defesa,
      int ataque,
      int velocidade,
      TipoElemento tipo,
      Habilidade habilidade,
      ArrayList<Item> mochila
  ) {
    Pokesal pokesal = new Pokesal(
        nome,
        hp,
        defesa,
        ataque,
        velocidade,
        tipo,
        new ArrayList<>(List.of(habilidade))
    );

    Treinador treinador = new Treinador(
        "Treinador Teste",
        pokesal,
        mochila
    );

    return treinador.armarParaBatalha();
  }

  private Habilidade criarHabilidade(String nome, int dano) {
    return new Habilidade(
        nome,
        dano,
        TipoHabilidades.NORMAL,
        0,
        null
    );
  }

  private Ambiente criarAmbienteNeutro() {
    return new Ambiente(
        "Ambiente Neutro",
        TipoElemento.FOGO,
        0,
        0,
        0
    );
  }

  @Test
  void testOrdemDeAtaquePorVelocidade() {
    Habilidade ataqueJogador = criarHabilidade(
        "Ataque do Jogador",
        100
    );

    Habilidade ataqueOponente = criarHabilidade(
        "Ataque do Oponente",
        1
    );

    PokeDeBatalha jogador = criarPoke(
        "Jogador",
        100,
        10,
        100,
        100,
        TipoElemento.FOGO,
        ataqueJogador,
        new ArrayList<>()
    );

    PokeDeBatalha oponente = criarPoke(
        "Oponente",
        100,
        10,
        1,
        50,
        TipoElemento.AGUA,
        ataqueOponente,
        new ArrayList<>()
    );

    ConsoleDeTeste console = new ConsoleDeTeste();

    console.adicionarOpcoes(
        1, 1,
        1, 1
    );

    Batalha batalha = new Batalha(
        criarAmbienteNeutro(),
        jogador,
        oponente,
        console
    );

    batalha.iniciar();

    assertEquals(1, console.getAtaquesExecutados().size());

    assertEquals(
        "Jogador",
        console.getAtaquesExecutados().get(0)
    );

    assertEquals(0, oponente.getHpAtual());
  }

  @Test
  void testUsoLimiteDeItensExcedido() {
    Habilidade ataqueFinal = criarHabilidade(
        "Ataque Final",
        100
    );

    Habilidade ataqueFraco = criarHabilidade(
        "Ataque Fraco",
        1
    );

    ArrayList<Item> mochilaJogador = new ArrayList<>(
        List.of(
            criarItem("Item 1"),
            criarItem("Item 2"),
            criarItem("Item 3")
        )
    );

    PokeDeBatalha jogador = criarPoke(
        "Jogador",
        100,
        10,
        100,
        100,
        TipoElemento.FOGO,
        ataqueFinal,
        mochilaJogador
    );

    PokeDeBatalha oponente = criarPoke(
        "Oponente",
        100,
        10,
        1,
        50,
        TipoElemento.AGUA,
        ataqueFraco,
        new ArrayList<>()
    );

    ConsoleDeTeste console = new ConsoleDeTeste();

    /*
     * Rodada 1:
     * Jogador usa Item 1.
     * Oponente ataca.
     *
     * Rodada 2:
     * Jogador usa Item 2.
     * Oponente ataca.
     *
     * Rodada 3:
     * Jogador tenta usar Item 3.
     * O limite é atingido.
     * Jogador volta ao menu e escolhe atacar.
     * Oponente escolhe atacar.
     */
    console.adicionarOpcoes(
        2, 1,
        1, 1,

        2, 1,
        1, 1,

        2,
        1, 1,

        1, 1
    );

    Batalha batalha = new Batalha(
        criarAmbienteNeutro(),
        jogador,
        oponente,
        console
    );

    batalha.iniciar();

    assertEquals(1, mochilaJogador.size());

    assertEquals(
        "Item 3",
        mochilaJogador.get(0).getNome()
    );

    assertTrue(
        console.getMensagens().contains(
            "Você já utilizou o limite de itens nesta batalha!"
        )
    );

    assertTrue(
        console.getAtaquesExecutados().contains("Jogador")
    );

    assertEquals(0, oponente.getHpAtual());
  }

  private Item criarItem(String nome) {
    return new Item(
        nome,
        "Item de teste",
        TipoEfeitoItem.CURA_TOTAL,
        0
    );
  }
}
