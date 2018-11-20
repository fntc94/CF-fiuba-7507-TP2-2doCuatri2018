package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ArqueroTest {


    private Arquero arquero;

    @Before
    public void setUp(){
        IEstrategiaAtaque<Arquero> estrategiaAtaqueArquero = new EstrategiaAtaqueArquero();
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class), estrategiaAtaqueArquero);
        this.arquero = arquero;
    }

    @Test
    public void atacar_AOtroArquero6Veces_LaVidaDelArqueroAtacadoEsCeroLuegoDelAtaque(){

        // Arrange
        Arquero atacante = this.arquero;
        Arquero atacado = new Arquero(Mockito.mock(Posicion.class), Mockito.mock(IEstrategiaAtaque.class));

        int vidaFinalEsperada = 0;

        // Act
        atacante.atacar(atacado);
        atacante.atacar(atacado);
        atacante.atacar(atacado);
        atacante.atacar(atacado);
        atacante.atacar(atacado);
        atacante.atacar(atacado);
        int vidaFinalObtenida = atacado.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperada, vidaFinalObtenida);
    }

    @Test
    public void atacar_AUnEspadachin7Veces_LaVidaDelEspadacinEsCeroLuegoDelAtaque(){

        // Arrange
        Arquero atacante = this.arquero;
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class), Mockito.mock(IEstrategiaAtaque.class));

        int vidaFinalEsperada = 0;

        // Act
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        arquero.atacar(espadachin);
        int vidaFinalObtenida = espadachin.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperada, vidaFinalObtenida);

    }

}
