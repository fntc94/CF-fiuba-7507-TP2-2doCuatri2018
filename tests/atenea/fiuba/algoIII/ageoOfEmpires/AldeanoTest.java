package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    @Test
    public void getVida_Devuelve50(){

        Aldeano aldeano = new Aldeano();
        assertEquals(50, aldeano.getVida());
    }

    @Test
    public void getCosto_Devuelve25(){

        Aldeano aldeano = new Aldeano();
        assertEquals(25, aldeano.getCosto());
    }

    @Test
    public void reparar_PlazaCentral_PlazaCentralRecupera25DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }

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
    public void reparar_Castillo_CastilloRecupera15DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo);
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 575;

        // Act
        aldeano.reparar(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_PlazaCentralDosVecesConElMismoAldeano_PlazaCentralRecupera50DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 350;

        // Act
        aldeano.reparar(plazaCentral);
        aldeano.reparar();
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);

    }

    @Test
    public void reparar_CuartelDosVecesConElMismoAldeano_CuartelRecupera100DeVida(){

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
    public void reparar_CastilloDosVecesConElMismoAldeano_CastilloRecupera30DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo);
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 590;

        // Act
        aldeano.reparar(castillo);
        aldeano.reparar();
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_PlazaCentralUnaVez_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 440;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
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
    public void reparar_CastilloUnaVez_VidaDeCastilloNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 795;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo);
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 800;

        // Act
        aldeano.reparar(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_PlazaCentralConMaximoDeVida_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 450;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
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
    public void reparar_CastilloConMaximoDeVida_VidaDeCastilloNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 800;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo);
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 800;

        // Act
        aldeano.reparar(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_PlazaCentralConDosAldeanosDistintos_PlazaCentralRecuperaSolo25DeVida(){

        // Arrange
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano1.reparar(plazaCentral);
        aldeano2.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
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

    @Test
    public void reparar_CastilloConDosAldeanosDistintos_CastilloRecuperaSolo15DeVida(){

        // Arrange
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo);
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 575;

        // Act
        aldeano1.reparar(castillo);
        aldeano2.reparar(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_SinHaberReparadoPreviamentePasandoElEdificio_NoLanzaError(){

        IReparadorDeEdificios reparador = new Aldeano();

        int vidaMaximaDeCuartel = 450;
        int vidaInicialDeCuartel = 300;
        IEdificioReparable cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);

        reparador.reparar();
        Assert.assertTrue(true);
    }

    @Test
    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezALaPlazaCentral(){

        // Arrange

        IReparadorDeEdificios reparador = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);

        // Act
        reparador.reparar(plazaCentral);
        reparador.reparar(cuartel);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);

    }

    @Test
    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezAlCuartel(){

        // Arrange

        IReparadorDeEdificios reparador = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDeCuartelLuegoDeReparacion = 140;

        // Act
        reparador.reparar(plazaCentral);
        reparador.reparar(cuartel);
        int vidaFinalDeCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDeCuartelLuegoDeReparacion, vidaFinalDeCuartel);

    }

}