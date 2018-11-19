package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EspadachinTest {

    @Test
    public void atacar_OtroEspadachinADistancia1_LeProduceDanio25(){

        // Arrange

        int DISTANCIA_ATAQUE = 1;
        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin atacante = new Espadachin(posicionAtacante);
        Espadachin atacado = new Espadachin(posicionAtacado);

        int vidaInicialAtacado = atacado.getVida();
        int danioEsperado = 25;

        // Act
        atacante.atacar(atacado);
        int vidaFinalAtacado = atacado.getVida();
        int danioProducido = vidaInicialAtacado - vidaFinalAtacado;

       // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ArqueroADistancia1_LeProduceDanio25(){

        // Arrange
        int vidaEspadachin = 100;
        int vidaArquero = 75;

        int DISTANCIA_ATAQUE = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArquero = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArquero)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Arquero arquero = new Arquero(posicionArquero);

        int vidaInicialArquero = arquero.getVida();
        int danioEsperado = 25;

        // Act
        espadachin.atacar(arquero);
        int vidaFinalArquero = arquero.getVida();
        int danioProducido = vidaInicialArquero - vidaFinalArquero;


        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ArmaDeAsedioADistancia1_LeProduceDanio25(){

        // Arrange
        int DISTANCIA_ATAQUE = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArmaDeAsedio = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArmaDeAsedio)).thenReturn(DISTANCIA_ATAQUE);


        Espadachin espadachin = new Espadachin(posicionEspadachin);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        int vidaInicialArmaDeAsedio = armaDeAsedio.getVida();
        int danioEsperado = 25;

        // Act
        espadachin.atacar(armaDeAsedio);
        int vidaFinalArmaDeAsedio = armaDeAsedio.getVida();
        int danioObtenido = vidaInicialArmaDeAsedio - vidaFinalArmaDeAsedio;

        // Assert
        Assert.assertEquals(danioEsperado, danioObtenido);

    }

    @Test
    public void atacar_AldeanoADistancia1_LeProduceDanio25(){

        // Arrange
        int DISTANCIA_ATAQUE = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Aldeano aldeano = new Aldeano(posicionAldeano, Mockito.mock(EdificiosEnConstruccionFabrica.class));

        int vidaInicialAldeano = aldeano.getVida();
        int danioEsperado = 25;

        // Act
        espadachin.atacar(aldeano);
        int vidaFinalAldeano = aldeano.getVida();
        int danioProducido = vidaInicialAldeano - vidaFinalAldeano;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_OtroEspadachinADistancia2_LanzaExcepcion(){

        // Arrange
        int DISTANCIA_ATAQUE = 2;

        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin atacante = new Espadachin(posicionAtacante);
        Espadachin atacado = new Espadachin(posicionAtacado);

        // Act
        atacante.atacar(atacado);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_ArqueroADistancia2_LanzaExcepcion(){

        // Arrange
        int vidaEspadachin = 100;
        int vidaArquero = 75;

        int DISTANCIA_ATAQUE = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArquero = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArquero)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Arquero arquero = new Arquero(posicionArquero);

        // Act
        espadachin.atacar(arquero);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_ArmaDeAsedioADistancia2_LanzaExcepcion(){

        // Arrange
        int DISTANCIA_ATAQUE = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArmaDeAsedio = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArmaDeAsedio)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin espadachin = new Espadachin(posicionEspadachin);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        int vidaInicialArmaDeAsedio = armaDeAsedio.getVida();
        int danioEsperado = 25;

        // Act
        espadachin.atacar(armaDeAsedio);
        int vidaFinalArmaDeAsedio = armaDeAsedio.getVida();
        int danioObtenido = vidaInicialArmaDeAsedio - vidaFinalArmaDeAsedio;

        // Assert
        Assert.assertEquals(danioEsperado, danioObtenido);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_AldeanoADistancia2_LanzaException(){

        // Arrange
        int DISTANCIA_ATAQUE = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_ATAQUE);

        Espadachin espadachin = new Espadachin(posicionEspadachin);
        Aldeano aldeano = new Aldeano(posicionAldeano, Mockito.mock(EdificiosEnConstruccionFabrica.class));

        // Act
        espadachin.atacar(aldeano);

    }

//    @Test
//    public void atacar_AOtroEspadachinConVida20_LaVidaDelAtacadoEsCeroLuegoDelAtaque(){
//
//        // Arrange
//        int vidaMaximaEspadachin = 100;
//        int vidaInicialAtacante =  vidaMaximaEspadachin;
//        int vidaInicialAtacado = 20;
//
//        Espadachin atacante = new Espadachin(vidaMaximaEspadachin);
//        Espadachin atacado = new Espadachin(vidaMaximaEspadachin, vidaInicialAtacado);
//
//        int vidaEsperadaLuegoDelAtaque = 0;
//
//        // Act
//        atacante.atacar(atacado);
//        int vidaObtenidaLuegoDelAtaque = atacado.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);
//
//    }
//
//    @Test
//    public void atacar_AUnArqueroConVida10_LaVidaDelArqueroEsCeroLuegoDelAtaque(){
//
//        // Arrange
//        int vidaEspadachin = 100;
//        Espadachin espadachin = new Espadachin(vidaEspadachin);
//
//        int vidaArquero = 10;
//        Arquero arquero = new Arquero(vidaArquero);
//
//        int vidaEsperadaLuegoDelAtaque = 0;
//
//        // Act
//        espadachin.atacar(arquero);
//        int vidaObtenidaLuegoDelAtaque = arquero.getVida();
//
//        // Assert
//        Assert.assertEquals(vidaEsperadaLuegoDelAtaque, vidaObtenidaLuegoDelAtaque);
//
//    }

    @Test
    public void atacar_APlazaCentral_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        PlazaCentral plazaCentral = new PlazaCentral(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialPlazaCentral = plazaCentral.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(plazaCentral);
        int vidaFinalPlazaCentral = plazaCentral.getVida();
        int danioProducido = vidaInicialPlazaCentral - vidaFinalPlazaCentral;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ACuartel_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Cuartel cuartel = new Cuartel(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCuartel = cuartel.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(cuartel);
        int vidaFinalCuartel = cuartel.getVida();
        int danioProducido = vidaInicialCuartel- vidaFinalCuartel;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test
    public void atacar_ACastillo_LeProduceDanio15(){

        // Arrange
        Espadachin espadachin = new Espadachin(Mockito.mock(Posicion.class));
        Castillo castillo = new Castillo(Mockito.mock(UnidadesFabrica.class));

        int vidaInicialCastillo = castillo.getVida();
        int danioEsperado = 15;

        // Act
        espadachin.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();
        int danioProducido = vidaInicialCastillo- vidaFinalCastillo;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }


}