package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.*;

public class Jugador {
    private ColeccionDePosisionables posisionables;
    private int bolsaDeOro;
    private static final int  oroInicial = 100;


    public Jugador (){
      this.posisionables = new ColeccionDePosisionables();
      this.bolsaDeOro = oroInicial;
    }


    public boolean tieneOro(int cantidad){
        return (this.bolsaDeOro >= cantidad );

    }


    public void ordenarRecolectarOro(){

    }

    public void ordenarIniciarConstruccionPlazaCentral(){

    }

   public void ordenarAvanzarConstruccion(){

   }

   public void ordenarIniciarConstruccionCuartel(){

    }

}
