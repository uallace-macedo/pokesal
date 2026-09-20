package com.pokesal.model;

public class EfeitoAtivo {

  private EfeitoAtk efeito;
  private int rodadasRestantes;

  public EfeitoAtivo(EfeitoAtk efeito) {
    this.efeito = efeito;
    this.rodadasRestantes = efeito.getRodadas();
  }

  public EfeitoAtk getEfeito() {
    return efeito;
  }

  public int getRodadasRestantes() {
    return rodadasRestantes;
  }

  public void diminuirRodada() {
    rodadasRestantes--;
  }
}
