package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CastilloTest {

    @Test
    public void crearArmaDeAsedio_DevuelveArmaDeAsedio(){

        // Arrange
        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), new UnidadesFabrica());

        // Act
        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

        // Assert
        Assert.assertNotNull(armaDeAsedio);

    }

    @Test
    public void obtenerCostoArmaDeAsedio_Devuelve200(){

        // Arrange
        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), new UnidadesFabrica());
        int costoEsperado = 200;

        // Act
        int costoObtenido = castillo.obtenerCostoArmaDeAsedio();


        // Assert
        Assert.assertEquals(costoEsperado, costoObtenido);
    }

}
