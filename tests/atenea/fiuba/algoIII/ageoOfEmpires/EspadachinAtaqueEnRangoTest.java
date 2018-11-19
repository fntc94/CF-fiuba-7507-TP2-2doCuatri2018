package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EspadachinAtaqueEnRangoTest {

    private Espadachin atacante;
    private Unidad atacado;
    private int danioEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        final int DANIO_ESPERADO = 25;
        final int DISTANCIA_ATAQUE_1 = 1;

        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Posicion posicionEspadachin = espadachin.getPosicion();

        Posicion posicionADistancia1 = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionADistancia1)).thenReturn(DISTANCIA_ATAQUE_1);

        ArrayList collection = new ArrayList();

        collection.add(new Object[]{espadachin, new Aldeano(posicionADistancia1, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new Espadachin(posicionADistancia1), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new Arquero(posicionADistancia1), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new ArmaDeAsedio(posicionADistancia1), DANIO_ESPERADO});

        return collection;

    }

    // Constructor
    public EspadachinAtaqueEnRangoTest(Espadachin atacante, Unidad atacado, int danioEsperado){
        this.atacante = atacante;
        this.atacado = atacado;
        this.danioEsperado = danioEsperado;
    }

    @Test
    public void atacar_AUnidadDentroDelRangoDeAtaque_ProduceDanio15(){

        // Arrange
        int vidaInicialAtacado = atacado.getVida();

        // Act
        atacante.atacar(atacado);
        int vidaFinalAtacado = atacado.getVida();
        int danioProducido = vidaInicialAtacado - vidaFinalAtacado;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

}
