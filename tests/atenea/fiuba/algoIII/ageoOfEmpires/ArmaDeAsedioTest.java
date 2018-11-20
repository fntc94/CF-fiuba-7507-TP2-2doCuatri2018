package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ArmaDeAsedioTest {

    private ArmaDeAsedio crearArmaDeAsedio(){
        return new ArmaDeAsedio(new PosicionDeUnCasillero(0,0), new EstrategiaAtaqueArmaDeAsedio());
    }

    @Test
    public void atacar_CuandoEstaMontada_NoLanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();
        IAtacable arquero = new Arquero(Mockito.mock(Posicion.class), Mockito.mock(IEstrategiaAtaque.class));

        // Act
        armaDeAsedio.atacar();
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void atacar_CuandoNoEstaMontada_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        IAtacable arquero = new Arquero(Mockito.mock(Posicion.class), Mockito.mock(IEstrategiaAtaque.class));

        // Act
        armaDeAsedio.atacar(arquero);
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
