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
    private IAtacable unidad;
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

        // Unidades a distancia 4
        collection.add(new Object[]{arquero, new Aldeano(posicionADistancia4, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Espadachin(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Arquero(posicionADistancia4), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new ArmaDeAsedio(posicionADistancia4), DANIO_ESPERADO});

        // Edificios a distancia 4
        collection.add(new Object[]{arquero, new PlazaCentral(posicionADistancia4, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Cuartel(posicionADistancia4, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO});
        collection.add(new Object[]{arquero, new Castillo(posicionADistancia4, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO});

        return collection;

    }


    public ArqueroAtaqueFueraDeRangoTest(Arquero atacante, IAtacable atacable, int danioEsperado){
        this.atacante = atacante;
        this.unidad = atacable;
        this.danioEsperado = danioEsperado;
    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_FueraDeRangoDeAtaque_LanzaExcepcion(){

        // Act
        atacante.atacar(unidad);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_FueraDeRangoDeAtaque_NoProduceDanio(){

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
