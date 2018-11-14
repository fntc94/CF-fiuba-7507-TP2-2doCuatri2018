package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MapaPruebasDeColocacionTest {

    int alto = 20;
    int ancho = 30;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMapaSeCreaVacioSinIPosicionables() {
        Mapa mapa = new Mapa(alto, ancho);

        boolean estaVacio = mapa.estaVacio();

        assertEquals(true, estaVacio);
    }

    //Las pruebas del aldeano son validas para cualquier unidad ya que estas
    // (en este caso) ocupan todas 1 casillero
    @Test
    public void testColocarAldeanoDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(5,5);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarAldeanoFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(90,95);
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarAldeanoEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(30,20); // Esquina superior derecha
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarAldeanoEnElBordeExternoDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(31,20); // Esquina superior derecha
        IPosicionable aldeano = new Aldeano();

        mapa.colocarPosicionable(posicion, aldeano);
    }

    @Test
    public void testColocarPlazaCentralDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new PlazaCentral();
        Posicion posicion = new PosicionCuadrado(10,20,11,19);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarPlazaCentralFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new PlazaCentral();
        Posicion posicion = new PosicionCuadrado(35,50,36,49);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarPlazaCentralEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new PlazaCentral();
        Posicion posicion = new PosicionCuadrado(29,20,30,19);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarPlazaCentralEnElBordeExternoDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new PlazaCentral();
        Posicion posicion = new PosicionCuadrado(31,20,32,19);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCuartelDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(5,5,6,4);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCuartelFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(50,20,51,19);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCuartelDejando2CasillerosFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(30,10,31,9);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }


    @Test
    public void testColocarCuartelEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Cuartel();
        Posicion posicion = new PosicionCuadrado(29,10,30,9);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(50,50,53,47);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(10,10,13,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(27,20,30,17);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloDejandoUnaFilaFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(28,10,31,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloDejandoDosFilasFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(29,10,32,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

    @Test
    public void testColocarCastilloEnElBordeExternoDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable plazaCentral = new Castillo();
        Posicion posicion = new PosicionCuadrado(31,10,34,7);

        mapa.colocarPosicionable(posicion, plazaCentral);
    }

}
