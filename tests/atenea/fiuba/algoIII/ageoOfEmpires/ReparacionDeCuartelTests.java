package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ReparacionDeCuartelTests {

    @Test
    public void reparar_Cuartel_CuartelRecupera50DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 140;

        // Act
        aldeano.reparar(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);


    }

    @Test
    public void reparar_CuartelUnaVez_VidaDeCuartelNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 230;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 250;

        // Act
        aldeano.reparar(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);
    }

    @Test
    public void reparar_CuartelConMaximoDeVida_VidaDeCuartelNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 250;

        // Act
        aldeano.reparar(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);
    }

    @Test
    public void repararCuartel_DosVecesConElMismoAldeano_CuartelRecupera100DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 190;

        // Act
        aldeano.reparar(cuartel);
        aldeano.reparar();
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);


    }

    @Test
    public void reparar_CuartelConDosAldeanosDistintos_CuartelRecuperaSolo50DeVida(){

        // Arrange
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDelCuartelLuegoDeReparacion = 140;

        // Act
        aldeano1.reparar(cuartel);
        aldeano2.reparar(cuartel);
        int vidaFinalDelCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCuartelLuegoDeReparacion, vidaFinalDelCuartel);

    }

}
