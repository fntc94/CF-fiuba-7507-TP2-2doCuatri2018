package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.edificios.Cuartel;
import modelo.posicion.Posicion;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CuartelTest {

    private Cuartel crearCuartel(){
        return new Cuartel(Mockito.mock(Posicion.class), new UnidadesFabrica());
    }

    @Test
    public void construirArquero_DevuelveArquero(){

        // Arrange
        Cuartel cuartel = this.crearCuartel();

        // Act
        Arquero arquero = cuartel.crearArquero(Mockito.mock(Posicion.class));

        // Assert
        Assert.assertNotNull(arquero);

    }

    @Test
    public void obtenerCostoArquero_Devuelve75(){

        // Arrange
        Cuartel cuartel = this.crearCuartel();
        int costoArqueroEsperado = 75;

        // Act
        int costoArqueroObtenido = cuartel.obtenerCostoArquero();

        // Assert
        Assert.assertEquals(costoArqueroEsperado, costoArqueroObtenido);

    }

    @Test
    public void construirEspadachin_DevuelveEspadachin(){

        // Arrange
        Cuartel cuartel = this.crearCuartel();

        // Act
        Espadachin espadachin = cuartel.crearEspadachin(Mockito.mock(Posicion.class));

        // Assert
        Assert.assertNotNull(espadachin);

    }

    @Test
    public void obtenerCostoEspadachin_Devuelve50(){

        // Arrange
        int vidaMaximaCuartel = 250;
        Cuartel cuartel = new Cuartel(Mockito.mock(Posicion.class),new UnidadesFabrica());
        int costoEspadachinEsperado = 50;

        // Act
        int costoEspadachinObtenido = cuartel.obtenerCostoEspadachin();

        // Assert
        Assert.assertEquals(costoEspadachinEsperado, costoEspadachinObtenido);

    }

}
