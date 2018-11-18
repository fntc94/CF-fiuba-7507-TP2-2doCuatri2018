package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DireccionTest {

    @Test
    public void testDireccionHaciaArribaIncrementaCoordenadaY(){
        IDireccion arriba = new Arriba();
        Posicion pos_esperada = new PosicionDeUnCasillero(5,6);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionHaciaAbajoDecrementaCoordenadaY(){
        IDireccion arriba = new Abajo();
        Posicion pos_esperada = new PosicionDeUnCasillero(5,4);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionHaciaDerechaIncrementaCoordenadaX(){
        IDireccion arriba = new Derecha();
        Posicion pos_esperada = new PosicionDeUnCasillero(6,5);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionHaciaIzquierdaDecrementaCoordenadaX(){
        IDireccion arriba = new Izquierda();
        Posicion pos_esperada = new PosicionDeUnCasillero(4,5);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireciconArribaDerechaIncrementaXeY(){
        IDireccion arriba = new ArribaDerecha();
        Posicion pos_esperada = new PosicionDeUnCasillero(6,6);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionArribaIzquierdaDecrementaXeIncrementaY(){
        IDireccion arriba = new ArribaIzquierda();
        Posicion pos_esperada = new PosicionDeUnCasillero(4,6);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionAbajoDerechaIncrementaXyDecrementaY(){
        IDireccion arriba = new AbajoDerecha();
        Posicion pos_esperada = new PosicionDeUnCasillero(6,4);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }

    @Test
    public void testDireccionAbajoIzquierdaDecrementaXeY(){
        IDireccion arriba = new AbajoIzquierda();
        Posicion pos_esperada = new PosicionDeUnCasillero(4,4);

        Posicion pos = arriba.desplazarPos(new PosicionDeUnCasillero(5,5));

        assertEquals(true, pos_esperada.seSuperponeCon(pos));
    }
}
