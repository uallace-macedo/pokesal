package com.pokesal.battle;

import com.pokesal.model.Ambiente;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.TipoElemento;
import com.pokesal.model.TipoHabilidades;

public class Combate {

  public int calcularAtaqueEfetivo(PokeDeBatalha poke, Ambiente ambiente) {

    if(!ambienteFavorece(poke, ambiente)) {
      return poke.getAtaque();
    }

    return (int) (
      poke.getAtaque() * (1 + ambiente.getAumentaAtk())
    );
  }

  public int calcularDefesaEfetiva(PokeDeBatalha poke, Ambiente ambiente) {

    if(!ambienteFavorece(poke, ambiente)) {
      return poke.getDefesa();
    }

    return (int) (
      poke.getDefesa() * (1 + ambiente.getAumentaDef())
    );
  }

  public int calcularVelocidadeEfetiva(PokeDeBatalha poke, Ambiente ambiente) {

    if(!ambienteFavorece(poke, ambiente)) {
      return poke.getVelocidade();
    }

    return (int) (
      poke.getVelocidade() * (1 + ambiente.getAumentaSpd())
    );
  }

  public int calcularDano(PokeDeBatalha atacante, PokeDeBatalha alvo, Habilidade habilidade, Ambiente ambiente) {
    
    int ataqueEfetivo = calcularAtaqueEfetivo(atacante, ambiente);
    int defesaEfetiva = calcularDefesaEfetiva(alvo, ambiente);

    double multiplicador = calcularMultiplicadorTipo(habilidade, alvo);
    double dano = Math.max(1,
      (ataqueEfetivo + habilidade.getDano()) * multiplicador - (defesaEfetiva / 2.0)
    );

    return (int) dano;
  }

  public ResultadoAtaque atacar(
    PokeDeBatalha atacante,
    PokeDeBatalha alvo,
    Habilidade habilidade,
    Ambiente ambiente
  ) {

    int dano = calcularDano(atacante, alvo, habilidade, ambiente);
    int novoHp = Math.max(0, alvo.getHpAtual() - dano);
    alvo.setHpAtual(novoHp);

    return new ResultadoAtaque(
      atacante,
      alvo,
      habilidade,
      dano,
      novoHp
    );
  }

  public ResultadoItem usarItem(PokeDeBatalha usuario, Item item) {
    
    switch (item.getTipoEfeito()) {
      case CURA_TOTAL:
        usuario.curarTotal();
        break;

      case REMOVE_EFEITO:
        usuario.removerEfeito();
        break;

      case AUMENTA_SPEED:
        usuario.aumentarVelocidade(item.getValor());
        break;
    }

    usuario.getTreinador().getMochila().remove(item);
    return new ResultadoItem(usuario, item);
  }

  private double calcularMultiplicadorTipo(Habilidade habilidade, PokeDeBatalha alvo) {
    
    TipoHabilidades tipoAtaque = habilidade.getTipoHabilidade();
    TipoElemento tipoAlvo = alvo.getTipoElemento();

    double multiplicador = 1.0;

    switch (tipoAtaque) {
      case FOGO:
        if(tipoAlvo == TipoElemento.PLANTA) multiplicador = 2.0;
        if(tipoAlvo == TipoElemento.AGUA) multiplicador = 0.5;
        break;

      case AGUA:
        if(tipoAlvo == TipoElemento.FOGO) multiplicador = 2.0;
        if(tipoAlvo == TipoElemento.PLANTA) multiplicador = 0.5;
        break;

      case PLANTA:
        if(tipoAlvo == TipoElemento.AGUA) multiplicador = 2.0;
        if(tipoAlvo == TipoElemento.FOGO) multiplicador = 0.5;
        break;

      default:
        break;
    }

    return multiplicador;
  }

  private boolean ambienteFavorece(PokeDeBatalha poke, Ambiente ambiente) {
    return poke.getTipoElemento() == ambiente.getTipoElemento();
  }
}
