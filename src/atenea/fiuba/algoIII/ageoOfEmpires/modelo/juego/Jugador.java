package atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OroInsuficienteException;

public class Jugador {
    private Mapa mapa;
    private Plebe plebe;
    private Construcciones construcciones;
    private Ejercito ejercito;
    private Castillo castillo;
    private int bolsaDeOro;
    private static final int oroInicial = 100;


    public Jugador(Mapa mapa) {
        this.mapa = mapa;
        this.plebe = new Plebe();
        this.construcciones = new Construcciones();
        this.ejercito = new Ejercito();
        this.condicionesIniciales();
    }

    private void condicionesIniciales() {
        this.bolsaDeOro = oroInicial;
        if(!colocarPosicionablesEnPosicionA()) {
            colocarPosicionablesEnPosicionB();
        }
    }

    private boolean colocarPosicionablesEnPosicionA(){
        // Creo los posicionables
        Posicion posPlazaCentral = new PosicionCuadrado(8,8,9,7);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        try{
            this.mapa.posicionar(plazaCentral);

        }catch(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException e){
            return false;
        }

        // Cre posiciones y le asigno las posiciones a los edificios/aldeanos
        Posicion posCastillo = new PosicionCuadrado(5,5,8,2);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,8,10);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,10,8);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,10,6);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        //
        this.castillo = castillo;
        this.construcciones.agregarEdificio(plazaCentral);

        this.plebe.agregarAldeano(aldeano1);
        this.plebe.agregarAldeano(aldeano2);
        this.plebe.agregarAldeano(aldeano3);

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

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(plazaCentral);
        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);


        this.castillo = castillo;
        this.construcciones.agregarEdificio(plazaCentral);

        this.plebe.agregarAldeano(aldeano1);
        this.plebe.agregarAldeano(aldeano2);
        this.plebe.agregarAldeano(aldeano3);
    }


    public void pagarCosto(int costo) {
        if (this.bolsaDeOro >= costo) {
            this.bolsaDeOro = this.bolsaDeOro - costo;
        }
        else{
            throw new OroInsuficienteException();
        }
    }


    public void ordenarRecolectarOro() {
        int oroRecolectado = this.plebe.trabajar();
        bolsaDeOro = (bolsaDeOro + oroRecolectado);
    }


    public void agregarEdificio(Edificio edificio) {
        this.construcciones.agregarEdificio(edificio);
    }

    public void agregarAldeano(Aldeano aldeano){
        this.plebe.agregarAldeano(aldeano);
    }

    public void agregarUnidadMilitar(UnidadMilitar unidadMilitar){
        this.ejercito.agregarUnidad(unidadMilitar);
    }


    /*
    //SUJETO A VERIFICACION ! ! ! ! ! ! ! ! ! ! !
     public void actualizarVidaDePosicionables(){
        this.ejercito.actualizarVidaDeUnidadesMilitares();
        this.plebe.actualizarVidaDeAldeanos();
        this.construcciones.actualizarVidaDeEdificios();
        this.castillo.actualizarVidaDelCastillo();
    }
    */
}