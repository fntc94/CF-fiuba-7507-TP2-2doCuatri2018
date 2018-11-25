package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.UnidadFueraDeRangoDeAtaqueExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.ArmaDeAsedio;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CastilloTest {

    private Castillo crearCastilloParaPrubasDeAtaque(Posicion posicion){
        IEstrategiaAtaque<Castillo> estrategiaAtaqueCastillo = new EstrategiaAtaqueCastillo();
        return new Castillo(posicion, Mockito.mock(IUnidadesCastilloFabrica.class),estrategiaAtaqueCastillo);
    }

    @Test
    public void crearArmaDeAsedio_DevuelveArmaDeAsedio(){

        // Arrange
        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), new UnidadesFabrica(), Mockito.mock(IEstrategiaAtaque.class));

        // Act
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

        // Assert
        Assert.assertNotNull(armaDeAsedio);

    }

    @Test
    public void obtenerCostoArmaDeAsedio_Devuelve200(){

        // Arrange
        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), new UnidadesFabrica(), Mockito.mock(IEstrategiaAtaque.class));
        int costoEsperado = 200;

        // Act
        int costoObtenido = castillo.obtenerCostoArmaDeAsedio();


        // Assert
        Assert.assertEquals(costoEsperado, costoObtenido);
    }

    @Test
    public void atacar_EspadachinADistancia1_ProduceDanio20(){

        // Arange
        int DISTANCIA_DE_ATAQUE = 1;
        Posicion posicionCastillo = Mockito.mock(Posicion.class);
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Mockito.when(posicionCastillo.distanciaA(posicionEspadachin)).thenReturn(DISTANCIA_DE_ATAQUE);

        Castillo castillo = this.crearCastilloParaPrubasDeAtaque(posicionCastillo);
        Espadachin espadachin = new Espadachin(posicionEspadachin, Mockito.mock(IEstrategiaAtaque.class));

        int vidaInicialEspadachin = espadachin.getVida();
        int danioEsperado = 20;

        // Act
        castillo.atacar(espadachin);
        int vidaFinalEspadachin = espadachin.getVida();
        int danioProducido = vidaInicialEspadachin - vidaFinalEspadachin;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);


    }

    @Test
    public void atacar_ArqueroADistancia3_ProduceDanio20(){

        // Arange
        int DISTANCIA_DE_ATAQUE = 3;
        Posicion posicionCastillo = Mockito.mock(Posicion.class);
        Posicion posicionArquero = Mockito.mock(Posicion.class);
        Mockito.when(posicionCastillo.distanciaA(posicionArquero)).thenReturn(DISTANCIA_DE_ATAQUE);

        Castillo castillo = this.crearCastilloParaPrubasDeAtaque(posicionCastillo);
        Arquero arquero = new Arquero(posicionArquero, Mockito.mock(IEstrategiaAtaque.class));

        int vidaInicialArquero = arquero.getVida();
        int danioEsperado = 20;

        // Act
        castillo.atacar(arquero);
        int vidaFinalArquero = arquero.getVida();
        int danioProducido = vidaInicialArquero - vidaFinalArquero;

        //Assert
        Assert.assertEquals(danioEsperado, danioProducido);


    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_AldeanoADistancia4_NoProduceDanio(){

        // Arange
        int DISTANCIA_DE_ATAQUE = 4;
        Posicion posicionCastillo = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionCastillo.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_DE_ATAQUE);

        Castillo castillo = this.crearCastilloParaPrubasDeAtaque(posicionCastillo);
        Aldeano aldeano = new Aldeano(posicionAldeano);

        int vidaInicialAldeano = aldeano.getVida();
        int danioEsperado = 0;

        // Act
        castillo.atacar(aldeano);
        int vidaFinalAldeano = aldeano.getVida();
        int danioProducido = vidaInicialAldeano - vidaFinalAldeano;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_AldeanoADistancia4_LanzaExcepcion(){

        // Arange
        int DISTANCIA_DE_ATAQUE = 4;
        Posicion posicionCastillo = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionCastillo.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_DE_ATAQUE);

        Castillo castillo = this.crearCastilloParaPrubasDeAtaque(posicionCastillo);
        Aldeano aldeano = new Aldeano(posicionAldeano);


        // Act
        castillo.atacar(aldeano);

    }

    @Test
    public void atacar_CuartelADistancia2_ProduceDanio20(){

        // Arange
        int DISTANCIA_DE_ATAQUE = 2;
        Posicion posicionCastillo = Mockito.mock(Posicion.class);
        Posicion posicionCuartel = Mockito.mock(Posicion.class);
        Mockito.when(posicionCastillo.distanciaA(posicionCuartel)).thenReturn(DISTANCIA_DE_ATAQUE);

        Castillo castillo = this.crearCastilloParaPrubasDeAtaque(posicionCastillo);
        Cuartel cuartel = new Cuartel(posicionCuartel, Mockito.mock(IUnidadesCuartelFabrica.class));

        int vidaInicialCuartel = cuartel.getVida();
        int danioEsperado = 20;

        // Act
        castillo.atacar(cuartel);
        int vidaFinalCuartel = cuartel.getVida();
        int danioProducido = vidaInicialCuartel - vidaFinalCuartel;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);


    }

}
