package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
    public void reparar_SinHaberReparadoPreviamentePasandoElEdificio_NoLanzaError(){

        Aldeano reparador = new Aldeano();

        int vidaMaximaDeCuartel = 450;
        int vidaInicialDeCuartel = 300;
        IEdificioReparable cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);

        reparador.reparar();
        Assert.assertTrue(true);
    }

    @Test
    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezALaPlazaCentral(){

        // Arrange

        Aldeano reparador = new Aldeano();

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
        Aldeano reparador = new Aldeano();

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

    @Test
    public void recolectarOro_CuandoNoEstaConstruyendoNiReparando_Devuelve20(){

        // Arrange
        Aldeano aldeano = new Aldeano();
        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }

    @Test
    public void recolectarOro_CuandoEstaReparando_DevuelveCero(){

        // Arrange
        Aldeano aldeano = new Aldeano();
        int oroEsperado = 0;

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);


        // Act
        aldeano.reparar(plazaCentral);
        int oroRecolectado = aldeano.recolectarOro();


        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void recolectarOro_LuegoDeTerminarDeReparar_Devuelve20(){

        // Arrange
        Aldeano aldeano = new Aldeano();
        int oroEsperado = 20;

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 400;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        // Act
        aldeano.reparar(plazaCentral);
        aldeano.reparar();
        aldeano.reparar();

        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void estaConstruyendo_LuegoDeIniciarConstruccionDeCuartel_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertTrue(esta_construyendo);
    }

    @Test
    public void estaConstruyendo_LuegoDeContinuarConstruyendoUnaVezUnCuartel_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruccion();
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertTrue(esta_construyendo);

    }

    @Test
    public void estaConstruyendo_LuegoDeContinuarConstruyendoDosVecesUnCuartel_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruccion();
        aldeano.continuarConstruccion();
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertFalse(esta_construyendo);

    }

    @Test
    public void estaConstruyendo_CuandoEstaRecolectando_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        // Act
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertFalse(esta_construyendo);

    }


    @Test
    public void inicicarConstruccionDeCuartel_AlTerminarLaConstruccion_SeEjecutaLaAccion(){

        // Arragnge
        ArrayList<Cuartel> cuarteles = new ArrayList<>() ;
        Aldeano aldeano = new Aldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel(cuartel -> cuarteles.add(cuartel));
        aldeano.continuarConstruccion();
        aldeano.continuarConstruccion();

        // Assert
        Assert.assertFalse(cuarteles.isEmpty());
    }

    @Test
    public void inicicarConstruccionDeCuartel_AntesDeTerminarLaConstruccion_NoSeEjecutaLaAccion(){

        // Arragnge
        ArrayList<Cuartel> cuarteles = new ArrayList<>() ;
        Aldeano aldeano = new Aldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel(cuartel -> cuarteles.add(cuartel));
        aldeano.continuarConstruccion();

        // Assert
        Assert.assertTrue(cuarteles.isEmpty());
    }

    @Test
    public void recolectarOro_LuegoDeTerminarDeConstruir_Devuelve20(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruccion();
        aldeano.continuarConstruccion();

        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }

    @Test
    public void recolectarOro_LuegoDeComenzarAConstruir_Devuelve0(){

        // Arrange
        Aldeano aldeano = new Aldeano();
        aldeano.iniciarConstruccionDeCuartel();

        int oroEsperado = 0;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }
}
