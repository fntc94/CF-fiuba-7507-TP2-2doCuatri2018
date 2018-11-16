package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class PlazaCentralTest {

    private PlazaCentral crearPlazaCentral(){
        int vidaMaximaDePlazaCentral = 450;
        return new PlazaCentral(vidaMaximaDePlazaCentral, new UnidadesFabrica());
    }

    @Test
    public void construirAldeano_DevuelveAldeano(){

        // Arrange
        PlazaCentral plazaCentral = this.crearPlazaCentral();

        // Act
        Aldeano aldeano = plazaCentral.construirAldeano();

        // Assert
        Assert.assertNotNull(aldeano);

    }

    @Test
    public void obtenerCostoAldeano_Devuelve25(){

        // Arange
        PlazaCentral plazaCentral = this.crearPlazaCentral();
        int costoEsperadoDeAldeano = 25;

        // Act
        int costoObtenidoDeAldeano = plazaCentral.obtenerCostoAldeano();

        // Assert
        Assert.assertEquals(costoEsperadoDeAldeano, costoObtenidoDeAldeano);

    }

}
