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
