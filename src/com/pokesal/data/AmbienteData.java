package com.pokesal.data;

import java.util.ArrayList;
import java.util.List;

import com.pokesal.model.Ambiente;
import com.pokesal.model.TipoElemento;

public class AmbienteData {
  
  public static ArrayList<Ambiente> gerar() {
    Ambiente asfaltoQuente = new Ambiente(
      "Asfalto Quente",
      TipoElemento.FOGO,
      0.15,
      0.05,
      0
    );

    Ambiente diaChuvoso = new Ambiente(
      "Dia Chuvoso",
      TipoElemento.AGUA,
      0.1,
      0,
      0.8
    );

    Ambiente reservaDePituacu = new Ambiente(
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
