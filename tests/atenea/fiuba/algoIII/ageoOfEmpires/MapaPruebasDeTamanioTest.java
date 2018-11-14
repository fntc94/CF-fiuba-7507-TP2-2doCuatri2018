package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaPruebasDeTamanioTest {

    @Test
    public void testCrearMapaConAltoAnchoMinimoNoLanzaException(){
        Mapa mapa = new Mapa(20,30);
    }

    @Test
    public void testCrearMapaConAltoAnchoMaximoNoLanzaException(){
        Mapa mapa = new Mapa(50,100);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearMapaConDimensionesIgualACeroLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(0,0);
    }

    @Test
    public void testCrearMapaConAlturaCeroLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(0,30);
    }

    @Test
    public void testCrearMapaConAnchoCeroLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(25,0);
    }

    @Test
    public void testCrearMapaConDimensionesNegativasLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(20*(-1), 30*(-1));
    }

    @Test
    public void testCrearMapaConAlturaNegativaLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(20*(-1), 30);
    }

    @Test
    public void testCrearMapaConAnchoNegativoLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(20, 30*(-1));
    }

    @Test
    public void testCrearMapaConAltoMenorAlPermitidoLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(15, 30);
    }

    @Test
    public void testCrearMapaConAltoMayorAlPermitidoLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(60, 30);
    }

    @Test
    public void testCrearMapaConAnchoMenorAlPermitidoLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(20, 21);
    }

    @Test
    public void testCrearMapaConAnchoMayorAlPermitidoLanzaException(){
        thrown.expect(DimensionDelMapaInvalidaException.class);
        Mapa mapa = new Mapa(60, 110);
    }

}
