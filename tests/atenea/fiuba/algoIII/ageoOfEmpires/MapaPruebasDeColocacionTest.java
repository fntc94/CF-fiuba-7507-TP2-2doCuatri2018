package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;

public class MapaPruebasDeColocacionTest {

    int alto = 20;
    int ancho = 30;

    private Mapa crearMapa(){
        return new Mapa(alto, ancho);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMapaSeCreaVacioSinIPosicionables() {
        Mapa mapa = new Mapa(alto, ancho);

        boolean estaVacio = mapa.estaVacio();

        assertEquals(true, estaVacio);
    }

    @Test
    public void testColocarUnidadDentroDelMapaNoLanzaException(){

        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(5,5);
        IPosicionable unidad = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion, unidad);
    }

    @Test
    public void testColocarUnidadFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(90,95);
        IPosicionable posicionable = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion, posicionable);
    }

    @Test
    public void testColocarUnidadEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(30,20); // Esquina superior derecha
        IPosicionable posicionable = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion, posicionable);
    }

    @Test
    public void testColocarUnidadEnElBordeExternoDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);
        Mapa mapa = new Mapa(alto,ancho);

        Posicion posicion = new PosicionDeUnCasillero(31,20); // Esquina superior derecha
        IPosicionable unidad = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion, unidad);
    }

    @Test
    public void testColocarEdificioDentroDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(10,20,11,19);

        mapa.colocarPosicionable(posicion, edificio);
    }

    @Test
    public void testColocarEdificioFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(35,50,36,49);

        mapa.colocarPosicionable(posicion, edificio);
    }

    @Test
    public void testColocarEdificioEnElBordeInternoDelMapaNoLanzaException(){
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(29,20,30,19);

        mapa.colocarPosicionable(posicion, edificio);
    }

    @Test
    public void testColocarEdificioEnElBordeExternoDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);
        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(31,20,32,19);

        mapa.colocarPosicionable(posicion, edificio);
    }

    @Test
    public void testColocarEdificioDejando2CasillerosFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(30,10,31,9);

        mapa.colocarPosicionable(posicion, edificio);
    }


    @Test
    public void testColocarEdificioDejandoUnaFilaFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable castillo = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(28,10,31,7);

        mapa.colocarPosicionable(posicion, castillo);
    }

    @Test
    public void testColocarEdificioDejandoDosFilasFueraDelMapaLanzaException(){
        thrown.expect(NoPuedeColocarPosicionablesFueraDelMapaException.class);

        Mapa mapa = new Mapa(alto,ancho);

        IPosicionable edificio = Mockito.mock(IPosicionable.class);
        Posicion posicion = new PosicionCuadrado(29,10,32,7);

        mapa.colocarPosicionable(posicion, edificio);
    }

}
