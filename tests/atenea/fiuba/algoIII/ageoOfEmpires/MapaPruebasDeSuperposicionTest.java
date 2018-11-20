package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;
import org.mockito.Mockito;

public class MapaPruebasDeSuperposicionTest {

    public int alto = 20;
    public int ancho = 30;

    private Mapa crearMapa(){
        return new Mapa(alto, ancho);
    }

    private IPosicionable crearMock(Posicion posicion){
        IPosicionable posicionable = Mockito.mock(IPosicionable.class);
        Mockito.when(posicionable.getPosicion()).thenReturn(posicion);
        return posicionable;
    }

    @Test(expected = NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void posicionar_UnidadEnPosicionOcupadaPorEdificio_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionUnidad = new PosicionDeUnCasillero(6,5);
        Posicion posicionEdificio = new PosicionCuadrado(6,5,7,4);

        IPosicionable unidad = this.crearMock(posicionUnidad);
        IPosicionable edificio = this.crearMock(posicionEdificio);

        // Act
        mapa.posicionar(edificio);
        mapa.posicionar(unidad);

    }

    @Test
    public void posicionar_UnidadAlLadoDeAEdificio_NoLanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionUnidad = new PosicionDeUnCasillero(5,5);
        Posicion posicionEdificio = new PosicionCuadrado(6,5,7,4);

        IPosicionable unidad = this.crearMock(posicionUnidad);
        IPosicionable edificio = this.crearMock(posicionEdificio);

        // Act
        mapa.posicionar(edificio);
        mapa.posicionar(unidad);
    }

    @Test(expected = NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void posicionar_DosUnidadesEnLaMismaPosicion_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionUnidad1 = new PosicionDeUnCasillero(5,15);
        IPosicionable unidad1 = this.crearMock(posicionUnidad1);

        Posicion posicionUnidad2 = new PosicionDeUnCasillero(5,15);
        IPosicionable unidad2 = this.crearMock(posicionUnidad2);

        // Act
        mapa.posicionar(unidad1);
        mapa.posicionar(unidad2);
    }

    @Test
    public void posicionar_UnaUnidadALadoDeOtra_NoLanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionUnidad1 = new PosicionDeUnCasillero(4,15);
        Posicion posicionUnidad2 = new PosicionDeUnCasillero(5,15);

        IPosicionable aldeano = this.crearMock(posicionUnidad1);
        IPosicionable arquero = this.crearMock(posicionUnidad2);

        // Act
        mapa.posicionar(aldeano);
        mapa.posicionar(arquero);
    }

    @Test(expected = NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void posicionar_DosEdificiosQueSeSuperponen_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionEdificio1 = new PosicionCuadrado(2,16,3,15);
        Posicion posicionEdificio2 = new PosicionCuadrado(3,16,6,12);

        IPosicionable edificio1 = this.crearMock(posicionEdificio1);
        IPosicionable edificio2 = this.crearMock(posicionEdificio2);

        // Act
        mapa.posicionar(edificio2);
        mapa.posicionar(edificio1);
    }

    @Test
    public void posicionar_UnEdificioAlLadoDeOtro_NoLanzaException() {

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionEdificio1 = new PosicionCuadrado(5, 15, 8, 12);
        Posicion posicionEdificio2 = new PosicionCuadrado(3, 14, 4, 12);

        IPosicionable edificio1 = this.crearMock(posicionEdificio1);
        IPosicionable edificio2 = this.crearMock(posicionEdificio2);

        // Act
        mapa.posicionar(edificio1);
        mapa.posicionar(edificio2);
    }

    @Test(expected =  NoPuedeColocar2IPosicionablesEnLaMismaPosicionException.class)
    public void posicionar_DosEdificiosDistintosEnLaMismaPosicion_LanzaException(){

        // Arrange
        Mapa mapa = this.crearMapa();

        Posicion posicionEdificio1 = new PosicionCuadrado(5,7,6,6);
        Posicion posicionEdificio2 = new PosicionCuadrado(5,7,6,6);

        IPosicionable edificio1 = this.crearMock(posicionEdificio1);
        IPosicionable edificio2 = this.crearMock(posicionEdificio2);

        // Act
        mapa.posicionar(edificio1);
        mapa.posicionar(edificio2);
    }

}
