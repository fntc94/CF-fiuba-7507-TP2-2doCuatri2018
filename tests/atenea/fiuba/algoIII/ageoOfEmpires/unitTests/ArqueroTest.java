package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Arquero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.EstrategiaAtaqueArquero;
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
