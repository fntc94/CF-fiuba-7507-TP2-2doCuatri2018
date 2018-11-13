package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MapaPruebasDeTamanioTest {

    //Tamanio del Mapa
    int alto = 20;
    int ancho = 30;

    @Test
    public void testCrearMapaConDimensionesPositivasNoLanzaException(){
        Mapa mapa = new Mapa(alto, ancho);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearMapaConDimensionesCeroSeLanzaException(){
        thrown.expect(DimensionDeMapaNoPuedeSerCeroException.class);
        Mapa mapa = new Mapa(0,0);
    }

    @Test
    public void testCrearMapaConAlturaCeroLanzaException(){
        thrown.expect(DimensionDeMapaNoPuedeSerCeroException.class);
        Mapa mapa = new Mapa(0,30);
    }

    @Test
    public void testCrearMapaConAnchoCeroLanzaException(){
        thrown.expect(DimensionDeMapaNoPuedeSerCeroException.class);
        Mapa mapa = new Mapa(25,0);
    }

    @Test
    public void testAlCrearMapaConDimensionesPositivasEstasSonConvertidasAPositivas(){
        Mapa mapa = new Mapa(alto*(-1), ancho*(-1));

        assertEquals(alto, mapa.getAlto());
        assertEquals(ancho, mapa.getAncho());
    }

}
