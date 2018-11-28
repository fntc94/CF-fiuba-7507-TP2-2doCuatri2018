package modelo.juego;

import modelo.ListaCircular;

import java.util.List;
import java.util.Random;

public class Turno {

    private ListaCircular<Jugador> listaDeParticipantes;
    private Jugador jugadorActual;
    private int cantidadDeParticipantes;
    private int siguiente;

    public Turno(List<Jugador> listaDeParticipantes){
        this.listaDeParticipantes = new ListaCircular<>();
        this.listaDeParticipantes.addAll(listaDeParticipantes);
        this.cantidadDeParticipantes = listaDeParticipantes.size();

        int randomPosicion = new Random().nextInt(cantidadDeParticipantes);
        this.jugadorActual = this.listaDeParticipantes.get(randomPosicion);
        this.siguiente = 0;
    }

    public Jugador devolverJugadorActual(){
        return jugadorActual;
    }

    public void cambiarDeTurno(){
        this.jugadorActual = this.listaDeParticipantes.get(this.siguiente+1);
        this.siguiente++;


    }

}
