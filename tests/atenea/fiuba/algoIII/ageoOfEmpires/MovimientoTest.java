package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovimientoTest {

    @Test
    public void testMovimientoHaciaArribaCorrePosicionHaciaArriba(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Arriba());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(5,6)));
    }

    @Test
    public void testMovimientoHaciaAbajoCorrePosicionHaciaAbajo(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Abajo());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(5,4)));
    }

    @Test
    public void testMovimientoHaciaDerechaCorrePosicionHaciaDerecha(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Derecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(6,5)));
    }

    @Test
    public void testMovimientoHaciaIzquierdaCorrePosicionHaciaIzquierda(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new Izquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(4,5)));
    }

    @Test
    public void testMovimientoHaciaArribaDerCorrePosHaciaEsquinaSupDerecha(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new ArribaDerecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(6,6)));
    }

    @Test
    public void testMovimientoHaciaArribaIzqCorrePosHaciaEsquinaSupIzquierda(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new ArribaIzquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(4,6)));
    }

    @Test
    public void testMovimientoHaciaAbajoDerCorrePosHaciaEsquinaInfDerecha(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new AbajoDerecha());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(6,4)));
    }

    @Test
    public void testMovimientoHaciaAbajoIzqCorrePosHaciaEsquinaInfIzquierda(){
        Posicion pos = new PosicionDeUnCasillero(5,5);
        Movimiento movimiento = new Movimiento();
        movimiento.hacia(new AbajoIzquierda());

        Posicion pos_incrementada = movimiento.calcularPosSiguiente(pos);

        assertEquals(true, pos_incrementada.seSuperponeCon(new PosicionDeUnCasillero(4,4)));
    }
}
