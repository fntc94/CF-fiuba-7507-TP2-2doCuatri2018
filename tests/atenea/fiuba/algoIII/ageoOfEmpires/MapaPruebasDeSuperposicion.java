package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaPruebasDeSuperposicion {
    
    public int alto = 20;
    public int ancho = 30;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testColocarAldeanoEnCasillerosOcupadosPorPlazaCentralLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(20,30);

        Posicion pos1 = new PosicionDeUnCasillero(6,5);
        Posicion pos2 = new PosicionCuadrado(6,5,7,5,6,4,7,4);

        IPosicionable aldeano = new Aldeano();
        IPosicionable plazaCentral = new PlazaCentral();

        mapa.colocarPosicionable(pos1, aldeano);
        mapa.colocarPosicionable(pos2, plazaCentral);
    }

    @Test
    public void testColocar2IPosicionablesEnLaMismaPosicionLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionDeUnCasillero(5,15);
        Posicion posicion2 = new PosicionDeUnCasillero(5,15);

        IPosicionable aldeano = new Aldeano();
        IPosicionable arquero = new Arquero();

        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, arquero);
    }

    @Test
    public void testColocar2IPosicionablesEnDiferentesPosicionesNoLanzaExcepsion(){
        Mapa mapa = new Mapa(alto, ancho);

        Posicion unaPosicion = new PosicionDeUnCasillero(5,15);
        Posicion otraPosicion = new PosicionDeUnCasillero(10, 10);

        IPosicionable aldeano = new Aldeano();
        IPosicionable armaDeAsedio = new ArmaDeAsedio();

        mapa.colocarPosicionable(unaPosicion, aldeano);
        mapa.colocarPosicionable(otraPosicion, armaDeAsedio);
    }

    @Test
    public void testSuperposicionEntreCastilloYAldeanoLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionDeUnCasillero(5,15);
        Posicion posicion2 = new PosicionCuadrado(3,16,6,16,3,13,6,13);

        IPosicionable aldeano = new Aldeano();
        IPosicionable castillo = new Castillo();


        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, castillo);
    }

    @Test
    public void testColocarAldeanoContiguoAUnCastilloNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionDeUnCasillero(7,16);
        Posicion posicion2 = new PosicionCuadrado(3,16,6,16,3,13,6,13);

        IPosicionable aldeano = new Aldeano();
        IPosicionable castillo = new Castillo();


        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, castillo);
    }

    @Test
    public void testSuperposicionEntreUnCastilloYUnaPlazaCentralLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        Posicion posicion1 = new PosicionCuadrado(5,15,8,15,5,12,8,12);
        Posicion posicion2 = new PosicionCuadrado(5,16,6,16,5,15,6,15);

        IPosicionable castillo = new Castillo();
        IPosicionable plazaCentral = new PlazaCentral();


        mapa.colocarPosicionable(posicion1, castillo);
        mapa.colocarPosicionable(posicion2, plazaCentral);
    }

    @Test
    public void testColocarUnaPlazaCentralContiguoAUnCastilloNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);
        Posicion posicion1 = new PosicionCuadrado(5,15,8,15,5,12,8,12);
        Posicion posicion2 = new PosicionCuadrado(5,17,6,17,5,16,6,16);

        IPosicionable castillo = new Castillo();
        IPosicionable plazaCentral = new PlazaCentral();


        mapa.colocarPosicionable(posicion1, castillo);
        mapa.colocarPosicionable(posicion2, plazaCentral);
    }
}
