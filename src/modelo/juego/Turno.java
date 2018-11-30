package modelo.juego;

import modelo.ListaCircular;

import java.util.List;
import java.util.Random;

public class Turno {

    private ListaCircular<Jugador> listaDeParticipantes;
    private Jugador jugadorActual;
    private int cantidadDeParticipantes;

    public Turno(List<Jugador> listaDeParticipantes){
        this.cantidadDeParticipantes = listaDeParticipantes.size();
        this.listaDeParticipantes = new ListaCircular<>();
        while (this.listaDeParticipantes.size()<listaDeParticipantes.size()){
            int randomPosicion = new Random().nextInt(cantidadDeParticipantes);
            Jugador jugador = listaDeParticipantes.get(randomPosicion);
            if (!this.listaDeParticipantes.contains(jugador)){
                this.listaDeParticipantes.addLast(jugador);
            }

        }
        jugadorActual = this.listaDeParticipantes.getFirst();
    }

    public Jugador devolverJugadorActual(){
        return jugadorActual;
    }

    public void cambiarDeTurno(){
        this.jugadorActual = this.listaDeParticipantes.getSiguiente();
    }


}
