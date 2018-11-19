package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EspadachinTest {

//    @Test
//    public void atacar_AOtroEspadachinConVida20_LaVidaDelAtacadoEsCeroLuegoDelAtaque(){
//
//        // Arrange
//        int vidaMaximaEspadachin = 100;
//        int vidaInicialAtacante =  vidaMaximaEspadachin;
//        int vidaInicialAtacado = 20;
//
//        Espadachin atacante = new Espadachin(vidaMaximaEspadachin);
//        Espadachin atacado = new Espadachin(vidaMaximaEspadachin, vidaInicialAtacado);
//
//        int vidaEsperadaLuegoDelAtaque = 0;
//
//        // Act
//        atacante.atacar(atacado);
//        int vidaObtenidaLuegoDelAtaque = atacado.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);
//
//    }
//
//    @Test
//    public void atacar_AUnArqueroConVida10_LaVidaDelArqueroEsCeroLuegoDelAtaque(){
//
//        // Arrange
//        int vidaEspadachin = 100;
//        Espadachin espadachin = new Espadachin(vidaEspadachin);
//
//        int vidaArquero = 10;
//        Arquero arquero = new Arquero(vidaArquero);
//
//        int vidaEsperadaLuegoDelAtaque = 0;
//
//        // Act
//        espadachin.atacar(arquero);
//        int vidaObtenidaLuegoDelAtaque = arquero.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);
//
//    }

    @Test
    public void atacar_APlazaCentral_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        PlazaCentral plazaCentral = new PlazaCentral(Mockito.mock(Posicion.class), Mockito.mock(UnidadesFabrica.class));

        int vidaInicialPlazaCentral = plazaCentral.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(plazaCentral);
        int vidaFinalPlazaCentral = plazaCentral.getVida();
        int danioProducido = vidaInicialPlazaCentral - vidaFinalPlazaCentral;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ACuartel_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Cuartel cuartel = new Cuartel(Mockito.mock(Posicion.class), Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCuartel = cuartel.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(cuartel);
        int vidaFinalCuartel = cuartel.getVida();
        int danioProducido = vidaInicialCuartel- vidaFinalCuartel;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ACastillo_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCastillo = castillo.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();
        int danioProducido = vidaInicialCastillo- vidaFinalCastillo;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }


}