package com.pokesal.data;

import com.pokesal.model.Ambiente;
import com.pokesal.model.TipoElemento;
import java.util.ArrayList;
import java.util.List;

/**
 * Fornece os ambientes disponíveis para as batalhas.
 */
public class AmbienteData {

  /**
   * Gera a lista de ambientes disponíveis.
   *
   * @return lista de ambientes
   */
  public static ArrayList<Ambiente> gerar() {
    final Ambiente asfaltoQuente = new Ambiente(
        "Asfalto Quente",
        TipoElemento.FOGO,
        0.15,
        0.05,
        0
    );

    final Ambiente diaChuvoso = new Ambiente(
        "Dia Chuvoso",
        TipoElemento.AGUA,
        0.1,
        0,
        0.8
    );

    final Ambiente reservaDePituacu = new Ambiente(
        "Reserva de Pituaçu",
        TipoElemento.PLANTA,
        0.5,
        0.2,
        0
    );

    return new ArrayList<Ambiente>(List.of(
        asfaltoQuente,
        diaChuvoso,
        reservaDePituacu
    ));
  }
}