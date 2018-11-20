package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void creaUnJugadorConRecursosBasicosTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        Assert.assertTrue(jugador.tieneOro(100));
    }

    @Test
    public void creaJugadorOrdenaATodosLosAldeanosARecolectarOroYOroAumentaTest(){
        Jugador jugador = new Jugador();
        Assert.assertFalse(jugador.tieneOro(160));
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneOro(160));

    }

    @Test
    public void creaJugadorOrdenaATodosLosAldeanosARecolectarOroDosVecesTest(){
        Jugador jugador = new Jugador();
        Assert.assertFalse(jugador.tieneOro(220));
        jugador.ordenarRecolectarOro();
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneOro(220));

    }

    @Test
    public void jugadorOrdenaConstruirPlazaCentralAUnAldeanoTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertFalse(jugador.tieneAldeanos(3));
        Assert.assertTrue(jugador.tieneAldeanos(2));
    }

    @Test
    public void jugadorOrdenaConstruirPlazaCentralAUnAldeanoTestYLosAldeanosRestantesRecolectan(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertFalse(jugador.tieneOro(120));
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneOro(120));
    }

    @Test
    public void jugadorOrdenaConstruirPlazaCentralA3AldeanosYARecolectarOroYNoRecolectarTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneAldeanos(0));
        Assert.assertFalse(jugador.tieneOro(120));
    }

    @Test (expected = AldeanosOcupadosException.class)
    public void jugadorOrdenaConstruirPlazaCentralA3AldeanosMasUnoLanzaExcepcionTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
    }

    @Test
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralAUnAldeanoAvanzaUnaVezYNoEstaTerminadoTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(), 1);
    }

    @Test
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralAUnAldeanoDosVecesYTerminaLaConstruccionTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(), 2);
    }

    @Test (expected = NoHayEdificiosEnConstruccionException.class)
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralAUnAldeanoSinHaberIniciadoNingunaConstruccionTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarAvanzarConstruccion();
    }

    @Test
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralAUnAldeanoDosVecesYDevuelveAldeanoRecolectorTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertTrue(jugador.tieneAldeanos(2));
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        //jugador.finDeLaConstruccion();
        Assert.assertEquals(jugador.tienePlazas(), 2);
        Assert.assertTrue(jugador.tieneAldeanos(3));
    }

    @Test
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralA3AldeanosDosVecesYTerminaTodasLasConstruccionesTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertTrue(jugador.tieneAldeanos(0));
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(), 4);
        Assert.assertTrue(jugador.tieneAldeanos(3));
    }

    @Test
    public void jugadorOrdenaAvanzarConstruccionDePlazaCentralA1AldeanosDosVecesYDevuelveAldeanoRecolectorYRecolectarTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertTrue(jugador.tieneAldeanos(2));
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        //jugador.finDeLaConstruccion();
        Assert.assertEquals(jugador.tienePlazas(), 2);
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarRecolectarOro();
        Assert.assertTrue(jugador.tieneOro(160));
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelAUnAldeanoTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        Assert.assertFalse(jugador.tieneAldeanos(3));
    }
    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelADosAldeanosTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionCuartel();
        Assert.assertFalse(jugador.tieneAldeanos(2));
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelA3AldeanosTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionCuartel();
        Assert.assertTrue(jugador.tieneAldeanos(0));
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelA3AldeanosYAvanzaSuConstruccionUnaVezSinTerminarTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertTrue(jugador.tieneAldeanos(0));
        Assert.assertEquals(jugador.tieneCuarteles(),0);
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelA1AldeanoYAvanzaSuConstruccion2VecesYTerminaTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        Assert.assertEquals(jugador.tieneCuarteles(),1);
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelYPlazaCentralA2AldeanosTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertFalse(jugador.tieneAldeanos(3));
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelYPlazaCentralAvanzaUnaVezEnTodosSinTermiarTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertFalse(jugador.tieneAldeanos(3));
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(),1);
        Assert.assertEquals(jugador.tieneCuarteles(),0);
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelYPlazaCentralAvanza2VecesEnTodosYTerminaTodoTest(){
        Jugador jugador = new Jugador();
        Assert.assertTrue(jugador.tieneAldeanos(3));
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertFalse(jugador.tieneAldeanos(3));
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(),2);
        Assert.assertEquals(jugador.tieneCuarteles(),1);
    }

    @Test
    public void jugadorOrdenaIniciarConstruccionDeCuatelAvanzaUnaVezEIniciaConstruccionDePlazaCentralTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        Assert.assertEquals(jugador.tienePlazas(),1);
        Assert.assertEquals(jugador.tieneCuarteles(),0);
    }

    @Test
    public void jugadorIniciaConstruccionDeCuatelAvanzaUnaVezEIniciaConstruccionDePlazaCentralYTerminaCuartelTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(),1);
        Assert.assertEquals(jugador.tieneCuarteles(),1);
    }

    @Test
    public void jugadorIniciaConstruccionDeCuatelAvanzaUnaVezEIniciaConstruccionDePlazaCentralTerminaCuartelAvanzaUnaVezTerminaPlazaTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        Assert.assertEquals(jugador.tienePlazas(),2);
        Assert.assertEquals(jugador.tieneCuarteles(),1);
    }

    @Test (expected = NoHayEdificiosEnConstruccionException.class)
    public void jugadorIniciaConstruccionDeCuatelAvanzaUnaVezEIniciaConstruccionDePlazaCentralTerminaCuartelAvanzaUnaVezTerminaPlazaAvanzaUnaVezMasTest(){
        Jugador jugador = new Jugador();
        jugador.ordenarIniciarConstruccionCuartel();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarIniciarConstruccionPlazaCentral();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
        jugador.ordenarAvanzarConstruccion();
    }
}
