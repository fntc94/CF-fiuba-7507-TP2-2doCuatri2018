package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EspadachinTest {

    @Test
    public void atacar_AOtroEspadachin_LeProduceDanio25(){

        // Arrange
        int vidaMaxima = 100;

        Espadachin atacante = new Espadachin(vidaMaxima);
        Espadachin atacado = new Espadachin(vidaMaxima);

        int danioEsperado = 25;

        // Act
        atacante.atacar(atacado);
        int vidaObtenidaLuegoDelAtaque = atacado.getVida();
        int danioProducido = vidaMaxima - vidaObtenidaLuegoDelAtaque;

       // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_AUnArquero_LeProduceDanio25(){

        // Arrange
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaArquero = 75;
        Arquero arquero = new Arquero(vidaArquero);

        int danioEsperado = 25;

        // Act
        espadachin.atacar(arquero);
        int vidaObtenidaLuegoDelAtaque = arquero.getVida();
        int danioProducido = vidaArquero - vidaObtenidaLuegoDelAtaque;


        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_AUnArmaDeAsedio_LeProduceDanio25(){

        // Arrange
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaInicialArmaDeAsedio = 150;
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(vidaInicialArmaDeAsedio);

        int danioEsperado = 25;

        // Act
        espadachin.atacar(armaDeAsedio);
        int vidaFinalArmaDeAsedio = armaDeAsedio.getVida();
        int danioObtenido = vidaInicialArmaDeAsedio - vidaFinalArmaDeAsedio;

        // Assert
        Assert.assertEquals(danioEsperado, danioObtenido);

    }

    @Test
    public void atacar_AOtroEspadachinConVida20_LaVidaDelAtacadoEsCeroLuegoDelAtaque(){

        // Arrange
        int vidaMaximaEspadachin = 100;
        int vidaInicialAtacante =  vidaMaximaEspadachin;
        int vidaInicialAtacado = 20;

        Espadachin atacante = new Espadachin(vidaMaximaEspadachin);
        Espadachin atacado = new Espadachin(vidaMaximaEspadachin, vidaInicialAtacado);

        int vidaEsperadaLuegoDelAtaque = 0;

        // Act
        atacante.atacar(atacado);
        int vidaObtenidaLuegoDelAtaque = atacado.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);

    }

    @Test
    public void atacar_AUnArqueroConVida10_LaVidaDelArqueroEsCeroLuegoDelAtaque(){

        // Arrange
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaArquero = 10;
        Arquero arquero = new Arquero(vidaArquero);

        int vidaEsperadaLuegoDelAtaque = 0;

        // Act
        espadachin.atacar(arquero);
        int vidaObtenidaLuegoDelAtaque = arquero.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);

    }

    @Test
    public void atacar_APlazaCentral_LeProduceDanio15(){

        // Arrange
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaPlazaCentral = 450;
        int vidaInicialPlazaCentral = 450;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaPlazaCentral, vidaInicialPlazaCentral, Mockito.mock(UnidadesFabrica.class));

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
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaCuartel = 250;
        int vidaInicialCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel, vidaInicialCuartel, Mockito.mock(UnidadesFabrica.class));

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
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaCastillo = 1000;
        int vidaInicialCastillo = 1000;
        Castillo castillo = new Castillo(vidaMaximaCastillo, vidaInicialCastillo, Mockito.mock(UnidadesFabrica.class));

        int danioEsperado = 15;

        // Act
        espadachin.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();
        int danioProducido = vidaInicialCastillo- vidaFinalCastillo;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

}