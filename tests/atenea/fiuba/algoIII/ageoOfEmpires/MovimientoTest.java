package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovimientoTest {

    private Mapa mapa = new Mapa(20,30);

    private Posicion obtenerPosicion(){
        Posicion pos = new PosicionDeUnCasillero(mapa,5,5);

        return pos;
    }


    @Test
    public void testMovimientoHaciaArribaCorrePosicionHaciaArriba(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Arriba());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,5,6)));
    }

    @Test
    public void testMovimientoHaciaAbajoCorrePosicionHaciaAbajo(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Abajo());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,5,4)));
    }

    @Test
    public void testMovimientoHaciaDerechaCorrePosicionHaciaDerecha(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Derecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,6,5)));
    }

    @Test
    public void testMovimientoHaciaIzquierdaCorrePosicionHaciaIzquierda(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Izquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,4,5)));
    }

    @Test
    public void testMovimientoHaciaArribaDerCorrePosHaciaEsquinaSupDerecha(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new ArribaDerecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,6,6)));
    }

    @Test
    public void testMovimientoHaciaArribaIzqCorrePosHaciaEsquinaSupIzquierda(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new ArribaIzquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,4,6)));
    }

    @Test
    public void testMovimientoHaciaAbajoDerCorrePosHaciaEsquinaInfDerecha(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new AbajoDerecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,6,4)));
    }

    @Test
    public void testMovimientoHaciaAbajoIzqCorrePosHaciaEsquinaInfIzquierda(){
        Posicion pos = obtenerPosicion();
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new AbajoIzquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(mapa,4,4)));
    }

    @Test
    public void testPosicionCambiaAlDesplazarse(){
        //Si no se superpone con la posicion anterior entonces se movio
        Mapa mapa = new Mapa(20,30);
        Posicion pos = new PosicionDeUnCasillero(mapa,30,20);

        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Izquierda());

        Posicion pos_desplazada = movimiento.calcularPosSiguiente(pos);

        assertEquals(false, pos.seSuperponeCon(pos_desplazada));
    }

    @Test
    public void testTratarDeMoverseFueraDelMapaHaciaLaDerechaNoCambiaLaPosicion(){
        Mapa mapa = new Mapa(20,30);
        Posicion pos = new PosicionDeUnCasillero(mapa,20,30);

        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Derecha());

        Posicion pos_desplazada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos.seSuperponeCon(pos_desplazada));
    }

    @Test
    public void testTratarDeMoverseFueraDelMapaHaciaLaIzquierdaNoCambiaLaPosicion(){
        Mapa mapa = new Mapa(20,30);
        Posicion pos = new PosicionDeUnCasillero(mapa,0,0);

        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Izquierda());

        Posicion pos_desplazada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos.seSuperponeCon(pos_desplazada));
    }
}
