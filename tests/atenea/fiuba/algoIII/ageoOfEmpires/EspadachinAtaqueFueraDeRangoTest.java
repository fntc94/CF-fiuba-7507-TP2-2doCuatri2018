package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EspadachinAtaqueFueraDeRangoTest {

    private Espadachin atacante;
    private Unidad unidad;
    private int danioEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        final int DANIO_ESPERADO = 0;
        final int DISTANCIA_ATAQUE_2 = 2;

        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Posicion posicionAtacante = espadachin.getPosicion();

        Posicion posicionADistancia4 = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionADistancia4)).thenReturn(DISTANCIA_ATAQUE_2);

        ArrayList collection = new ArrayList();

        collection.add(new Object[]{espadachin, new Aldeano(posicionADistancia4, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new Espadachin(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new Arquero(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{espadachin, new ArmaDeAsedio(posicionADistancia4), DANIO_ESPERADO});

        return collection;

    }


    public EspadachinAtaqueFueraDeRangoTest(Espadachin atacante, Unidad unidad, int danioEsperado){
        this.atacante = atacante;
        this.unidad = unidad;
        this.danioEsperado = danioEsperado;
    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_AUnidadFueraDeRangoDeAtaque_LanzaExcepcion(){

        // Act
        atacante.atacar(unidad);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_AUnidadFueraDeRangoDeAtaque_NoProduceDanio(){

        // Arrange
        int vidaInicialAtacado = unidad.getVida();

        // Act
        atacante.atacar(unidad);
        int vidaFinalAtacado = unidad.getVida();
        int danioProducido = vidaInicialAtacado - vidaFinalAtacado;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);
    }

}
