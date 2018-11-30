package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import modelo.edificios.Castillo;
import modelo.edificios.EdificiosFabrica;
import modelo.edificios.PlazaCentral;
import modelo.excepciones.EdificioNoEsPropioException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.UnidadNoEsPropiaException;
import modelo.juego.Jugador;
import modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class JugadorTest {


    @Test (expected = OroInsuficienteException.class)
    public void crearUnJugadorCon100DeOroGastarOroYQueNoSeaSuficienteTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.pagarCosto(120);
    }

   /* @Test
    public void crearUnJugadorYQueOrdeneASus3AldeanosAARecolectarYDevuelve160Test() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.trabajar();
        jugador.pagarCosto(160);
    }*/

    @Test
    public void jugadorCreadoConCastilloEnPieTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        Assert.assertFalse(jugador.castilloDestruido());
    }

    @Test (expected = UnidadNoEsPropiaException.class)
    public void AJugadorCreadoPreguntaSiAldeanoLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.esMio(new UnidadesFabrica().crearAldeano());
    }

    @Test (expected = UnidadNoEsPropiaException.class)
    public void AJugadorCreadoPreguntaSiAqueroLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.esMio(new UnidadesFabrica().crearArquero());
    }

    @Test (expected = EdificioNoEsPropioException.class)
    public void AJugadorCreadoPreguntaSiCastilloLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.esMio(new EdificiosFabrica().crearCastillo());
    }

    @Test (expected = OroInsuficienteException.class)
    public void jugadorCreadoAgregaAldeanoYNoRecolectaOroTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.agregar(new UnidadesFabrica().crearAldeano());
        jugador.pagarCosto(180);
    }

    /*@Test
    public void jugadorCreadoAgregaAldeanoYRecolectaOroDevuelve80Test() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        Jugador jugador = new Jugador("Pablo", castillo);
        jugador.agregar(new UnidadesFabrica().crearAldeano());
        jugador.trabajar();
        jugador.pagarCosto(180);
    }*/

    @Test
    public void jugadorCreadoPierdeCastilloTest() {
        Castillo castillo = Mockito.mock(Castillo.class);
        Mockito.when(castillo.sigueEnPie()).thenReturn(false);
        Jugador jugador = new Jugador("Pablo", castillo);
        Assert.assertTrue(jugador.castilloDestruido());
    }
}
