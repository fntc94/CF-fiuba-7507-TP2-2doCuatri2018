package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    private Aldeano crearAldeano(){
        return new AldeanoFabrica().crear();
    }

    @Test
    public void getVida_Devuelve50(){

        Aldeano aldeano = this.crearAldeano();
        assertEquals(50, aldeano.getVidaActual());
    }

    @Test
    public void reparar_SinHaberReparadoPreviamentePasandoElEdificio_NoLanzaError(){

        Aldeano reparador = this.crearAldeano();

        int vidaMaximaDeCuartel = 450;
        int vidaInicialDeCuartel = 300;
        IEdificioReparable cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);

        reparador.continuarReparacion();
        Assert.assertTrue(true);
    }

    @Test
    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezALaPlazaCentral(){

        // Arrange

        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        aldeano.iniciarReparacion(cuartel);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);

    }

    @Test
    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezAlCuartel(){

        // Arrange
        Aldeano reparador = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        int vidaMaximaDeCuartel = 250;
        int vidaInicialDeCuartel = 90;
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel);
        int vidaFinalEsperadaDeCuartelLuegoDeReparacion = 140;

        // Act
        reparador.iniciarReparacion(plazaCentral);
        reparador.iniciarReparacion(cuartel);
        int vidaFinalDeCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDeCuartelLuegoDeReparacion, vidaFinalDeCuartel);

    }

    @Test
    public void recolectarOro_CuandoNoEstaConstruyendoNiReparando_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }

    @Test
    public void recolectarOro_CuandoEstaReparando_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 0;

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);


        // Act
        aldeano.iniciarReparacion(plazaCentral);
        int oroRecolectado = aldeano.recolectarOro();


        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void recolectarOro_LuegoDeTerminarDeReparar_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 20;

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 400;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        aldeano.continuarReparacion();
        aldeano.continuarReparacion();

        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void estaConstruyendo_LuegoDeIniciarConstruccionDeCuartel_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertTrue(esta_construyendo);
    }

    @Test
    public void estaConstruyendo_LuegoDeContinuarConstruyendoUnaVezUnCuartel_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

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
        Aldeano aldeano = this.crearAldeano();

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
        Aldeano aldeano = this.crearAldeano();

        // Act
        Boolean esta_construyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertFalse(esta_construyendo);

    }


    @Test
    public void inicicarConstruccionDeCuartel_AlTerminarLaConstruccion_SeEjecutaLaAccion(){

        // Arragnge
        ArrayList<Cuartel> cuarteles = new ArrayList<>() ;
        Aldeano aldeano = this.crearAldeano();

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
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel(cuartel -> cuarteles.add(cuartel));
        aldeano.continuarConstruccion();

        // Assert
        Assert.assertTrue(cuarteles.isEmpty());
    }

    @Test
    public void recolectarOro_LuegoDeTerminarDeConstruir_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

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
        Aldeano aldeano = this.crearAldeano();
        aldeano.iniciarConstruccionDeCuartel();

        int oroEsperado = 0;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }
}
