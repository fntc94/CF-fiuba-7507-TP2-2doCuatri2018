package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.UnEdificioNoPuedeSerConstruidoPorDosAldeanosALaVezException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

    private Aldeano crearAldeano(){
        return new Aldeano(Mockito.mock(Posicion.class));
    }

    private PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(Mockito.mock(Posicion.class), Mockito.mock(UnidadesFabrica.class));
    }

    @Test
    public void getVida_Devuelve50(){

        Aldeano aldeano = this.crearAldeano();
        assertEquals(50, aldeano.getVida());
    }

    @Test
    public void trabajar_LuegoDeLaCreacion_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 20;

        // Act
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);

    }

    @Test()
    public void iniciarConstruccion_CuandoEstaRecolectando_NoLanzaExcepcion(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        // Act
        aldeano.iniciarConstruccion(Mockito.mock(Construccion.class));
    }


    @Test()
    public void inicarReparacion_CuandoEstaRecolectando_NoLanzaExcepcion(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);

        // Act
        aldeano.iniciarReparacion(edificioReparable);
    }

    @Test
    public void trabajar_LuegoDeIniciarConstruccion_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 0;

        // Act
        aldeano.iniciarConstruccion(Mockito.mock(Construccion.class));
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void trabajar_CuandoEstaConstruyendo_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 0;

        final int TURNOS_EN_CONTRUIR = 3;
        Posicion posicion = Mockito.mock(Posicion.class);
        Construccion edificioEnConstruccion = new ConstruccionParaPruebas(posicion, TURNOS_EN_CONTRUIR, aldeano);

        // Act
        aldeano.iniciarConstruccion(edificioEnConstruccion);
        aldeano.trabajar();
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void trabajar_LuegoDeTerminarConstruccion_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        int oroEsperado = 20;

        final int TURNOS_EN_CONTRUIR = 3;
        Posicion posicion = Mockito.mock(Posicion.class);
        Construccion edificioEnConstruccion = new ConstruccionParaPruebas(posicion, TURNOS_EN_CONTRUIR, aldeano);

        // Act
        aldeano.iniciarConstruccion(edificioEnConstruccion);
        aldeano.trabajar();
        aldeano.trabajar();
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void trabajar_LuegoDeIniciarReparacion_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);
        int oroEsperado = 0;

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

    @Test
    public void trabajar_CuandoEstaReparando_DevuelveCero(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();
        IEdificioReparable edificioReparable = Mockito.mock(IEdificioReparable.class);
        int oroEsperado = 0;

        // Act
        aldeano.iniciarReparacion(edificioReparable);
        aldeano.trabajar();
        int oroRecolectado = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroRecolectado);
    }

//    @Test
//    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezALaPlazaCentral(){
//
//        // Arrange
//        Aldeano aldeano = this.crearAldeano();
//        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
//
//        PlazaCentral plazaCentral = this.crearPlazaCentral();
//        Cuartel cuartel = new Cuartel(Mockito.mock(UnidadesFabrica.class));
//
//        int vidaFinalEsperadaDePlazaCentral = 325;
//
//
//        // Act
//        aldeano.iniciarReparacion(plazaCentral);
//        aldeano.iniciarReparacion(cuartel);
//        int vidaFinalDePlazaCentral = plazaCentral.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaFinalEsperadaDePlazaCentral, vidaFinalDePlazaCentral);
//
//    }

//    @Test
//    public void reparar_PlazaCentralYLuegoCuartel_ReparaSoloUnaVezAlCuartel(){
//
//        // Arrange
//        Aldeano reparador = this.crearAldeano();
//
//        int vidaMaximaDePlazaCentral = 450;
//        int vidaInicialDePlazaCentral = 300;
//        PlazaCentral plazaCentral = this.crearPlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
//
//        int vidaMaximaDeCuartel = 250;
//        int vidaInicialDeCuartel = 90;
//        Cuartel cuartel = new Cuartel(vidaMaximaDeCuartel, vidaInicialDeCuartel, Mockito.mock(UnidadesFabrica.class));
//        int vidaFinalEsperadaDeCuartelLuegoDeReparacion = 140;
//
//        // Act
//        reparador.iniciarReparacion(plazaCentral);
//        reparador.iniciarReparacion(cuartel);
//        int vidaFinalDeCuartel = cuartel.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaFinalEsperadaDeCuartelLuegoDeReparacion, vidaFinalDeCuartel);
//    }

//    @Test
//    public void recolectarOro_LuegoDeTerminarDeReparar_Devuelve20(){
//
//        // Arrange
//        Aldeano aldeano = this.crearAldeano();
//        int oroEsperado = 20;
//
//        int vidaMaximaDePlazaCentral = 450;
//        int vidaInicialDePlazaCentral = 400;
//        PlazaCentral plazaCentral = this.crearPlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
//
//        // Act
//        aldeano.iniciarReparacion(plazaCentral);
//        aldeano.continuarReparando();
//        aldeano.continuarReparando();
//
//        int oroRecolectado = aldeano.recolectarOro();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//    }


//    @Test
//    public void inicicarConstruccionDeCuartel_AlTerminarLaConstruccion_SeEjecutaLaAccion(){
//
//        // Arragnge
//        ArrayList<Cuartel> cuarteles = new ArrayList<>() ;
//        Aldeano aldeano = this.crearAldeano();
//
//        // Act
//        aldeano.iniciarConstruccionDeCuartel(cuarteles::add);
//        aldeano.trabajar();
//        aldeano.trabajar();
//
//        // Assert
//        Assert.assertFalse(cuarteles.isEmpty());
//    }

//    @Test
//    public void inicicarConstruccionDeCuartel_AntesDeTerminarLaConstruccion_NoSeEjecutaLaAccion(){
//
//        // Arragnge
//        ArrayList<Cuartel> cuarteles = new ArrayList<>() ;
//        Aldeano aldeano = this.crearAldeano();
//
//        // Act
//        aldeano.iniciarConstruccionDeCuartel(cuarteles::add);
//        aldeano.trabajar();
//
//        // Assert
//        Assert.assertTrue(cuarteles.isEmpty());
//    }

//    @Test
//    public void recolectarOro_LuegoDeTerminarDeConstruir_Devuelve20(){
//
//        // Arrange
//        Aldeano aldeano = this.crearAldeano();
//
//        aldeano.iniciarConstruccionDeCuartel();
//        aldeano.trabajar();
//        aldeano.trabajar();
//
//        int oroEsperado = 20;
//
//        // Act
//        int oroRecolectado = aldeano.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//
//    }

//    @Test
//    public void recolectarOro_LuegoDeComenzarAConstruir_Devuelve0(){
//
//        // Arrange
//        Aldeano aldeano = this.crearAldeano();
//        aldeano.iniciarConstruccionDeCuartel();
//
//        int oroEsperado = 0;
//
//        // Act
//        int oroRecolectado = aldeano.trabajar();
//
//        // Assert
//        Assert.assertEquals(oroEsperado, oroRecolectado);
//
//    }

    @Test
    public void trabajar_LuegoDeTerminarReparacionDeUnTurno_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int TURNOS_EN_REPARAR = 1;
        IEdificioReparable edificio = new EdificioReparableParaPruebas(TURNOS_EN_REPARAR);

        aldeano.iniciarReparacion(edificio);

        int oroEsperado = 20;

        // Act
        int oroProducido = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroProducido);

    }


    @Test
    public void trabajar_LuegoDeTerminarReparacionDeDosTurnos_Devuelve20(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int TURNOS_EN_REPARAR = 2;
        IEdificioReparable edificio = new EdificioReparableParaPruebas(TURNOS_EN_REPARAR);

        aldeano.iniciarReparacion(edificio);
        aldeano.trabajar();

        int oroEsperado = 20;

        // Act
        int oroProducido = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroProducido);

    }

    @Test
    public void trabajar_AntesDeTerminarReparacionDeDosTurnos_Devuelve0(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int TURNOS_EN_REPARAR = 2;
        IEdificioReparable edificio = new EdificioReparableParaPruebas(TURNOS_EN_REPARAR);

        aldeano.iniciarReparacion(edificio);

        int oroEsperado = 0;

        // Act
        int oroProducido = aldeano.trabajar();

        // Assert
        Assert.assertEquals(oroEsperado, oroProducido);

    }

    @Test
    public void construccionDePlazaCentral_EnPrimerTurno_NoSeEjecutaElHandler(){

        List<Edificio> edificios = new ArrayList<>();
        Aldeano aldeano = this.crearAldeano();

        ConstruccionDePlazaCentral construccionDePlazaCentral = new ConstruccionDePlazaCentral(Mockito.mock(Posicion.class));
        construccionDePlazaCentral.onConstruccionTerminada(edificios::add);

        // Act
        aldeano.iniciarConstruccion(construccionDePlazaCentral);

        // Assert
        Assert.assertTrue(edificios.isEmpty());


    }

    @Test
    public void construccionDePlazaCentral_EnSegundoTurno_NoSeEjecutaElHandler(){

        List<Edificio> edificios = new ArrayList<>();
        Aldeano aldeano = this.crearAldeano();

        ConstruccionDePlazaCentral construccionDePlazaCentral = new ConstruccionDePlazaCentral(Mockito.mock(Posicion.class));
        construccionDePlazaCentral.onConstruccionTerminada(edificios::add);

        // Act
        aldeano.iniciarConstruccion(construccionDePlazaCentral);
        aldeano.trabajar();

        // Assert
        Assert.assertTrue(edificios.isEmpty());


    }

    @Test
    public void construccionDePlazaCentral_EnTercerTurno_SeEjecutaElHandler(){

        List<Edificio> edificios = new ArrayList<>();
        Aldeano aldeano = this.crearAldeano();

        ConstruccionDePlazaCentral construccionDePlazaCentral = new ConstruccionDePlazaCentral(Mockito.mock(Posicion.class));
        construccionDePlazaCentral.onConstruccionTerminada(edificios::add);

        // Act
        aldeano.iniciarConstruccion(construccionDePlazaCentral);
        aldeano.trabajar();
        aldeano.trabajar();

        // Assert
        Assert.assertFalse(edificios.isEmpty());

    }

    @Test(expected = UnEdificioNoPuedeSerConstruidoPorDosAldeanosALaVezException.class)
    public void unEdificioNoPuedeSerConstruidoPorDosAldeanosALaVez(){

        // Arrange
        Aldeano aldeano1 = this.crearAldeano();
        Aldeano aldeano2 = this.crearAldeano();

        ConstruccionDePlazaCentral construccionDePlazaCentral = new ConstruccionDePlazaCentral(Mockito.mock(Posicion.class));

        // Act
        aldeano1.iniciarConstruccion(construccionDePlazaCentral);
        aldeano2.iniciarConstruccion(construccionDePlazaCentral);

    }


}
