package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;

public class ArmaDeAsedioTest {

    private ArmaDeAsedio crearArmaDeAsedio(){

        int vidaMaxima = 150;
        return new ArmaDeAsedio(vidaMaxima);
    }

    @Test
    public void estaMontada_luegoDeLaCreacion_DevuelveFalse(){

        // Arrange
        int vidaMaxima = 150;

        // Act
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(vidaMaxima);
        boolean estaMontada = armaDeAsedio.estaMontada();

        // Assert
        Assert.assertEquals(false, estaMontada);
    }

    @Test
    public void estaMontada_luegoDeMontarla_DevuelveTrue(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();

        // Act
        armaDeAsedio.montar();
        boolean estaMontada = armaDeAsedio.estaMontada();

        // Assert
        Assert.assertEquals(true, estaMontada);

    }

    @Test
    public void estaMontada_luegoDeDesmontarla_DevuelveFalse(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();

        // Act
        armaDeAsedio.desmontar();
        boolean estaMontada = armaDeAsedio.estaMontada();

        // Assert
        Assert.assertEquals(false, estaMontada);

    }

    @Test
    public void atacar_CuandoEstaMontada_NoLanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();

        // Act
        armaDeAsedio.atacar();
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void atacar_CuandoNoEstaMontada_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();

        // Act
        armaDeAsedio.atacar();
    }


    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void mover_CuandoEstaMontada_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();

        // Act
        armaDeAsedio.mover();
    }

    @Test
    public void mover_CuandoNoEstaMontada_NoLanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();

        // Act
        armaDeAsedio.mover();
    }
}
