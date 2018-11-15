package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ReparacionDeCastilloTests {

    private Aldeano crearAldeano(){
        return new UnidadesFabrica().crearAldeano();
    }

    @Test
    public void reparar_Castillo_CastilloRecupera15DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 575;

        // Act
        aldeano.iniciarReparacion(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_CastilloUnaVez_VidaDeCastilloNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 795;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 800;

        // Act
        aldeano.iniciarReparacion(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_CastilloConMaximoDeVida_VidaDeCastilloNoSuperaElMaximo(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 800;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 800;

        // Act
        aldeano.iniciarReparacion(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_CastilloDosVecesConElMismoAldeano_CastilloRecupera30DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 590;

        // Act
        aldeano.iniciarReparacion(castillo);
        aldeano.continuarReparando();
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

    @Test
    public void reparar_CastilloConDosAldeanosDistintos_CastilloRecuperaSolo15DeVida(){

        // Arrange
        Aldeano aldeano1 = this.crearAldeano();
        Aldeano aldeano2 = this.crearAldeano();

        int vidaMaximaDelCastillo = 800;
        int vidaInicialDelCastillo = 560;
        Castillo castillo = new Castillo(vidaMaximaDelCastillo, vidaInicialDelCastillo, Mockito.mock(UnidadesFabrica.class));
        int vidaFinalEsperadaDelCastilloLuegoDeReparacion = 575;

        // Act
        aldeano1.iniciarReparacion(castillo);
        aldeano2.iniciarReparacion(castillo);
        int vidaFinalDelCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaFinalEsperadaDelCastilloLuegoDeReparacion, vidaFinalDelCastillo);

    }

}
