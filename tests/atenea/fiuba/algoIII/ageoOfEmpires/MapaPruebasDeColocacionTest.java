package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MapaPruebasDeColocacionTest {

    //Tamanio del Mapa
    int alto = 20;
    int ancho = 30;

    @Test
    public void testMapaSeCreaVacioSinIPosicionables() {
        Mapa mapa = new Mapa(alto, ancho);

        boolean estaVacio = mapa.estaVacio();

        assertEquals(true, estaVacio);
    }

    @Test
    public void testMapaColocaIPosicionableYDejaDeEstarVacioSiLaPosicionEstaDentroDelMapa(){
        Mapa mapa = new Mapa(alto,ancho);
        Posicion posicion = new Posicion(5,5);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(aldeano, posicion);

        assertEquals(false, mapa.estaVacio());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMapaLanzaExceptionSiSeColocaIPosicionableFueraDelMapa(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);
        Mapa mapa = new Mapa(alto,ancho);
        Posicion posicion = new Posicion(90,95);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(aldeano, posicion);
    }

    @Test
    public void testColocar2IPosicionablesEnLaMismaPosicionLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);
        Posicion posicion = new Posicion(5,15);
        IPosicionable aldeano = new Aldeano();
        IPosicionable arquero = new Arquero();

        mapa.colocarPosicionable(aldeano, posicion);
        mapa.colocarPosicionable(arquero, posicion);
    }

    @Test
    public void testColocar2IPosicionablesEnDiferentesPosicionesNoLanzaExcepsion(){
        Mapa mapa = new Mapa(alto, ancho);
        Posicion unaPosicion = new Posicion(5,15);
        Posicion otraPosicion = new Posicion(10, 10);

        IPosicionable aldeano = new Aldeano();
        IPosicionable armaDeAsedio = new ArmaDeAsedio();

        mapa.colocarPosicionable(aldeano, unaPosicion);
        mapa.colocarPosicionable(armaDeAsedio, otraPosicion);
    }

}
