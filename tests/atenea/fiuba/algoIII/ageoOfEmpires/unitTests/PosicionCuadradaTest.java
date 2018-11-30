package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import junit.framework.Assert;
import modelo.posicion.Casillero;
import modelo.posicion.Limite;
import modelo.posicion.Posicion;
import modelo.posicion.PosicionCuadrado;
import org.junit.Test;

import java.util.List;

public class PosicionCuadradaTest {

    @Test
    public void test_limiteInferiorIzquierdo(){

        // Arrange
        Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(0,0), 3);
        Casillero inferiorIzquieroEsperado = new Casillero(0,0);

        // Act
        Casillero inferiorIzquierdoObtenido = posicion.getAbajoIzquierda();

        // Assert
        Assert.assertEquals(inferiorIzquieroEsperado, inferiorIzquierdoObtenido);
    }

    @Test
    public void construccion_ConLimiteInferiorIzquierdo(){

        // Arrange
        Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(0,0), 3);
        Casillero inferiorIzquieroEsperado = new Casillero(0,0);

        // Act
        List<Casillero> casilleros = posicion.getListaCasilleros();

        // Act

        Assert.assertTrue(casilleros.contains(new Casillero(0,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(0,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(0,2)));

        Assert.assertTrue(casilleros.contains(new Casillero(1,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(1,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(1,2)));

        Assert.assertTrue(casilleros.contains(new Casillero(2,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(2,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(2,2)));

        Assert.assertFalse(casilleros.contains(new Casillero(3,3)));
    }

    @Test
    public void construccion_ConLimiteInferiorIzquierdo_1(){

        // Arrange
        Posicion posicion = new PosicionCuadrado(Limite.SuperiorIzquierdo, new Casillero(2,0), 3);
        Casillero inferiorIzquieroEsperado = new Casillero(0,0);

        // Act
        List<Casillero> casilleros = posicion.getListaCasilleros();

        // Act
        Assert.assertTrue(casilleros.contains(new Casillero(2,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(2,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(2,2)));

        Assert.assertTrue(casilleros.contains(new Casillero(3,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(3,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(3,2)));

        Assert.assertTrue(casilleros.contains(new Casillero(4,0)));
        Assert.assertTrue(casilleros.contains(new Casillero(4,1)));
        Assert.assertTrue(casilleros.contains(new Casillero(4,2)));

        Assert.assertFalse(casilleros.contains(new Casillero(5,5)));
    }

//    @Test
//    public void construccion_ConLimiteInferiorDerecho(){
//
//        // Arrange
//        Posicion posicion = new PosicionCuadrado(2,0, Limite.InferiorDerecho, 3, 3);
//        Casillero inferiorIzquieroEsperado = new Casillero(0,0);
//
//        // Act
//        List<Casillero> casilleros = posicion.getListaCasilleros();
//
//        // Act
//        Assert.assertTrue(casilleros.contains(new Casillero(0,0)));
//        Assert.assertTrue(casilleros.contains(new Casillero(0,1)));
//        Assert.assertTrue(casilleros.contains(new Casillero(0,2)));
//
//        Assert.assertTrue(casilleros.contains(new Casillero(1,0)));
//        Assert.assertTrue(casilleros.contains(new Casillero(1,1)));
//        Assert.assertTrue(casilleros.contains(new Casillero(1,2)));
//
//        Assert.assertTrue(casilleros.contains(new Casillero(2,0)));
//        Assert.assertTrue(casilleros.contains(new Casillero(2,1)));
//        Assert.assertTrue(casilleros.contains(new Casillero(2,2)));
//
//        Assert.assertFalse(casilleros.contains(new Casillero(3,3)));
//    }


}
