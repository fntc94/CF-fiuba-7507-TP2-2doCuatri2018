package modelo.juego;

import modelo.ListaCircular;

import java.util.List;
import java.util.Random;

public class Turno {

    private ListaCircular<Jugador> listaDeParticipantes;
    private Jugador jugadorActual;
    private int cantidadDeParticipantes;

    public Turno(List<Jugador> listaDeParticipantes){
        this.listaDeParticipantes = generarListaDeOrdenAleatorio(listaDeParticipantes);
        jugadorActual = this.listaDeParticipantes.getFirst();
    }

    public Jugador devolverJugadorActual(){
        return jugadorActual;
    }

    public void cambiarDeTurno(){
        this.jugadorActual = this.listaDeParticipantes.getSiguiente();
    }


    private ListaCircular<Jugador> generarListaDeOrdenAleatorio(List<Jugador> listaOriginal) {
        this.cantidadDeParticipantes = listaOriginal.size();
        ListaCircular listaAleatoria = new ListaCircular<>();
        while (listaAleatoria.size() < listaOriginal.size()) {
            int randomPosicion = new Random().nextInt(cantidadDeParticipantes);
            Jugador jugador = listaOriginal.get(randomPosicion);
            if (!listaAleatoria.contains(jugador)) {
                listaAleatoria.addLast(jugador);
            }
        }
        return listaAleatoria;
    }
}
