package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaPruebasDeSuperposicion {

    /*
    * Aca se prueban superposiciones entre IPosicionables dentro del mapa.
    * Esto es, si quiere colocar un IPosicionable en una posicion ya ocupada
    * por otro IPosicionable no deberia permitirse.
    * */

    public int alto = 20;
    public int ancho = 30;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Posicion posicion2 = new PosicionDe4x4(3,16);

        IPosicionable aldeano = new Aldeano();
        IPosicionable castillo = new Castillo();


        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, castillo);
    }

    @Test
    public void testColocarAldeanoYCastilloEnDiferentesPosicionesNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);
        // coloco el aldeano contiguo al castillo
        Posicion posicion1 = new PosicionDeUnCasillero(7,16);
        // como ocupa 4 casilleros,poner aldeano en x = 3, 4, 5 y 6 lanzarian exception por superposicion
        Posicion posicion2 = new PosicionDe4x4(3,16);

        IPosicionable aldeano = new Aldeano();
        IPosicionable castillo = new Castillo();


        mapa.colocarPosicionable(posicion1, aldeano);
        mapa.colocarPosicionable(posicion2, castillo);
    }

    @Test
    public void testSuperposicionEntreUnCastilloYUnaPlazaCentralLanzaException(){
        thrown.expect(NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class);
        Mapa mapa = new Mapa(alto, ancho);

        /*Ocupadas por el castillo
         * En x:
         * 5, 6, 7, 8
         * En y:
         * 15, 14, 13, 12
         * */
        /*Ocupadas por la plaza
         * En x:
         * 3, 4
         * En y:
         * 16, 15
         * */
        Posicion posicion1 = new PosicionDe4x4(5,15);
        Posicion posicion2 = new PosicionDe2x2(5,16);

        IPosicionable castillo = new Castillo();
        IPosicionable plazaCentral = new PlazaCentral();


        mapa.colocarPosicionable(posicion1, castillo);
        mapa.colocarPosicionable(posicion2, plazaCentral);
    }

    @Test
    public void testColocarUnaPlazaCentralContiguoAUnCastilloNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);
        Posicion posicion1 = new PosicionDe4x4(5,15);
        Posicion posicion2 = new PosicionDe2x2(5,17);

        IPosicionable castillo = new Castillo();
        IPosicionable plazaCentral = new PlazaCentral();


        mapa.colocarPosicionable(posicion1, castillo);
        mapa.colocarPosicionable(posicion2, plazaCentral);
    }

}
