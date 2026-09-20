package com.pokesal.battle;

import com.pokesal.model.Habilidade;
import com.pokesal.model.PokeDeBatalha;

public class ResultadoAtaque {
  
  private PokeDeBatalha atacante;
  private PokeDeBatalha alvo;
  private Habilidade habilidade;
  private int dano;
  private int hpRestante;

  public ResultadoAtaque(
    PokeDeBatalha atacante,
    PokeDeBatalha alvo,
    Habilidade habilidade,
    int dano,
    int hpRestante
  ) {
    this.atacante = atacante;
    this.alvo = alvo;
    this.habilidade = habilidade;
    this.dano = dano;
    this.hpRestante = hpRestante;
  }

  public PokeDeBatalha getAtacante() {
    return atacante;
  }

  public PokeDeBatalha getAlvo() {
    return alvo;
  }

  public Habilidade getHabilidade() {
    return habilidade;
  }

  public int getDano() {
    return dano;
  }

  public int getHpRestante() {
    return hpRestante;
  }
}
