package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
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

    private IPosicionable mockPosicionable(Posicion posicion){
        IPosicionable posicionable = Mockito.mock(IPosicionable.class);
        Mockito.when(posicionable.getPosicion()).thenReturn(posicion);
        return posicionable;
    }

    @Test
    public void estaVacio_LuegoDeLaCreacion_DevuelveTrue() {

        // Arrange
        Mapa mapa = this.crearMapa();

        // Act
        boolean estaVacio = mapa.estaVacio();

        // Assert
        assertEquals(true, estaVacio);
    }

    @Test
    public void estaVacio_LuegoDeAgregarUnaUnidad_DevuelveFalse(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionDeUnCasillero(5,5);
        IPosicionable unidad = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(unidad);

        // Assert
        Assert.assertEquals(false, mapa.estaVacio());
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_UnidadFueraDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionDeUnCasillero(90,95);
        IPosicionable posicionable = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(posicionable);
    }

    @Test
    public void posicionar_UnidadEnElBordeInternoDelMapa_NoLanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        // Esquina superior derecha
        Posicion posicion = new PosicionDeUnCasillero(ancho, alto);
        IPosicionable posicionable = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(posicionable);
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_UnidadEnElBordeExternoDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        // Esquina superior derecha
        Posicion posicion = new PosicionDeUnCasillero(31,20);
        IPosicionable unidad = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(unidad);
    }

    @Test
    public void posicionar_EdificioDentroDelMapa_NoLanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(10,20,11,19);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_EdificioFueraDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(35,50,36,49);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

    @Test
    public void posicionar_EdificioEnElBordeInternoDelMapa_NoLanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(29,20,30,19);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_EdificioEnElBordeExternoDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(31,20,32,19);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_EdificioDejando2CasillerosFueraDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(30,10,31,9);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }


    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_EdificioDejandoUnaFilaFueraDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(28,10,31,7);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

    @Test(expected = NoPuedeColocarPosicionablesFueraDelMapaException.class)
    public void posicionar_EdificioDejandoDosFilasFueraDelMapa_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicion = new PosicionCuadrado(29,10,32,7);
        IPosicionable edificio = this.mockPosicionable(posicion);

        // Act
        mapa.posicionar(edificio);
    }

}
