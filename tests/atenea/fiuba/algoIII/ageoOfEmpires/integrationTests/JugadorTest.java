package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Jugador;
import modelo.posicion.Mapa;
import org.junit.Test;

public class JugadorTest {


    @Test (expected = OroInsuficienteException.class)
    public void crearUnJugadorGastarOroYQueNoSeaSuficienteTest() {
        Mapa mapa = new Mapa(20,30);
        Jugador jugador = new Jugador();
        jugador.pagarCosto(120);
    }
}
