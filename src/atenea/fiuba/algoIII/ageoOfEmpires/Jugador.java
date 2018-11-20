package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.*;

public class Jugador {
    private int banco;
    private static final int oroInicial = 100;
    private ColeccionDePosisionables posisionables;


    public Jugador (){
      this.banco = oroInicial;
      this.posisionables = new ColeccionDePosisionables();
      this.posisionables.recursosBasicos();
    }

}
