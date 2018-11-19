package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArmaDeAsedioAtaqueEnRangoTest {

    private ArmaDeAsedio atacante;
    private IAtacable atacado;
    private int danioEsperado;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        final int DANIO_ESPERADO_UNIDADES = 0;
        final int DANIO_ESPERADO_EDIFICIOS = 75;

        final int DISTANCIA_ATAQUE_1 = 1;
        final int DISTANCIA_ATAQUE_2 = 2;
        final int DISTANCIA_ATAQUE_3 = 3;
        final int DISTANCIA_ATAQUE_4 = 4;
        final int DISTANCIA_ATAQUE_5 = 5;

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(Mockito.mock(Posicion.class));
        Posicion posicionArmaDeAsedio = armaDeAsedio.getPosicion();

        Posicion posicionADistancia1 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArmaDeAsedio.distanciaA(posicionADistancia1)).thenReturn(DISTANCIA_ATAQUE_1);

        Posicion posicionADistancia2 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArmaDeAsedio.distanciaA(posicionADistancia2)).thenReturn(DISTANCIA_ATAQUE_2);

        Posicion posicionADistancia3 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArmaDeAsedio.distanciaA(posicionADistancia3)).thenReturn(DISTANCIA_ATAQUE_3);

        Posicion posicionADistancia4 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArmaDeAsedio.distanciaA(posicionADistancia4)).thenReturn(DISTANCIA_ATAQUE_4);

        Posicion posicionADistancia5 = Mockito.mock(Posicion.class);
        Mockito.when(posicionArmaDeAsedio.distanciaA(posicionADistancia5)).thenReturn(DISTANCIA_ATAQUE_5);

        ArrayList collection = new ArrayList();

        // Unidades a distancia 1
        collection.add(new Object[]{armaDeAsedio, new Aldeano(posicionADistancia1, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Espadachin(posicionADistancia1), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Arquero(posicionADistancia1), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new ArmaDeAsedio(posicionADistancia1), DANIO_ESPERADO_UNIDADES});

        // Unidades a distancia 2
        collection.add(new Object[]{armaDeAsedio, new Aldeano(posicionADistancia2, Mockito.mock(EdificiosEnConstruccionFabrica.class)), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Espadachin(posicionADistancia2), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Arquero(posicionADistancia2), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new ArmaDeAsedio(posicionADistancia2), DANIO_ESPERADO_UNIDADES});

        // Unidades a distancia 3
        collection.add(new Object[]{armaDeAsedio, new Aldeano(posicionADistancia3, Mockito.mock(EdificiosEnConstruccionFabrica.class)),DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Espadachin(posicionADistancia3), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Arquero(posicionADistancia3), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new ArmaDeAsedio(posicionADistancia3), DANIO_ESPERADO_UNIDADES});

        // Unidades a distancia 4
        collection.add(new Object[]{armaDeAsedio, new Aldeano(posicionADistancia4, Mockito.mock(EdificiosEnConstruccionFabrica.class)),DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Espadachin(posicionADistancia4), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Arquero(posicionADistancia4), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new ArmaDeAsedio(posicionADistancia4), DANIO_ESPERADO_UNIDADES});

        // Unidades a distancia 5
        collection.add(new Object[]{armaDeAsedio, new Aldeano(posicionADistancia5, Mockito.mock(EdificiosEnConstruccionFabrica.class)),DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Espadachin(posicionADistancia5), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new Arquero(posicionADistancia5), DANIO_ESPERADO_UNIDADES});
        collection.add(new Object[]{armaDeAsedio, new ArmaDeAsedio(posicionADistancia5), DANIO_ESPERADO_UNIDADES});

        // Edificios a distancia 1
        collection.add(new Object[]{armaDeAsedio, new PlazaCentral(posicionADistancia1, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Cuartel(posicionADistancia1, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Castillo(posicionADistancia1, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO_EDIFICIOS});

        // Edificios a distancia 2
        collection.add(new Object[]{armaDeAsedio, new PlazaCentral(posicionADistancia2, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Cuartel(posicionADistancia2, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Castillo(posicionADistancia2, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO_EDIFICIOS});

        // Edificios a distancia 3
        collection.add(new Object[]{armaDeAsedio, new PlazaCentral(posicionADistancia3, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Cuartel(posicionADistancia3, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Castillo(posicionADistancia3, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO_EDIFICIOS});

        // Edificios a distancia 4
        collection.add(new Object[]{armaDeAsedio, new PlazaCentral(posicionADistancia4, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Cuartel(posicionADistancia4, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Castillo(posicionADistancia4, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO_EDIFICIOS});

        // Edificios a distancia 5
        collection.add(new Object[]{armaDeAsedio, new PlazaCentral(posicionADistancia5, Mockito.mock(IUnidadesPlazaCentralFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Cuartel(posicionADistancia5, Mockito.mock(IUnidadesCuartelFabrica.class)), DANIO_ESPERADO_EDIFICIOS});
        collection.add(new Object[]{armaDeAsedio, new Castillo(posicionADistancia5, Mockito.mock(IUnidadesCastilloFabrica.class)), DANIO_ESPERADO_EDIFICIOS});

        return collection;

    }

    // Constructor
    public ArmaDeAsedioAtaqueEnRangoTest(ArmaDeAsedio atacante, IAtacable atacado, int danioEsperado){
        this.atacante = atacante;
        this.atacado = atacado;
        this.danioEsperado = danioEsperado;
    }

    @Test
    public void atacar_DentroDelRangoDeAtaque_ProduceDanioEsperado(){

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
