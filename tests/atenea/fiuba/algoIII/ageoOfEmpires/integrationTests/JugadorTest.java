package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OroInsuficienteException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.juego.Jugador;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Mapa;
import org.junit.Test;

public class JugadorTest {


    @Test (expected = OroInsuficienteException.class)
    public void crearUnJugadorGastarOroYQueNoSeaSuficienteTest() {
        Mapa mapa = new Mapa(20,30);
        Jugador jugador = new Jugador(mapa);
        jugador.pagarCosto(120);
    }
}
