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
    public void testColocarIPosicionableDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(5,5);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testColocarIPosicionableFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(90,95);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarIPosicionableEnUnaEsquinaDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(28,19);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarPlazaCentralFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new PlazaCentral();
        Posicion posicion = new PosicionCuadrado(50,50,51,50,50,49,51,49);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCuartelDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(5,5,6,5,5,4,6,4);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }


    @Test
    public void testColocarCuartelDejando2CasillerosOcupadosFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(29,10,30,10,29,9,30,9);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }


    @Test
    public void testColocarCuartelAlBordeDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(28,10,29,10,28,9,29,9);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(50,50,53,50,50,47,53,47);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(10,10,13,10,10,7,13,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloAlLimiteDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(26,10,29,10,26,7,29,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloDejandoUnaFilaFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(27,10,30,10,27,7,30,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

}
