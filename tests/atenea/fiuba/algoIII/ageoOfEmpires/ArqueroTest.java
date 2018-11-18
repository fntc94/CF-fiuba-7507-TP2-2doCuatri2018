package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ArqueroTest {

    @Test
    public void atacar_AOtroArquero_LeBaja15DeVida(){

        // Arrange
        int vidaArquero = 75;
        Arquero atacante = new Arquero(vidaArquero);
        Arquero atacado = new Arquero(vidaArquero);

        int vidaEsperadaDelAtacadoLuegoDelAtaque = 60;

        // Act
        atacante.atacar(atacado);
        int vidaObtenidaDelAtacadoLuegoDelAtaque = atacado.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaDelAtacadoLuegoDelAtaque, vidaObtenidaDelAtacadoLuegoDelAtaque);
    }

    @Test
    public void atacar_AUnEspadachin_LeBaja15DeVida(){

        // Arrange
        int vidaArquero = 75;
        Arquero arquero = new Arquero(vidaArquero);

        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaEspadachinEsperadaLuegoDelAtaque = 85;

        // Act
        arquero.atacar(espadachin);
        int vidaEspadachinObtenidaLuegoDelAtaque = espadachin.getVida();

        // Assert
        Assert.assertEquals(vidaEspadachinEsperadaLuegoDelAtaque, vidaEspadachinObtenidaLuegoDelAtaque);

    }

    @Test
    public void atacar_AOtroArqueroConVida15_LaVidaDelArqueroAtacadoEsCeroLuegoDelAtaque(){

        // Arrange
        int vidaMaximaArquero = 75;
        int vidaInicialAtacante = vidaMaximaArquero;
        int vidaInicialAtacado = 15;

        Arquero atacante = new Arquero(vidaMaximaArquero, vidaInicialAtacante);
        Arquero atacado = new Arquero(vidaMaximaArquero, vidaInicialAtacado);

        int vidaEsperadaDelAtacadoLuegoDelAtaque = 0;

        // Act
        atacante.atacar(atacado);
        int vidaObtenidaDelAtacadoLuegoDelAtaque = atacado.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaDelAtacadoLuegoDelAtaque, vidaObtenidaDelAtacadoLuegoDelAtaque);
    }

    @Test
    public void atacar_AUnEspadachinonVida15_LaVidaDelEspadacinEsCeroLuegoDelAtaque(){

        // Arrange
        int vidaArquero = 75;
        Arquero arquero = new Arquero(vidaArquero);

        int vidaEspadachin = 15;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaEspadachinEsperadaLuegoDelAtaque = 0;

        // Act
        arquero.atacar(espadachin);
        int vidaEspadachinObtenidaLuegoDelAtaque = espadachin.getVida();

        // Assert
        Assert.assertEquals(vidaEspadachinEsperadaLuegoDelAtaque, vidaEspadachinObtenidaLuegoDelAtaque);

    }
}
