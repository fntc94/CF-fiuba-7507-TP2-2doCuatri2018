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

        //En la posicion 0 esta el alto y en la posicion 1 el ancho del mapa
        int dimensiones[] = mapa.getDimensiones();

        assertEquals(alto, dimensiones[0]);
        assertEquals(ancho, dimensiones[1]);
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

        int dimensiones[] = mapa.getDimensiones();

        assertEquals(alto, dimensiones[0]);
        assertEquals(ancho, dimensiones[1]);
    }

}
