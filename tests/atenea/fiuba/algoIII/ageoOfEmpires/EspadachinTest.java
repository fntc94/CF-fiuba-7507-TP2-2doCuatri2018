package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class EspadachinTest {

    @Test
    public void atacar_AOtroEspadachin_LeBaja25DeVida(){

        // Arrange
        int vidaMaxima = 100;

        Espadachin atacante = new Espadachin(vidaMaxima);
        Espadachin atacado = new Espadachin(vidaMaxima);

        int vidaEsperadaLuegoDelAtaque = 75;

        // Act
        atacante.atacar(atacado);
        int vidaObtenidaLuegoDelAtaque = atacado.getVida();

       // Assert
        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);

    }

    @Test
    public void atacar_AUnArquero_LeBaja25DeVida(){

        // Arrange
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaArquero = 75;
        Arquero arquero = new Arquero(vidaArquero);

        int vidaEsperadaLuegoDelAtaque = 50;

        // Act
        espadachin.atacar(arquero);
        int vidaObtenidaLuegoDelAtaque = arquero.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);

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

}