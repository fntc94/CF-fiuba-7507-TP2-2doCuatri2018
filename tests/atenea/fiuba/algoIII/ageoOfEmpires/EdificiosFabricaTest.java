package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class EdificiosFabricaTest {

    private EdificiosFabrica getUnidadBajoPrueba(){
        return new EdificiosFabrica();
    }

    @Test
    public void crearPlazaCentral_getVidaPlazaCentralDevuelve450(){

        // Arrange
        EdificiosFabrica unidadBajoPrueba = this.getUnidadBajoPrueba();
        int vidaEsperadaPlazaCentral = 450;

        // Act
        PlazaCentral plazaCentral = unidadBajoPrueba.crearPlazaCentral();
        int vidaObtenidaPlazaCentral = plazaCentral.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaPlazaCentral, vidaObtenidaPlazaCentral);

    }

    @Test
    public void crearCuartel_getVidaCuartelDevuelve250(){

        // Arrange
        EdificiosFabrica unidadBajoPrueba = this.getUnidadBajoPrueba();
        int vidaEsperadaCuartel = 250;

        // Act
        Cuartel cuartel = unidadBajoPrueba.crearCuartel();
        int vidaObtenidaCuartel = cuartel.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaCuartel, vidaObtenidaCuartel);

    }

    @Test
    public void crearCastillo_getVidaCastilloDevuelve1000(){

        // Arrange
        EdificiosFabrica unidadBajoPrueba = this.getUnidadBajoPrueba();
        int vidaEsperadaCastillo = 1000;

        // Act
        Castillo castillo = unidadBajoPrueba.crearCastillo();
        int vidaObtenidaCastillo = castillo.getVida();

        // Assert
        Assert.assertEquals(vidaEsperadaCastillo, vidaObtenidaCastillo);

    }

}
