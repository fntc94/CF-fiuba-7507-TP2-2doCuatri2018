package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Cuartel;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Arquero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.UnidadesFabrica;
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
        Arquero arquero = cuartel.crearArquero();

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
        Espadachin espadachin = cuartel.crearEspadachin();

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