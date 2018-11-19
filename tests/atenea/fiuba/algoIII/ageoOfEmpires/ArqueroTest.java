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

    @Test
    public void atacar_APlazaCentral_LeProduceDanio10(){

        // Arrange
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        PlazaCentral plazaCentral = new PlazaCentral(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialPlazaCentral = plazaCentral.getVida();
        int danioEsperado = 10;

        // Act
        arquero.atacar(plazaCentral);
        int vidaFinalPlazaCentral = plazaCentral.getVida();
        int danioProducido = vidaInicialPlazaCentral - vidaFinalPlazaCentral;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }


    @Test
    public void atacar_ACuartel_LeProduceDanio10(){

        // Arrange
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Cuartel cuartel = new Cuartel(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCuartel = cuartel.getVida();
        int danioEsperado = 10;

        // Act
        arquero.atacar(cuartel);
        int vidaFinalCuartel = cuartel.getVida();
        int danioProducido = vidaInicialCuartel- vidaFinalCuartel;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ACastillo_LeProduceDanio10(){

        // Arrange
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Castillo castillo = new Castillo(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCastillo = castillo.getVida();
        int danioEsperado = 10;

        // Act
        arquero.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();
        int danioProducido = vidaInicialCastillo- vidaFinalCastillo;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_Aldeano_LeProduceDanio15(){

        // Arrange
        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Aldeano aldeano = new Aldeano(Mockito.mock(Posicion.class), Mockito.mock(EdificiosEnConstruccionFabrica.class));

        int vidaInicialAldeano = aldeano.getVida();
        int danioEsperado = 15;

        // Act
        arquero.atacar(aldeano);
        int vidaFinalAldeano = aldeano.getVida();
        int danioProducido = vidaInicialAldeano - vidaFinalAldeano;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }
}
