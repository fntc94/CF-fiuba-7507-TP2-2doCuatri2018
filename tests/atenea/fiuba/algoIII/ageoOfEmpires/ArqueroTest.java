package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ArqueroTest {


    private Arquero arquero;
    private AtacablesSustitutosFabrica atacablesSustitutosFabrica;

    @Before
    public void setUp(){
        arquero = new Arquero(Mockito.mock(Posicion.class));
        atacablesSustitutosFabrica = new AtacablesSustitutosFabrica(arquero);
    }

    @Test
    public void atacar_AOtroArquero6Veces_LaVidaDelArqueroAtacadoEsCeroLuegoDelAtaque(){

        // Arrange
        Arquero atacante = new Arquero(Mockito.mock(Posicion.class));
        Arquero atacado = new Arquero(Mockito.mock(Posicion.class));

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
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));

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
