package atenea.fiuba.algoIII.ageoOfEmpires;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovimientoDeUnidadPorMapaTest {

    // En estas primeras pruebas se verifica que estando en alguna esquina no pueda seguir avanzando
    // Por ejemplo si estoy en la esquina superior derecha no podria moverme para arriba o derecha
    @Test
    public void testMoverUnidadHastaOrillaDelMapaYTratarDeSeguirNoCambiaDePosicion(){
        Mapa mapa = new Mapa(20,30);

        Posicion pos = new PosicionDeUnCasillero(26,18);
        pos.setMapa(mapa);

        Unidad aldeano = new Aldeano(pos, new EdificiosEnConstruccionFabrica());
        mapa.posicionar(aldeano);

        // Muevo aldeano a la derecha hasta la posicion x = 29
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(29,18)));

        // Al querer moverse mas alla del borde se queda en la misma posicion
        aldeano.mover(new Derecha());

        // Esta en el borde
        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(30,18)));

        // Si se quiere mover mas a la derecha aldeano se queda en el mismo lugar
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(30,18)));

        // Vuelvo un paso para atras y ya no estoy mas en el bode
        aldeano.mover(new Izquierda());
        assertEquals(false, aldeano.estaEnPosicion(new PosicionDeUnCasillero(30,18)));

    }

    @Test
    public void testUnidadNoCambiaDePosicionSiSequiereMoverParaArribaODerechaEstandoEnEsquinaSupDerecha(){
        Mapa mapa = new Mapa(20,30);

        Posicion posEsquina = new PosicionDeUnCasillero(30,20);
        Posicion pos = new PosicionDeUnCasillero(30,20);
        pos.setMapa(mapa);

        Unidad aldeano = new Aldeano(pos, new EdificiosEnConstruccionFabrica());
        mapa.posicionar(aldeano);

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        //Me muevo para arriba y no cambia de posicion
        aldeano.mover(new Arriba());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Me muevo para la derecha y no cambia de posicion
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Si me muevo para abajo/izquierda si puedo
        aldeano.mover(new Abajo());

        assertEquals(false, aldeano.estaEnPosicion(posEsquina));
    }

    @Test
    public void testUnidadNoCambiaDePosicionSiSequiereMoverParaArribaOIzquierdaEstandoEnEsquinaSupIzquierda(){
        Mapa mapa = new Mapa(20,30);

        Posicion posEsquina = new PosicionDeUnCasillero(0,20);
        Posicion pos = new PosicionDeUnCasillero(0,20);
        pos.setMapa(mapa);

        Unidad aldeano = new Aldeano(pos, new EdificiosEnConstruccionFabrica());
        mapa.posicionar(aldeano);

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        //Me muevo para arriba y no cambia de posicion
        aldeano.mover(new Arriba());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Me muevo para la Izquierda y no cambia de posicion
        aldeano.mover(new Izquierda());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Si me muevo para abajo/Derecha si puedo
        aldeano.mover(new Derecha());

        assertEquals(false, aldeano.estaEnPosicion(posEsquina));
    }

    @Test
    public void testUnidadNoCambiaDePosicionSiSequiereMoverParaAbajoOIzquierdaEstandoEnEsquinaInferiorIzquierda(){
        Mapa mapa = new Mapa(20,30);

        Posicion posEsquina = new PosicionDeUnCasillero(0,0);
        Posicion pos = new PosicionDeUnCasillero(0,0);
        pos.setMapa(mapa);

        Unidad aldeano = new Aldeano(pos, new EdificiosEnConstruccionFabrica());
        mapa.posicionar(aldeano);

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        //Me muevo para abajo y no cambia de posicion
        aldeano.mover(new Abajo());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Me muevo para la Izquierda y no cambia de posicion
        aldeano.mover(new Izquierda());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Si me muevo para abajo/Derecha si puedo
        aldeano.mover(new Derecha());

        assertEquals(false, aldeano.estaEnPosicion(posEsquina));
    }

    @Test
    public void testUnidadNoCambiaDePosicionSiSequiereMoverParaAbajoODerechaEstandoEnEsquinaInferiorDerecha(){
        Mapa mapa = new Mapa(20,30);

        Posicion posEsquina = new PosicionDeUnCasillero(30,0);
        Posicion pos = new PosicionDeUnCasillero(30,0);
        pos.setMapa(mapa);

        Unidad aldeano = new Aldeano(pos, new EdificiosEnConstruccionFabrica());
        mapa.posicionar(aldeano);

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        //Me muevo para abajo y no cambia de posicion
        aldeano.mover(new Abajo());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Me muevo para la derecha y no cambia de posicion
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(posEsquina));

        // Si me muevo para abajo/Derecha si puedo
        aldeano.mover(new Izquierda());

        assertEquals(false, aldeano.estaEnPosicion(posEsquina));
    }

    // Fin de pruebas en las esquinas
}
