package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.IDireccion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DireccionTest {
    private Mapa mapa = new Mapa(20,30);

    private Posicion obtenerPosicion(){
        Posicion pos = new PosicionDeUnCasillero(mapa, 5,5);

        return pos;
    }

    @Test
    public void testDireccionHaciaArribaIncrementaCoordenadaY(){
        IDireccion arriba = new Arriba();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,5,6);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionHaciaAbajoDecrementaCoordenadaY(){
        IDireccion arriba = new Abajo();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,5,4);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionHaciaDerechaIncrementaCoordenadaX(){
        IDireccion arriba = new Derecha();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,6,5);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionHaciaIzquierdaDecrementaCoordenadaX(){
        IDireccion arriba = new Izquierda();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,4,5);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireciconArribaDerechaIncrementaXeY(){
        IDireccion arriba = new ArribaDerecha();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,6,6);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionArribaIzquierdaDecrementaXeIncrementaY(){
        IDireccion arriba = new ArribaIzquierda();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,4,6);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionAbajoDerechaIncrementaXyDecrementaY(){
        IDireccion arriba = new AbajoDerecha();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,6,4);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }

    @Test
    public void testDireccionAbajoIzquierdaDecrementaXeY(){
        IDireccion arriba = new AbajoIzquierda();
        Posicion pos = obtenerPosicion();
        Posicion pos_esperada = new PosicionDeUnCasillero(mapa,4,4);

        Posicion posDesplazada = arriba.desplazarPos(pos);

        assertEquals(true, pos_esperada.seSuperponeCon(posDesplazada));
    }
}
