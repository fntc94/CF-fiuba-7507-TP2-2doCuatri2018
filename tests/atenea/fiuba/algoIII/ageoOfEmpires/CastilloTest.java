package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class CastilloTest {

    @Test
    public void crearArmaDeAsedio_DevuelveArmaDeAsedio(){

        // Arrange
        int vidaMaximaCastillo = 1000;
        Castillo castillo = new Castillo(vidaMaximaCastillo, new UnidadesFabrica());

        // Act
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

        // Assert
        Assert.assertNotNull(armaDeAsedio);

    }

    @Test
    public void obtenerCostoArmaDeAsedio_Devuelve200(){

        // Arrange
        int vidaMaximaCastillo = 1000;
        Castillo castillo = new Castillo(vidaMaximaCastillo, new UnidadesFabrica());
        int costoEsperado = 200;

        // Act
        int costoObtenido = castillo.obtenerCostoArmaDeAsedio();


        // Assert
        Assert.assertEquals(costoEsperado, costoObtenido);
    }

}
