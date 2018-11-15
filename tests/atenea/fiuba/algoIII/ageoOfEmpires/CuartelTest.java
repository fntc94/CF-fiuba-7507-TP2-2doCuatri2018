package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class CuartelTest {

    @Test
    public void construirArquero_DevuelveArquero(){

        // Arrange
        int vidaMaximaCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel);

        // Act
        Arquero arquero = cuartel.crearArquero();

        // Assert
        Assert.assertNotNull(arquero);

    }

    @Test
    public void obtenerCostoArquero_Devuelve75(){

        // Arrange
        int vidaMaximaCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel);
        int costoEsperadoArquero = 75;

        // Act
        int costoObtenidoArquero = cuartel.obtenerCostoArquero();

        // Assert
        Assert.assertEquals(costoEsperadoArquero, costoObtenidoArquero);

    }

    @Test
    public void construirEspadachin_DevuelveEspadachin(){

        // Arrange
        int vidaMaximaCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel);

        // Act
        Espadachin espadachin = cuartel.crearEspadachin();

        // Assert
        Assert.assertNotNull(espadachin);

    }

    @Test
    public void obtenerCostoEspadachin_Devuelve50(){

        // Arrange
        int vidaMaximaCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel);
        int costoEsperadoEspadachin = 50;

        // Act
        int costoObtenidoEspadachin = cuartel.obtenerCostoEspadachin();

        // Assert
        Assert.assertEquals(costoEsperadoEspadachin, costoObtenidoEspadachin);

    }

}
