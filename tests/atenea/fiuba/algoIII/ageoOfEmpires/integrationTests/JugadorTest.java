package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OroInsuficienteException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego.Jugador;
import org.junit.Test;

public class JugadorTest {


    @Test (expected = OroInsuficienteException.class)
    public void crearUnJugadorGastarOroYQueNoSeaSuficienteTest() {
        Jugador jugador = new Jugador();
        jugador.pagarCosto(120);
    }
}
