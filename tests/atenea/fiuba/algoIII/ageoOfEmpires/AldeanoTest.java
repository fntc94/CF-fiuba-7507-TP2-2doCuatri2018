package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    private Aldeano crearAldeano(){
        return new UnidadesFabrica().crearAldeano();
    }

    @Test
    public void getVida_Devuelve50(){

        Aldeano aldeano = this.crearAldeano();
        assertEquals(50, aldeano.getVidaActual());
    }

    @Test
    public void estaRecolectandoOro_LuegoDeLaCreacion_DevuelveTrue(){

        // Arrange
        IRecolectorOro aldeano = this.crearAldeano();

        // Act
        boolean estaRecolectandoOro = aldeano.estaRecolectandoOro();

        // Assert
        Assert.assertEquals(true, estaRecolectandoOro);

    }

    @Test
    public void estaConstruyendo_LuegoDeLaCreacion_DevuelveFalse(){

        // Arrange
        IConstructor aldeano = this.crearAldeano();

        // Act
        boolean estaConstruyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertEquals(false, estaConstruyendo);

    }

    @Test
    public void estaReparando_LuegoDeLaCreacion_DevuelveFalse(){

        // Arrange
        IReparador aldeano = this.crearAldeano();

        // Act
        boolean estaReparando = aldeano.estaReparando();

        // Assert
        Assert.assertEquals(false, estaReparando);

    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void continuarReparacion_CuandoEstaRecolectando_LanzaExcepcion(){

        // Arrange
        IReparador aldeano = this.crearAldeano();

        // Act
        aldeano.continuarReparando();
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void continuarConstruyendo_CuandoEstaRecolectando_LanzaExcepcion(){

        // Arrange
        IConstructor aldeano = this.crearAldeano();

        // Act
        aldeano.continuarConstruyendo();
    }

    @Test
    public void recolectarOro_LuegoDeLaCreacion_Devuelve20(){

        // Arrange
        IRecolectorOro aldeano = this.crearAldeano();
        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }

    @Test
    public void estaConstruyendo_LuegoDeIniciarConstruccion_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        boolean estaConstruyendo = aldeano.estaConstruyendo();

        // Asert
        Assert.assertEquals(true, estaConstruyendo);
    }

    @Test
    public void estaRecolectando_LuegoDeIniciarConstruccion_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        boolean estaRecolectando = aldeano.estaRecolectandoOro();

        // Asert
        Assert.assertEquals(false, estaRecolectando);
    }

    @Test
    public void estaReparando_LuegoDeIniciarConstruccion_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        boolean estaReparando = aldeano.estaReparando();

        // Asert
        Assert.assertEquals(false, estaReparando);
    }


    @Test
    public void estaReparando_LuegoDeIniciarReparacion_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        boolean estaReparando = aldeano.estaReparando();

        // Assert
        Assert.assertEquals(true, estaReparando);

    }

    @Test
    public void estaRecolectando_LuegoDeIniciarReparacion_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        boolean estaRecolectandoOro = aldeano.estaRecolectandoOro();

        // Asert
        Assert.assertEquals(false, estaRecolectandoOro);
    }

    @Test
    public void estaConstruyendo_LuegoDeIniciarReparacion_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        boolean estaConstruyendo = aldeano.estaConstruyendo();

        // Asert
        Assert.assertEquals(false, estaConstruyendo);
    }

    @Test
    public void recolectarOro_CuandoEstaConstruyendo_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 0;

        // Act
        aldeano.iniciarConstruccionDePlazaCentral();
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void recolectarOro_CuandoEstaReparando_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);
        int oroEsperado = 0;

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
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

        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel, Mockito.mock(UnidadesFabrica.class));

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
        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDeCuartelLuegoDeReparacion = 140;

        // Act
        reparador.iniciarReparacion(plazaCentral);
        reparador.iniciarReparacion(cuartel);
        int vidaFinalDeCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDeCuartelLuegoDeReparacion, vidaFinalDeCuartel);
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
        aldeano.continuarReparando();
        aldeano.continuarReparando();

        int oroRecolectado = aldeano.recolectarOro();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void estaConstruyendo_LuegoDeContinuarConstruyendoUnaVezUnCuartel_DevuelveTrue(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruyendo();
        boolean estaConstruyendo = aldeano.estaConstruyendo();

        // Assert
        Assert.assertEquals(true, estaConstruyendo);

    }

    @Test
    public void estaConstruyendo_LuegoDeContinuarConstruyendoDosVecesUnCuartel_DevuelveFalse(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruyendo();
        aldeano.continuarConstruyendo();
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
        aldeano.continuarConstruyendo();
        aldeano.continuarConstruyendo();

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
        aldeano.continuarConstruyendo();

        // Assert
        Assert.assertTrue(cuarteles.isEmpty());
    }

    @Test
    public void recolectarOro_LuegoDeTerminarDeConstruir_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        aldeano.iniciarConstruccionDeCuartel();
        aldeano.continuarConstruyendo();
        aldeano.continuarConstruyendo();

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
