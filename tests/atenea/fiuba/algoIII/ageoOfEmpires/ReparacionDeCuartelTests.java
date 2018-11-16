package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ReparacionDeCuartelTests {

    private Aldeano crearAldeano(){
        return new UnidadesFabrica().crearAldeano();
    }

    @Test
    public void reparar_Cuartel_CuartelRecupera50DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel, new UnidadesFabrica());
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 140;

        // Act
        aldeano.iniciarReparacion(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);


    }

    @Test
    public void reparar_CuartelUnaVez_VidaDeCuartelNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 230;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, new UnidadesFabrica());
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 250;

        // Act
        aldeano.iniciarReparacion(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);
    }

    @Test
    public void reparar_CuartelConMaximoDeVida_VidaDeCuartelNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, new UnidadesFabrica());
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 250;

        // Act
        aldeano.iniciarReparacion(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);
    }

    @Test
    public void repararCuartel_DosVecesConElMismoAldeano_CuartelRecupera100DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel,new UnidadesFabrica());
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 190;

        // Act
        aldeano.iniciarReparacion(cuartel);
        aldeano.continuarReparando();
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);


    }

    @Test
    public void reparar_CuartelConDosAldeanosDistintos_CuartelRecuperaSolo50DeVida(){

        // Arrange
        Aldeano aldeano1 = this.crearAldeano();
        Aldeano aldeano2 = this.crearAldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel, new UnidadesFabrica());
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 140;

        // Act
        aldeano1.iniciarReparacion(cuartel);
        aldeano2.iniciarReparacion(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);

    }

}
