package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ReparacionDePlazaCentralTests {

    @Test
    public void reparar_PlazaCentral_PlazaCentralRecupera25DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }

    @Test
    public void reparar_PlazaCentralDosVecesConElMismoAldeano_PlazaCentralRecupera50DeVida(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 350;

        // Act
        aldeano.reparar(plazaCentral);
        aldeano.reparar();
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);

    }

    @Test
    public void reparar_PlazaCentralUnaVez_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 440;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }


    @Test
    public void reparar_PlazaCentralConMaximoDeVida_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 450;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }

    @Test
    public void reparar_PlazaCentralConDosAldeanosDistintos_PlazaCentralRecuperaSolo25DeVida(){

        // Arrange
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano1.reparar(plazaCentral);
        aldeano2.reparar(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }
}
