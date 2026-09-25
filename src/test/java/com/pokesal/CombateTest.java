package com.pokesal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pokesal.battle.Combate;
import com.pokesal.battle.ResultadoAtaque;
import com.pokesal.data.AmbienteData;
import com.pokesal.data.HabilidadeData;
import com.pokesal.data.ItemData;
import com.pokesal.model.Ambiente;
import com.pokesal.model.EfeitoAtivo;
import com.pokesal.model.EfeitoAtk;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.Pokesal;
import com.pokesal.model.TipoElemento;
import com.pokesal.model.TipoHabilidades;
import com.pokesal.model.Treinador;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CombateTest {

  private final Combate combate = new Combate();

  private PokeDeBatalha criarPoke(
      String nome,
      int hp,
      int defesa,
      int ataque,
      int velocidade,
      TipoElemento tipo,
      ArrayList<Habilidade> habilidades
  ) {
    Pokesal pokesal = new Pokesal(
        nome,
        hp,
        defesa,
        ataque,
        velocidade,
        tipo,
        habilidades
    );

    Treinador treinador = new Treinador(
        "Treinador Teste",
        pokesal,
        new ArrayList<>()
    );

    return treinador.armarParaBatalha();
  }

  private Ambiente criarAmbienteSemBonus() {
    return new Ambiente(
        "Ambiente Neutro",
        TipoElemento.PLANTA,
        0,
        0,
        0
    );
  }

  @Test
  void testVantagemElemental() {
    Ambiente ambiente = criarAmbienteSemBonus();

    PokeDeBatalha squirtSal = criarPoke(
        "SquirtSal",
        450,
        30,
        35,
        45,
        TipoElemento.AGUA,
        new ArrayList<>()
    );

    PokeDeBatalha charSal = criarPoke(
        "CharSal",
        330,
        15,
        50,
        100,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    PokeDeBatalha bulbaSal = criarPoke(
        "BulbaSal",
        380,
        25,
        35,
        60,
        TipoElemento.PLANTA,
        new ArrayList<>()
    );

    int danoAguaContraFogo = combate.calcularDano(
        squirtSal,
        charSal,
        HabilidadeData.GOTEIRA,
        ambiente
    );

    int danoFogoContraPlanta = combate.calcularDano(
        charSal,
        bulbaSal,
        HabilidadeData.FUMACA_DE_CIGARRO,
        ambiente
    );

    int danoPlantaContraAgua = combate.calcularDano(
        bulbaSal,
        squirtSal,
        HabilidadeData.QUEDA_DE_MANGA,
        ambiente
    );

    int danoFogoContraAgua = combate.calcularDano(
        charSal,
        squirtSal,
        HabilidadeData.FUMACA_DE_CIGARRO,
        ambiente
    );
    assertEquals(146, danoAguaContraFogo);
    assertEquals(153, danoFogoContraPlanta);
    assertEquals(149, danoPlantaContraAgua);
    assertEquals(26, danoFogoContraAgua);
  }

  @Test
  void testEfeitoTerrenoEstacionamentoUcSal() {
    PokeDeBatalha charSal = criarPoke(
        "CharSal",
        330,
        15,
        50,
        100,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    Ambiente asfaltoQuente = AmbienteData.gerar().get(0);

    assertEquals(
        57,
        combate.calcularAtaqueEfetivo(
            charSal,
            asfaltoQuente
        )
    );

    assertEquals(
        15,
        combate.calcularDefesaEfetiva(
            charSal,
            asfaltoQuente
        )
    );
  }

  @Test
  void testCalculoDanoBoundaryValues() {
    PokeDeBatalha atacante = criarPoke(
        "Atacante",
        1,
        1,
        0,
        1,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    PokeDeBatalha alvo = criarPoke(
        "Alvo",
        1,
        100,
        1,
        1,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    Habilidade habilidade = new Habilidade(
        "Ataque Mínimo",
        0,
        TipoHabilidades.NORMAL,
        0,
        null
    );

    Ambiente ambiente = criarAmbienteSemBonus();

    int dano = combate.calcularDano(
        atacante,
        alvo,
        habilidade,
        ambiente
    );

    assertEquals(1, dano);

    ResultadoAtaque resultado = combate.atacar(
        atacante,
        alvo,
        habilidade,
        ambiente
    );

    assertEquals(0, resultado.getHpRestante());
    assertEquals(1, resultado.getDano());
  }

  @Test
  void testEfeitoItens() {
    Pokesal pokesal = new Pokesal(
        "Teste",
        300,
        20,
        30,
        40,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    ArrayList<Item> mochila = new ArrayList<>(
        List.of(
            ItemData.BENCA_DO_PADRE,
            ItemData.SEGUNDA_CHAMADA,
            ItemData.REDBULL
        )
    );

    Treinador treinador = new Treinador(
        "Treinador Teste",
        pokesal,
        mochila
    );

    PokeDeBatalha poke = treinador.armarParaBatalha();

    poke.setHpAtual(100);

    combate.usarItem(
        poke,
        ItemData.BENCA_DO_PADRE
    );

    assertEquals(
        300,
        poke.getHpAtual()
    );

    EfeitoAtk efeito = new EfeitoAtk(
        "Efeito Teste",
        5,
        10,
        5,
        3
    );

    poke.setEfeitoAtivo(
        new EfeitoAtivo(efeito)
    );

    combate.usarItem(
        poke,
        ItemData.SEGUNDA_CHAMADA
    );

    assertEquals(
        null,
        poke.getEfeitoAtivo()
    );

    int velocidadeAntes = poke.getVelocidade();

    combate.usarItem(
        poke,
        ItemData.REDBULL
    );

    assertEquals(
        velocidadeAntes + 30,
        poke.getVelocidade()
    );
  }

  @Test
  void deveReduzirHpDoAlvoAoAtacar() {
    PokeDeBatalha atacante = criarPoke(
        "CharSal",
        330,
        15,
        50,
        100,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    PokeDeBatalha alvo = criarPoke(
        "BulbaSal",
        380,
        25,
        35,
        60,
        TipoElemento.PLANTA,
        new ArrayList<>()
    );

    Ambiente ambiente = AmbienteData.gerar().get(0);

    int hpInicial = alvo.getHpAtual();

    ResultadoAtaque resultado = combate.atacar(
        atacante,
        alvo,
        HabilidadeData.FUMACA_DE_CIGARRO,
        ambiente
    );

    assertTrue(resultado.getDano() > 0);

    assertEquals(
        hpInicial - resultado.getDano(),
        resultado.getHpRestante()
    );

    assertEquals(
        resultado.getHpRestante(),
        alvo.getHpAtual()
    );
  }

  @Test
  void naoDevePermitirHpNegativoAoAtacar() {
    PokeDeBatalha atacante = criarPoke(
        "CharSal",
        330,
        15,
        50,
        100,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    PokeDeBatalha alvo = criarPoke(
        "BulbaSal",
        1,
        25,
        35,
        60,
        TipoElemento.PLANTA,
        new ArrayList<>()
    );

    Ambiente ambiente = AmbienteData.gerar().get(0);

    ResultadoAtaque resultado = combate.atacar(
        atacante,
        alvo,
        HabilidadeData.FUMACA_DE_CIGARRO,
        ambiente
    );

    assertEquals(
        0,
        alvo.getHpAtual()
    );

    assertEquals(
        0,
        resultado.getHpRestante()
    );
  }

  @Test
  void deveRemoverItemDaMochilaDepoisDeUsar() {
    Pokesal pokesal = new Pokesal(
        "Teste",
        300,
        20,
        30,
        40,
        TipoElemento.FOGO,
        new ArrayList<>()
    );

    ArrayList<Item> mochila = new ArrayList<>(
        List.of(ItemData.REDBULL)
    );

    Treinador treinador = new Treinador(
        "Treinador Teste",
        pokesal,
        mochila
    );

    PokeDeBatalha poke = treinador.armarParaBatalha();

    combate.usarItem(
        poke,
        ItemData.REDBULL
    );

    assertTrue(mochila.isEmpty());
  }
}