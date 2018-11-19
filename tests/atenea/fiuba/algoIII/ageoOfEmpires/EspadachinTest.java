package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EspadachinTest {

    @Test
    public void atacar_OtroEspadachinADistancia1_LeProduceDanio25(){

        // Arrange
        int vidaMaxima = 100;

        int DISTANCIA_ATAQUE_1 = 1;
        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE_1);

        Espadachin atacante = new Espadachin(vidaMaxima, posicionAtacante);
        Espadachin atacado = new Espadachin(vidaMaxima, posicionAtacado);

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

        int DISTANCIA_ATAQUE_1 = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArquero = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArquero)).thenReturn(DISTANCIA_ATAQUE_1);

        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        Arquero arquero = new Arquero(vidaArquero, posicionArquero);

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
        int vidaEspadachin = 100;
        int vidaArmaDeAsedio = 150;

        int DISTANCIA_ATAQUE_1 = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArmaDeAsedio = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArmaDeAsedio)).thenReturn(DISTANCIA_ATAQUE_1);


        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(vidaArmaDeAsedio, posicionArmaDeAsedio);

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
        int vidaEspadachin = 75;
        int vidaMaximaAldeano = 50;

        int DISTANCIA_ATAQUE_1 = 1;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_ATAQUE_1);

        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        Aldeano aldeano = new Aldeano(vidaMaximaAldeano, posicionAldeano, Mockito.mock(EdificiosEnConstruccionFabrica.class));

        int vidaInicialAldeano = aldeano.getVidaActual();
        int danioEsperado = 25;

        // Act
        espadachin.atacar(aldeano);
        int vidaFinalAldeano = aldeano.getVidaActual();
        int danioProducido = vidaInicialAldeano - vidaFinalAldeano;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_OtroEspadachinADistancia2_LanzaExcepcion(){

        // Arrange
        int vidaMaxima = 100;
        int DISTANCIA_ATAQUE_2 = 2;

        Posicion posicionAtacante = Mockito.mock(Posicion.class);
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionAtacado)).thenReturn(DISTANCIA_ATAQUE_2);

        Espadachin atacante = new Espadachin(vidaMaxima, posicionAtacante);
        Espadachin atacado = new Espadachin(vidaMaxima, posicionAtacado);

        // Act
        atacante.atacar(atacado);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_ArqueroADistancia2_LanzaExcepcion(){

        // Arrange
        int vidaEspadachin = 100;
        int vidaArquero = 75;

        int DISTANCIA_ATAQUE_2 = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArquero = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArquero)).thenReturn(DISTANCIA_ATAQUE_2);

        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        Arquero arquero = new Arquero(vidaArquero, posicionArquero);

        // Act
        espadachin.atacar(arquero);

    }

    @Test(expected = UnidadFueraDeRangoDeAtaqueExcepcion.class)
    public void atacar_ArmaDeAsedioADistancia2_LanzaExcepcion(){

        // Arrange
        int vidaEspadachin = 100;
        int vidaArmaDeAsedio = 150;

        int DISTANCIA_ATAQUE_2 = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionArmaDeAsedio = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionArmaDeAsedio)).thenReturn(DISTANCIA_ATAQUE_2);


        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(vidaArmaDeAsedio, posicionArmaDeAsedio);

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
        int vidaEspadachin = 75;
        int vidaMaximaAldeano = 50;

        int DISTANCIA_ATAQUE_2 = 2;
        Posicion posicionEspadachin = Mockito.mock(Posicion.class);
        Posicion posicionAldeano = Mockito.mock(Posicion.class);
        Mockito.when(posicionEspadachin.distanciaA(posicionAldeano)).thenReturn(DISTANCIA_ATAQUE_2);

        Espadachin espadachin = new Espadachin(vidaEspadachin, posicionEspadachin);
        Aldeano aldeano = new Aldeano(vidaMaximaAldeano, posicionAldeano, Mockito.mock(EdificiosEnConstruccionFabrica.class));

        int vidaInicialAldeano = aldeano.getVidaActual();
        int danioEsperado = 25;

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
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaPlazaCentral = 450;
        int vidaInicialPlazaCentral = 450;
        PlazaCentral plazaCentral = new PlazaCentral(vidaMaximaPlazaCentral, vidaInicialPlazaCentral, Mockito.mock(UnidadesFabrica.class));

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
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaCuartel = 250;
        int vidaInicialCuartel = 250;
        Cuartel cuartel = new Cuartel(vidaMaximaCuartel, vidaInicialCuartel, Mockito.mock(UnidadesFabrica.class));

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
        int vidaEspadachin = 100;
        Espadachin espadachin = new Espadachin(vidaEspadachin);

        int vidaMaximaCastillo = 1000;
        int vidaInicialCastillo = 1000;
        Castillo castillo = new Castillo(vidaMaximaCastillo, vidaInicialCastillo, Mockito.mock(UnidadesFabrica.class));

        int danioEsperado = 15;

        // Act
        espadachin.atacar(castillo);
        int vidaFinalCastillo = castillo.getVida();
        int danioProducido = vidaInicialCastillo- vidaFinalCastillo;

        // Assert
        Assert.assertEquals(danioEsperado, danioProducido);

    }


}