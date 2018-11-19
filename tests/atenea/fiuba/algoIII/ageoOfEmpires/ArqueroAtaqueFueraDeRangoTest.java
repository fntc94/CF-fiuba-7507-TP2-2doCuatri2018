package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArqueroAtaqueFueraDeRangoTest {

    private Arquero atacante;
    private Unidad unidad;
    private int danioEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        final int DANIO_ESPERADO = 0;
        final int DISTANCIA_ATAQUE_4 = 4;

        Arquero arquero = new Arquero(Mockito.mock(Posicion.class));
        Posicion posicionAtacante = arquero.getPosicion();

        Posicion posicionADistancia4 = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionADistancia4)).thenReturn(DISTANCIA_ATAQUE_4);

        ArrayList collection = new ArrayList();

        collection.add(new Object[]{arquero, new Aldeano(posicionADistancia4, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Espadachin(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Arquero(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new ArmaDeAsedio(posicionADistancia4), DANIO_ESPERADO});

        return collection;

    }


    public ArqueroAtaqueFueraDeRangoTest(Arquero atacante, Unidad unidad, int danioEsperado){
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
