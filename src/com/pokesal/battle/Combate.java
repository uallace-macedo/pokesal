package com.pokesal.battle;

import com.pokesal.model.Ambiente;
import com.pokesal.model.Habilidade;
import com.pokesal.model.Item;
import com.pokesal.model.PokeDeBatalha;
import com.pokesal.model.TipoElemento;
import com.pokesal.model.TipoHabilidades;

/**
 * Contém as regras e operações relacionadas ao combate entre Pokesals.
 */
public class Combate {

  /**
   * Calcula o valor efetivo do ataque de um Pokesal considerando o ambiente.
   *
   * @param poke Pokesal cujo ataque será calculado
   * @param ambiente ambiente da batalha
   * @return valor efetivo do ataque
   */
  public int calcularAtaqueEfetivo(PokeDeBatalha poke, Ambiente ambiente) {
    if (!ambienteFavorece(poke, ambiente)) {
      return poke.getAtaque();
    }

    return (int) (poke.getAtaque() * (1 + ambiente.getAumentaAtk()));
  }

  /**
   * Calcula o valor efetivo da defesa de um Pokesal considerando o ambiente.
   *
   * @param poke Pokesal cuja defesa será calculada
   * @param ambiente ambiente da batalha
   * @return valor efetivo da defesa
   */
  public int calcularDefesaEfetiva(PokeDeBatalha poke, Ambiente ambiente) {
    if (!ambienteFavorece(poke, ambiente)) {
      return poke.getDefesa();
    }

    return (int) (poke.getDefesa() * (1 + ambiente.getAumentaDef()));
  }

  /**
   * Calcula o valor efetivo da velocidade de um Pokesal considerando o ambiente.
   *
   * @param poke Pokesal cuja velocidade será calculada
   * @param ambiente ambiente da batalha
   * @return valor efetivo da velocidade
   */
  public int calcularVelocidadeEfetiva(PokeDeBatalha poke,
      Ambiente ambiente) {
    if (!ambienteFavorece(poke, ambiente)) {
      return poke.getVelocidade();
    }

    return (int) (poke.getVelocidade() * (1 + ambiente.getAumentaSpd()));
  }

  /**
   * Calcula o dano causado por uma habilidade.
   *
   * @param atacante Pokesal que realiza o ataque
   * @param alvo Pokesal que recebe o ataque
   * @param habilidade habilidade utilizada
   * @param ambiente ambiente da batalha
   * @return dano calculado
   */
  public int calcularDano(PokeDeBatalha atacante, PokeDeBatalha alvo,
      Habilidade habilidade, Ambiente ambiente) {
    int ataqueEfetivo = calcularAtaqueEfetivo(atacante, ambiente);
    int defesaEfetiva = calcularDefesaEfetiva(alvo, ambiente);

    double multiplicador = calcularMultiplicadorTipo(habilidade, alvo);
    double dano = Math.max(
        1,
        (ataqueEfetivo + habilidade.getDano()) * multiplicador
            - (defesaEfetiva / 2.0));

    return (int) dano;
  }

  /**
   * Realiza um ataque contra um Pokesal alvo.
   *
   * @param atacante Pokesal que realiza o ataque
   * @param alvo Pokesal que recebe o ataque
   * @param habilidade habilidade utilizada
   * @param ambiente ambiente da batalha
   * @return resultado do ataque
   */
  public ResultadoAtaque atacar(PokeDeBatalha atacante, PokeDeBatalha alvo,
      Habilidade habilidade, Ambiente ambiente) {
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

  /**
   * Utiliza um item durante a batalha.
   *
   * @param usuario Pokesal que utiliza o item
   * @param item item utilizado
   * @return resultado da utilização do item
   */
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
      default:
        break;
    }

    usuario.getTreinador().getMochila().remove(item);
    return new ResultadoItem(usuario, item);
  }

  /**
   * Calcula o multiplicador de dano de acordo com os tipos envolvidos.
   *
   * @param habilidade habilidade utilizada no ataque
   * @param alvo Pokesal que recebe o ataque
   * @return multiplicador de dano
   */
  private double calcularMultiplicadorTipo(Habilidade habilidade,
      PokeDeBatalha alvo) {
    TipoHabilidades tipoAtaque = habilidade.getTipoHabilidade();
    TipoElemento tipoAlvo = alvo.getTipoElemento();

    double multiplicador = 1.0;

    switch (tipoAtaque) {
      case FOGO:
        if (tipoAlvo == TipoElemento.PLANTA) {
          multiplicador = 2.0;
        }
        if (tipoAlvo == TipoElemento.AGUA) {
          multiplicador = 0.5;
        }
        break;

      case AGUA:
        if (tipoAlvo == TipoElemento.FOGO) {
          multiplicador = 2.0;
        }
        if (tipoAlvo == TipoElemento.PLANTA) {
          multiplicador = 0.5;
        }
        break;

      case PLANTA:
        if (tipoAlvo == TipoElemento.AGUA) {
          multiplicador = 2.0;
        }
        if (tipoAlvo == TipoElemento.FOGO) {
          multiplicador = 0.5;
        }
        break;

      default:
        break;
    }

    return multiplicador;
  }

  /**
   * Verifica se o ambiente favorece o Pokesal.
   *
   * @param poke Pokesal a ser verificado
   * @param ambiente ambiente da batalha
   * @return true se o tipo do Pokesal corresponde ao tipo do ambiente
   */
  private boolean ambienteFavorece(PokeDeBatalha poke, Ambiente ambiente) {
    return poke.getTipoElemento() == ambiente.getTipoElemento();
  }
}