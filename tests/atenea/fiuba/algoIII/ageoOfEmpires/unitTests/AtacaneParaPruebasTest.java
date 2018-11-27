package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import modelo.edificios.EdificiosEnConstruccionFabrica;
import modelo.edificios.IUnidadesPlazaCentralFabrica;
import modelo.edificios.PlazaCentral;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.unidades.AtacanteParaPruebas;
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
        Aldeano aldeano = new Aldeano(posicionAtacado);

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
