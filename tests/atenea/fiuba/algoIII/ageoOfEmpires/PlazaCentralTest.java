package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class PlazaCentralTest {

    @Test
    public void construirAldeano_DevuelveAldeano(){

        // Arrange
        PlazaCentral plazaCentral = new PlazaCentral(450, 450);

        // Act
        Aldeano aldeano = plazaCentral.construirAldeano();

        // Assert
        Assert.assertNotNull(aldeano);

    }

    @Test
    public void obtenerCostoAldeano_Devuelve25(){

        // Arange
        PlazaCentral plazaCentral = new PlazaCentral(450, 450);
        int costoEsperado = 25;

        // Act
        int costoObtenido = plazaCentral.obtenerCostoAldeano();

        // Assert
        Assert.assertEquals(costoEsperado, costoObtenido);

    }

}
