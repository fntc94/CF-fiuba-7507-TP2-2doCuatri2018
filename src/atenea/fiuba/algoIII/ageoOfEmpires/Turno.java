package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.List;

public class Turno {

    private List<Jugador> listaDeParticipantes;
    private Jugador jugadorActual;
    private int posicionInicial;

    public Turno(List<Jugador> listaDeParticipantes){
        this.posicionInicial = 0;
        this.listaDeParticipantes = listaDeParticipantes;
        this.jugadorActual = listaDeParticipantes.get(this.posicionInicial);

    }

    public Jugador devolverJugadorActual(){
        return jugadorActual;
    }

    public void cambiarDeTurno(){
        this.listaDeParticipantes.add(jugadorActual);
        this.jugadorActual = listaDeParticipantes.get(this.posicionInicial+1);
        this.posicionInicial++;
    }

    public void juegoTurno(Jugador jugadorActual){


    }

}
