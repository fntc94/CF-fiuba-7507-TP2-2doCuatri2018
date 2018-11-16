package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ReparacionDePlazaCentralTests {

    private Aldeano crearAldeano(){
        return new UnidadesFabrica().crearAldeano();
    }

    @Test
    public void reparar_PlazaCentral_PlazaCentralRecupera25DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }

    @Test
    public void reparar_PlazaCentralDosVecesConElMismoAldeano_PlazaCentralRecupera50DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 350;

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        aldeano.continuarReparando();
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);

    }

    @Test
    public void reparar_PlazaCentralUnaVez_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 440;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }


    @Test
    public void reparar_PlazaCentralConMaximoDeVida_VidaDePlazaCentralNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 450;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);
        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 450;

        // Act
        aldeano.iniciarReparacion(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }

    @Test
    public void reparar_PlazaCentralConDosAldeanosDistintos_PlazaCentralRecuperaSolo25DeVida(){

        // Arrange
        Aldeano aldeano1 = this.crearAldeano();
        Aldeano aldeano2 = this.crearAldeano();

        int vidaMaximaDePlazaCentral = 450;
        int vidaInicialDePlazaCentral = 300;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaDePlazaCentral, vidaInicialDePlazaCentral);

        int vidaFinalEsperadaDePlazaCentralLuegoDeReparacion = 325;

        // Act
        aldeano1.iniciarReparacion(plazaCentral);
        aldeano2.iniciarReparacion(plazaCentral);
        int vidaFinalDePlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDePlazaCentralLuegoDeReparacion, vidaFinalDePlazaCentral);
    }
}
