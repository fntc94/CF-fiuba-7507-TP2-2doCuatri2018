package atenea.fiuba.algoIII.ageoOfEmpires;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArqueroAtaqueEnRangoTest {

    private Arquero atacante;
    private Unidad atacado;
    private int danioEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        final int DANIO_ESPERADO = 15;
        final int DISTANCIA_ATAQUE_1 = 1;
        final int DISTANCIA_ATAQUE_2 = 2;
        final int DISTANCIA_ATAQUE_3 = 3;

        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Posicion posicionArquero = arquero.getPosicion();

        Posicion posicionADistancia1 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArquero.distanciaA(posicionADistancia1)).thenReturn(DISTANCIA_ATAQUE_1);

        Posicion posicionADistancia2 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArquero.distanciaA(posicionADistancia2)).thenReturn(DISTANCIA_ATAQUE_2);

        Posicion posicionADistancia3 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArquero.distanciaA(posicionADistancia3)).thenReturn(DISTANCIA_ATAQUE_3);

        ArrayList collection = new ArrayList();

        collection.add(new Object[]{arquero, new Aldeano(posicionADistancia1, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Espadachin(posicionADistancia1), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Arquero(posicionADistancia1), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new ArmaDeAsedio(posicionADistancia1), DANIO_ESPERADO});

        collection.add(new Object[]{arquero, new Aldeano(posicionADistancia2, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Espadachin(posicionADistancia2), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Arquero(posicionADistancia2), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new ArmaDeAsedio(posicionADistancia2), DANIO_ESPERADO});


        collection.add(new Object[]{arquero, new Aldeano(posicionADistancia3, Mockito.mock(EdificiosEnConstruccionFabrica.class)),DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Espadachin(posicionADistancia3), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Arquero(posicionADistancia3), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new ArmaDeAsedio(posicionADistancia3), DANIO_ESPERADO});

        return collection;

    }

    // Constructor
    public ArqueroAtaqueEnRangoTest(Arquero atacante, Unidad atacado, int danioEsperado){
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
