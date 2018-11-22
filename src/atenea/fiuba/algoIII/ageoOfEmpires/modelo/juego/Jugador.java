package atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Cuartel;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.AldeanosOcupadosException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.NoHayEdificiosEnConstruccionException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Castillo;

import java.util.*;

public class Jugador {
    private Castillo castillo;
    private List<PlazaCentral> plazas;
    private List<Cuartel> cuarteles;
//    private LinkedList<Aldeano> aldeanos;

    Aldeanos aldeanos = new Aldeanos();

    private List<ArmaDeAsedio> armas;
    private List<Arquero> arqueros;
    private List<Espadachin> espadachines;
    private int primerPosicion;
    private int bolsaDeOro;
    private static final int  oroInicial = 100;


    public Jugador (){
      this.plazas = new ArrayList<>();
      this.cuarteles = new ArrayList<>();
//      this.aldeanos = new LinkedList<>();
      this.armas = new ArrayList<>();
      this.arqueros = new ArrayList<>();
      this.espadachines = new ArrayList<>();
      this.castillo = new EdificiosFabrica().crearCastillo();
      this.bolsaDeOro = 0;
      this.primerPosicion = 0;
      this.recursosBasicos();
    }

    private void recursosBasicos(){
        this.bolsaDeOro = oroInicial;
        this.plazas.add(new EdificiosFabrica().crearPlazaCentral());
        for(int cantidad = 1; cantidad<=3;cantidad++){
            Aldeano aldeano = this.plazas.get(this.primerPosicion).construirAldeano();
            this.aldeanos.agregar(aldeano);
        }
    }
    
    public boolean tieneAldeanos(int cantidad){
        return aldeanos.cantidad() > 0;
    }


    public boolean tieneOro(int cantidad){
        return (this.bolsaDeOro >= cantidad );

    }

    public int tieneCuarteles(){
        return (this.cuarteles.size() );
    }

    public int tienePlazas(){
        return (this.plazas.size() );
    }

    public void ordenarRecolectarOro(){
        for (Aldeano aldeano: this.aldeanos) {
            this.bolsaDeOro += aldeano.trabajar();
        }
    }



//    public void ordenarIniciarConstruccionPlazaCentral(){
//        if(this.aldeanos.noTieneAldeanos()){
//            throw new JugadorNoTieneAldeanosExcepcion();
//        }
//
//        Aldeano aldeano = this.aldeanos.get(0);
//        aldeano.iniciarConstruccionDePlazaCentral(plaza ->this.plazas.add(plaza));
//    }
//
//
//
//   public void ordenarIniciarConstruccionCuartel(){
//       if( this.aldeanos.noTieneAldeanos()){
//           throw new JugadorNoTieneAldeanosExcepcion();
//       }
//
//       Aldeano aldeano = this.aldeanos.get(0);
//       aldeano.iniciarConstruccionDeCuartel(cuartel ->this.cuarteles.add(cuartel));
//    }

}
