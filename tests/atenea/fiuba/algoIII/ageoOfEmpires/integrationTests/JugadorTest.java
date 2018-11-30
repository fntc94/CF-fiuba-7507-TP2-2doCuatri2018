package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import modelo.edificios.Castillo;
import modelo.edificios.EdificiosFabrica;
import modelo.edificios.PlazaCentral;
import modelo.excepciones.EdificioNoEsPropioException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.UnidadNoEsPropiaException;
import modelo.juego.Jugador;
import modelo.posicion.Mapa;
import modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class JugadorTest {


    @Test (expected = OroInsuficienteException.class)
    public void crearUnJugadorCon100DeOroGastarOroYQueNoSeaSuficienteTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.pagarCosto(120);
    }

    @Test
    public void crearUnJugadorYQueOrdeneASus3AldeanosAARecolectarYDevuelve160Test() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.ordenarRecolectarOro();
        jugador.pagarCosto(160);
    }

    @Test
    public void jugadorCreadoConCastilloEnPieTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        Assert.assertFalse(jugador.castilloDestruido());
    }

    @Test (expected = UnidadNoEsPropiaException.class)
    public void AJugadorCreadoPreguntaSiAldeanoLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.esMio(new UnidadesFabrica().crearAldeano());
    }

    @Test (expected = UnidadNoEsPropiaException.class)
    public void AJugadorCreadoPreguntaSiAqueroLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.esMio(new UnidadesFabrica().crearArquero());
    }

    @Test (expected = EdificioNoEsPropioException.class)
    public void AJugadorCreadoPreguntaSiCastilloLePerteneceLanzaExcepcionTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.esMio(new EdificiosFabrica().crearCastillo());
    }

    @Test (expected = OroInsuficienteException.class)
    public void jugadorCreadoAgregaAldeanoYNoRecolectaOroTest() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.agregar(new UnidadesFabrica().crearAldeano());
        jugador.pagarCosto(180);
    }

    @Test
    public void jugadorCreadoAgregaAldeanoYRecolectaOroDevuelve80Test() {
        Castillo castillo = new EdificiosFabrica().crearCastillo();
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        jugador.agregar(new UnidadesFabrica().crearAldeano());
        jugador.ordenarRecolectarOro();
        jugador.pagarCosto(180);
    }

    @Test
    public void jugadorCreadoPierdeCastilloTest() {
        Castillo castillo = Mockito.mock(Castillo.class);
        Mockito.when(castillo.sigueEnPie()).thenReturn(false);
        PlazaCentral plazaCentral = new EdificiosFabrica().crearPlazaCentral();
        Jugador jugador = new Jugador("Pablo", castillo, plazaCentral);
        Assert.assertTrue(jugador.castilloDestruido());
    }
}
