package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class MapaPruebasDeSuperposicionTest {

    public int alto = 20;
    public int ancho = 30;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testColocarUnidadEnCasillerosOcupadosPorEdificioLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(20,30);

        Posicion posAldeano = new PosicionDeUnCasillero(6,5);
        Posicion posPlazaCentral = new PosicionCuadrado(6,5,7,4);

        IPosicionable unidad = Mockito.mock(IPosicionable.class);
        IPosicionable edificio = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posAldeano, unidad);
        mapa.colocarPosicionable(posPlazaCentral, edificio);
    }

    @Test
    public void testColocarUnidadContiguoAEdificioNoLanzaException(){
        Mapa mapa = new Mapa(20,30);

        Posicion posAldeano = new PosicionDeUnCasillero(5,5);
        Posicion posPlazaCentral = new PosicionCuadrado(6,5,7,4);

        IPosicionable unidad = Mockito.mock(IPosicionable.class);
        IPosicionable edificio = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posAldeano, unidad);
        mapa.colocarPosicionable(posPlazaCentral, edificio);
    }

    @Test
    public void testColocarUnAldeanoYUnArqueroEnLaMismaPosicionLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionDeUnCasillero(5,15);
        Posicion posicion2 = new PosicionDeUnCasillero(5,15);

        IPosicionable aldeano = Mockito.mock(IPosicionable.class);
        IPosicionable arquero = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, arquero);
    }

    @Test
    public void testColocarAldeanoContiguoAUnArqueroNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionDeUnCasillero(4,15);
        Posicion posicion2 = new PosicionDeUnCasillero(5,15);

        IPosicionable aldeano = Mockito.mock(IPosicionable.class);
        IPosicionable arquero = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, arquero);
    }

    @Test
    public void testColocarAldeanoYArmaDeAsedioEnDiferentesPosicionesNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);

        Posicion unaPosicion = new PosicionDeUnCasillero(5,15);
        Posicion otraPosicion = new PosicionDeUnCasillero(10, 10);

        IPosicionable aldeano = Mockito.mock(IPosicionable.class);
        IPosicionable armaDeAsedio = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(unaPosicion, aldeano);
        mapa.colocarPosicionable(otraPosicion, armaDeAsedio);
    }

    @Test
    public void testColocarPlazaCentralEnCasillerosOcupadosPorCastilloLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posPlazaCentral = new PosicionCuadrado(2,16,3,15);
        Posicion posCastillo = new PosicionCuadrado(3,16,6,12);

        IPosicionable plazaCentral = new PlazaCentral(10,10);
        IPosicionable castillo = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posCastillo, castillo);
        mapa.colocarPosicionable(posPlazaCentral, plazaCentral);
    }

    @Test
    public void testColocaraPlazaCentralContiguoACastilloNoLanzaException() {
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posCastillo = new PosicionCuadrado(5, 15, 8, 12);
        Posicion posPlazaCentral = new PosicionCuadrado(3, 14, 4, 12);

        IPosicionable castillo = Mockito.mock(IPosicionable.class);
        IPosicionable plazaCentral = Mockito.mock(IPosicionable.class);

        mapa.colocarPosicionable(posCastillo, castillo);
        mapa.colocarPosicionable(posPlazaCentral, plazaCentral);
    }

    @Test
    public void testSuperposicionEntrePlazaCentralYCuartelLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        IPosicionable plazaCentral = new PlazaCentral(10,10);
        IPosicionable cuartel = Mockito.mock(IPosicionable.class);

        Posicion posPlazaCentral = new PosicionCuadrado(5,7,6,6);
        Posicion posCuartel = new PosicionCuadrado(5,7,6,6);

        mapa.colocarPosicionable(posPlazaCentral, plazaCentral);
        mapa.colocarPosicionable(posCuartel, cuartel);
    }

    @Test
    public void testColocarPlazaCentralContiguaACuartelNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);

        IPosicionable plazaCentral = new PlazaCentral(10,10);
        IPosicionable cuartel = Mockito.mock(IPosicionable.class);

        Posicion posPlazaCentral = new PosicionCuadrado(5,7,6,6);
        Posicion posCuartel = new PosicionCuadrado(5,5,6,6);

        mapa.colocarPosicionable(posPlazaCentral, plazaCentral);
        mapa.colocarPosicionable(posCuartel, cuartel);
    }

}
