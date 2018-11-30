package modelo.juego;

import modelo.edificios.Castillo;
import modelo.edificios.EstrategiaAtaqueCastillo;
import modelo.edificios.PlazaCentral;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import modelo.posicion.PosicionCuadrado;
import modelo.posicion.PosicionDeUnCasillero;
import modelo.unidades.Aldeano;
import modelo.unidades.UnidadesFabrica;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;

    public Juego(String nombreJugador1, String nombreJugador2){
        this.mapa = new Mapa(20,30);
        colocarPosicionablesEnEsquinaInferiorIzquierda(nombreJugador1);
        colocarPosicionablesEnEsquinaSuperiorDerecha(nombreJugador2);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.turno = new Turno(jugadores);
    }

    private void colocarPosicionablesEnEsquinaInferiorIzquierda(String nombreJugador){
        // plaza esta en arriba de castillo
        Posicion posPlazaCentral = new PosicionCuadrado(0,6,1,5);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());
        this.mapa.posicionar(plazaCentral);

        // castillo en la esquina inferior izquierda
        Posicion posCastillo = new PosicionCuadrado(0,3,3,0);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,0,7);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,1,7);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,2,7);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        this.jugador1 = new Jugador(nombreJugador, castillo);

        this.jugador1.agregar(plazaCentral);
        this.jugador1.agregar(aldeano1);
        this.jugador1.agregar(aldeano2);
        this.jugador1.agregar(aldeano3);
    }

    private void colocarPosicionablesEnEsquinaSuperiorDerecha(String nombreJugador){

        // plaza esta debajo del castillo
        Posicion posPlazaCentral = new PosicionCuadrado(27,15,28,14);
        PlazaCentral plazaCentral = new PlazaCentral(posPlazaCentral, new UnidadesFabrica());

        // castillo en la esquina superior derecha
        Posicion posCastillo = new PosicionCuadrado(27,20,30,17);
        Castillo castillo = new Castillo(posCastillo,new UnidadesFabrica(), new EstrategiaAtaqueCastillo());

        Posicion posAldeano1 =  new PosicionDeUnCasillero(this.mapa,29,13);
        Posicion posAldeano2 = new PosicionDeUnCasillero(this.mapa,28,13);
        Posicion posAldeano3 = new PosicionDeUnCasillero(this.mapa,27,13);

        Aldeano aldeano1 = new Aldeano(posAldeano1);
        Aldeano aldeano2 = new Aldeano(posAldeano2);
        Aldeano aldeano3 = new Aldeano(posAldeano3);

        this.mapa.posicionar(plazaCentral);
        this.mapa.posicionar(castillo);
        this.mapa.posicionar(aldeano1);
        this.mapa.posicionar(aldeano2);
        this.mapa.posicionar(aldeano3);

        this.jugador2 = new Jugador(nombreJugador, castillo);

        this.jugador2.agregar(plazaCentral);
        this.jugador2.agregar(aldeano1);
        this.jugador2.agregar(aldeano2);
        this.jugador2.agregar(aldeano3);
    }

    public void hayGanador()
    {


    }
}
