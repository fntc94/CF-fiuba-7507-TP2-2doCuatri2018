package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Castillo;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IUnidadesCastilloFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.AtacanteParaPruebas;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.UnidadesFabrica;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ReparacionDeCastilloTests {

    private Aldeano crearAldeano(){
        return new UnidadesFabrica().crearAldeano();
    }

    private AtacanteParaPruebas crearAtacante(IAtacable atacable, int danio){
        // Arrange
        final int RANGO_ATAQUE = 1;
        final int DISTANCIA_ATAQUE = 1;

        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacado.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE);

        AtacanteParaPruebas atacante = new AtacanteParaPruebas(posicionAtacante, RANGO_ATAQUE, danio);
        return atacante;
    }

    private Castillo crearCastilloDaniado(int danioEsperado){

        Castillo castillo = new Castillo(Mockito.mock(Posicion.class), Mockito.mock(IUnidadesCastilloFabrica.class), Mockito.mock(IEstrategiaAtaque.class));
        int vidaInicialCastillo = castillo.getVida();

        AtacanteParaPruebas atacanteAuxiliar = crearAtacante(castillo, danioEsperado);
        atacanteAuxiliar.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();

        int danioProducido = vidaInicialCastillo - vidaFinalCastillo;
        assert danioProducido == danioEsperado;

        return castillo;
    }

    @Test
    public void iniciarReparacion_CastilloConDanio50_Recupera15DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 50;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 15;

        // Act
        aldeano.iniciarReparacion(castillo);
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }

    @Test
    public void reparar_DosVecesCastilloConDanio50_CastilloRecupera30DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 50;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 30;

        // Act
        aldeano.iniciarReparacion(castillo);
        aldeano.trabajar();
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }

    @Test
    public void reparar_TresVecesCastilloConDanio50_CastilloRecupera45DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 50;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 45;

        // Act
        aldeano.iniciarReparacion(castillo);
        aldeano.trabajar();
        aldeano.trabajar();
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }

    @Test
    public void iniciarReparacion_UnaVezCastilloConDanio5_Recupera5DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 5;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 5;

        // Act
        aldeano.iniciarReparacion(castillo);
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }

    @Test
    public void reparar_DosVecesCastilloConDanio10_Recupera10DeVida(){

        // Arrange
        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 10;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 10;

        // Act
        aldeano.iniciarReparacion(castillo);
        aldeano.trabajar();
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }


    @Test(expected = OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion.class)
    public void iniciarReparacion_DosVecesConElMismoAldeanoCastilloConDanio150_LanzaExcepcion(){

        Aldeano aldeano = this.crearAldeano();

        final int DANIO = 150;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 30;

        // Act
        aldeano.iniciarReparacion(castillo);
        aldeano.iniciarReparacion(castillo);

    }

    @Test
    public void iniciarReparacion_DosVecesConDistintosAldeanosCastilloConDanio150_CastilloRecupera15DeVida(){

        Aldeano aldeano1 = this.crearAldeano();
        Aldeano aldeano2 = this.crearAldeano();

        final int DANIO = 150;
        Castillo castillo = this.crearCastilloDaniado(DANIO);
        int vidaCastilloDaniado = castillo.getVida();

        final int vidaRecuperadaEsperada = 15;

        // Act
        aldeano1.iniciarReparacion(castillo);
        aldeano2.iniciarReparacion(castillo);
        int vidaCastilloReparado = castillo.getVida();

        int vidaRecuperada = vidaCastilloReparado - vidaCastilloDaniado;

        // Assert
        Assert.assertEquals(vidaRecuperadaEsperada, vidaRecuperada);

    }

}
