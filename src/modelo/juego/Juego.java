package modelo.juego;

import modelo.edificios.Castillo;
import modelo.edificios.EstrategiaAtaqueCastillo;
import modelo.edificios.PlazaCentral;
import modelo.posicion.*;
import modelo.unidades.Aldeano;
import modelo.unidades.UnidadesFabrica;

public class Juego {
    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(String nombreJugador1, String nombreJugador2){

        int alto = 20;
        int ancho = 30;
        this.mapa = new Mapa(alto, ancho);

        colocarPosicionablesEnEsquinaSuperiorIzquierda(nombreJugador1);
        colocarPosicionablesEnEsquinaInferiorDerecha(nombreJugador2);
    }

    private void colocarPosicionablesEnEsquinaSuperiorIzquierda(String nombreJugador){
        // plaza esta en arriba de castillo
        Posicion posPlazaCentral = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(3,3), 3);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());
        this.mapa.posicionar(plazaCentral);

        // castillo en la esquina inferior izquierda
        Posicion posCastillo = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(0,0), 3);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,5,1);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,1,5);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,6,6);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        this.jugador1 = new Jugador(nombreJugador, castillo, "Red");

        this.jugador1.agregar(plazaCentral);
        this.jugador1.agregar(aldeano1);
        this.jugador1.agregar(aldeano2);
        this.jugador1.agregar(aldeano3);
    }

    private void colocarPosicionablesEnEsquinaInferiorDerecha(String nombreJugador){

        // plaza esta debajo del castillo


        int ancho = this.getMapa().getAncho();
        int alto = this.getMapa().getAlto();

        Posicion posPlazaCentral = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(this.mapa.getAncho() - 6, this.mapa.getAlto() - 6), 3);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        // castillo en la esquina superior derecha
        Posicion posCastillo = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(this.mapa.getAncho() - 3, this.mapa.getAlto() - 3), 3);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa, ancho - 6, alto - 2);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa, ancho -2, alto - 6);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa, ancho - 7, alto -7);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(plazaCentral);
        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        this.jugador2 = new Jugador(nombreJugador, castillo, "Blue");

        this.jugador2.agregar(plazaCentral);
        this.jugador2.agregar(aldeano1);
        this.jugador2.agregar(aldeano2);
        this.jugador2.agregar(aldeano3);
    }

    public Mapa getMapa(){
        return this.mapa;
    }

    public Jugador getJugador1(){
        return jugador1;
    }

    public Jugador getJugador2(){
        return jugador2;
    }
}
