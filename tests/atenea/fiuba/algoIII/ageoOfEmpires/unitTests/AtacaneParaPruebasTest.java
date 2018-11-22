package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosEnConstruccionFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IUnidadesPlazaCentralFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.AtacanteParaPruebas;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AtacaneParaPruebasTest {


    @Test
    public void atacar_AldeanoADistancia1_ProduceDanioEsperado(){

        // Arrange
        final int DANIO = 10;
        final int RANGO_ATAQUE = 1;
        final int DISTANCIA_ATAQUE = 1;

        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacado.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE);

        AtacanteParaPruebas atacante = new AtacanteParaPruebas(posicionAtacante, RANGO_ATAQUE, DANIO);

        EdificiosEnConstruccionFabrica fabrica = Mockito.mock(EdificiosEnConstruccionFabrica.class);
        Aldeano aldeano = new Aldeano(posicionAtacado, fabrica);

        int vidaInicialAldeano = aldeano.getVida();

        // Act
        atacante.atacar(aldeano);
        int vidaFinalAldeano = aldeano.getVida();
        int danioProducido = vidaInicialAldeano - vidaFinalAldeano;


        // Assert
        Assert.assertEquals(DANIO, danioProducido);

    }

    @Test
    public void atacar_PlazaCentralADistancia1_ProduceDanioEsperado(){

        // Arrange
        final int DANIO = 10;
        final int RANGO_ATAQUE = 1;
        final int DISTANCIA_ATAQUE = 1;

        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacado.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE);

        AtacanteParaPruebas atacante = new AtacanteParaPruebas(posicionAtacante, RANGO_ATAQUE, DANIO);
        PlazaCentral plazaCentral = new PlazaCentral(posicionAtacado, Mockito.mock(IUnidadesPlazaCentralFabrica.class));

        int vidaInicialPlazaCentral = plazaCentral.getVida();

        // Act
        atacante.atacar(plazaCentral);
        int vidaFinalPlazaCentral = plazaCentral.getVida();
        int danioProducido = vidaInicialPlazaCentral - vidaFinalPlazaCentral;


        // Assert
        Assert.assertEquals(DANIO, danioProducido);

    }

}
