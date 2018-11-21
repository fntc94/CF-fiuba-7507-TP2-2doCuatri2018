package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.ArmaDeAsedio;
import org.junit.Test;
import org.mockito.Mockito;

public class ArmaDeAsedioTest {

    private ArmaDeAsedio crearArmaDeAsedio(){
        return new ArmaDeAsedio(Mockito.mock(Posicion.class), Mockito.mock(IEstrategiaAtaque.class));
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void atacar_CuandoNoEstaMontada_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();

        // Act
        armaDeAsedio.atacar(Mockito.mock(IAtacable.class));
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void atacar_LuegoDeMontarYDesmontar_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();
        armaDeAsedio.desmontar();

        // Act
        armaDeAsedio.atacar(Mockito.mock(IAtacable.class));
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void mover_CuandoEstaMontada_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();

        // Act
        armaDeAsedio.mover(Mockito.mock(IDireccion.class));
    }

    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void mover_LuegoDeDesmotarYMontar_LanzaExcepcion(){

        // Arrange
        ArmaDeAsedio armaDeAsedio= this.crearArmaDeAsedio();
        armaDeAsedio.montar();
        armaDeAsedio.desmontar();
        armaDeAsedio.montar();

        // Act
        armaDeAsedio.mover(Mockito.mock(IDireccion.class));
    }

}
