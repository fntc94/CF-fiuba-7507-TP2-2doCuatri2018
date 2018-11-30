package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.juego.Turno;
import modelo.juego.Jugador;
import modelo.posicion.Mapa;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TurnoTest {
    private Mapa mapa = new Mapa(20,30);
    @Test
    public void permaneceEnElTurnoDeUnJugadorHastaQuePase(){
        Jugador jugadorJuan = new Jugador();
        Jugador jugadorPablo = new Jugador();

        List<Jugador> listaDeParticipantes = new ArrayList<>();
        listaDeParticipantes.add(jugadorJuan);
        listaDeParticipantes.add((jugadorPablo));

        Turno turno = new Turno(listaDeParticipantes);

        Jugador jugadorActual1 = turno.devolverJugadorActual();
        Jugador jugadorActual2 = turno.devolverJugadorActual();
        Assert.assertEquals(jugadorActual1, jugadorActual2);
    }

    @Test
    public void alPasarDeTurnoCambiaDeJugador(){
        Jugador jugadorJuan = new Jugador();
        Jugador jugadorPablo = new Jugador();

        List<Jugador> listaDeParticipantes = new ArrayList<>();
        listaDeParticipantes.add(jugadorJuan);
        listaDeParticipantes.add((jugadorPablo));

        Turno turno = new Turno(listaDeParticipantes);
        Jugador jugadorActual1 = turno.devolverJugadorActual();
        turno.cambiarDeTurno();
        Jugador jugadorActual2 = turno.devolverJugadorActual();
        Assert.assertNotEquals(jugadorActual1, jugadorActual2);

    }

    @Test
    public void seCreanDosJugadoresYEsElTurnoDelUltimoAlPasarSigueElPrimero(){
        Jugador jugadorJuan = new Jugador();
        Jugador jugadorPablo = new Jugador();

        List<Jugador> listaDeParticipantes = new ArrayList<>();
        listaDeParticipantes.add(jugadorJuan);
        listaDeParticipantes.add((jugadorPablo));

        Turno turno = new Turno(listaDeParticipantes);
        Jugador jugadorActual1 = turno.devolverJugadorActual();
        turno.cambiarDeTurno();
        turno.cambiarDeTurno();
        Jugador jugadorActual2 = turno.devolverJugadorActual();
        Assert.assertEquals(jugadorActual1, jugadorActual2);
    }
}
