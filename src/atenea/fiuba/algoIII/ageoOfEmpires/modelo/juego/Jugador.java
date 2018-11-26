package atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.AldeanosOcupadosException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.NoHayEdificiosEnConstruccionException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;

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
    private Mapa mapa;
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

    private void condicionesIniciales(Mapa mapa) {
        this.bolsaDeOro = oroInicial;
        this.mapa = mapa;

        // Si ya se puso a un jugador en una posicion predefinida uso la otra
        if(!colocarPosicionablesEnPosicionA()) {
            colocarPosicionablesEnPosicionB();
        }
    }

    private boolean colocarPosicionablesEnPosicionA(){
        // Creo los posicionables
        Posicion posPlazaCentral = new PosicionCuadrado(8,8,9,7);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        // Trato de posicionar uno apra ver si ya se uno esta posicion predefinida
        try{
            this.mapa.posicionar(plazaCentral);

        }catch(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException e){
            return false;
        }

        Posicion posCastillo = new PosicionCuadrado(5,5,8,2);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,8,10);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,10,8);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,10,6);

        Unidad aldeano1 = new Aldeano(posAldeano1, new EdificiosEnConstruccionFabrica());
        Unidad aldeano2 = new Aldeano(posAldeano2, new EdificiosEnConstruccionFabrica());
        Unidad aldeano3 = new Aldeano(posAldeano3, new EdificiosEnConstruccionFabrica());


        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        return true;
    }

    private void colocarPosicionablesEnPosicionB(){

        Posicion posPlazaCentral = new PosicionCuadrado(20,8,21,7);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        Posicion posCastillo = new PosicionCuadrado(20,5,23,2);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,20,10);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,18,8);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,17,7);

        Unidad aldeano1 = new Aldeano(posAldeano1, new EdificiosEnConstruccionFabrica());
        Unidad aldeano2 = new Aldeano(posAldeano2, new EdificiosEnConstruccionFabrica());
        Unidad aldeano3 = new Aldeano(posAldeano3, new EdificiosEnConstruccionFabrica());

        this.mapa.posicionar(plazaCentral);
        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);
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
