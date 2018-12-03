package atenea.fiuba.algoIII.ageoOfEmpires.integrationTests;

import modelo.Unidad;
import modelo.edificios.Cuartel;
import modelo.Edificio;
import modelo.edificios.EstrategiaAtaqueArmaDeAsedio;
import modelo.movimiento.*;
import modelo.posicion.Mapa;
import modelo.posicion.Posicion;
import modelo.posicion.PosicionCuadrado;
import modelo.posicion.PosicionDeUnCasillero;
import modelo.unidades.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovimientoDeUnidadPorMapaTest {

    private Mapa mapa = new Mapa(20,30);

    // En estas primeras pruebas se verifica que estando en alguna esquina no pueda seguir avanzando
    // Por ejemplo si estoy en la esquina superior derecha no podria moverme para arriba o derecha

    @Test
    public void testMoverUnidadHastaOrillaDelMapaYTratarDeSeguirNoCambiaDePosicion(){

        Posicion pos = new PosicionDeUnCasillero(mapa,26,18);

        Unidad aldeano = new Aldeano(pos);
        mapa.posicionar(aldeano);

        // Muevo aldeano a la derecha hasta la posicion x = 29
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,29,18)));

        // Al querer moverse mas alla del borde se queda en la misma posicion
        aldeano.mover(new Derecha());

        // Esta en el borde
        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,30,18)));

        // Si se quiere mover mas a la derecha aldeano se queda en el mismo lugar
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,30,18)));

        // Vuelvo un paso para atras y ya no estoy mas en el bode
        aldeano.mover(new Izquierda());
        assertEquals(false, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,30,18)));

    }

    @Test
    public void testUnidadNoCambiaDePosicionSiSequiereMoverParaArribaODerechaEstandoEnEsquinaSupDerecha(){

        Posicion posEsquina = new PosicionDeUnCasillero(mapa,30,20);
        Posicion pos = new PosicionDeUnCasillero(mapa,30,20);

        Unidad aldeano = new Aldeano(pos);
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

        Posicion posEsquina = new PosicionDeUnCasillero(mapa,0,20);
        Posicion pos = new PosicionDeUnCasillero(mapa,0,20);

        Unidad aldeano = new Aldeano(pos);
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

        Posicion posEsquina = new PosicionDeUnCasillero(mapa,0,0);
        Posicion pos = new PosicionDeUnCasillero(mapa,0,0);

        Unidad aldeano = new Aldeano(pos);
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

        Posicion posEsquina = new PosicionDeUnCasillero(mapa,30,0);
        Posicion pos = new PosicionDeUnCasillero(mapa,30,0);

        Unidad aldeano = new Aldeano(pos);
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

    // Pruebo moverme en diagonal
    @Test
    public void testArqueroSeMueveEnDiagonalHastaLlegarALaEsquinaInferiorIzquierdaYNoAvanzaMasDeAhi(){
        Posicion posEsquina = new PosicionDeUnCasillero(mapa, 0,0);
        Posicion posArquero = new PosicionDeUnCasillero(mapa, 5,5);

        Unidad arquero = new Arquero(posArquero, new EstrategiaAtaqueArquero());

        // Estoy en la posicion 5,5
        assertEquals(true, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,5)));

        //Me muevo 3 veces y cambio de posicion
        arquero.mover(new IzquierdaAbajo());
        arquero.mover(new IzquierdaAbajo());
        arquero.mover(new IzquierdaAbajo());

        // Ya no estoy en la posicion inicial, ahora estoy en (2,2)
        assertEquals(false, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,5)));
        assertEquals(true, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,2,2)));

        // Me muevo 2 veces mas y estoy en la esquina
        arquero.mover(new IzquierdaAbajo());
        arquero.mover(new IzquierdaAbajo());

        assertEquals(true, arquero.estaEnPosicion(posEsquina));
    }

    @Test
    public void testSiHayOtraUnidadEnElCaminoAlAvanzarNoCambioDePosicionHastaQueSalgaDelCamino(){
        Posicion posArquero = new PosicionDeUnCasillero(mapa,7,7);
        Posicion posArmaDeAsedio = new PosicionDeUnCasillero(mapa,5,7);

        Unidad arquero = new Arquero(posArquero, new EstrategiaAtaqueArquero());
        Unidad armaDeAsedio = new ArmaDeAsedio(posArmaDeAsedio, new EstrategiaAtaqueArmaDeAsedio());

        mapa.posicionar(arquero);
        mapa.posicionar(armaDeAsedio);

        // Me muevo una vez a la izquierda y estoy al lado de arma de asedio
        arquero.mover(new Izquierda());

        assertEquals(true, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa, 6,7)));

        // Quiero seguir avanzando a la izquierda pero no puedo
        arquero.mover(new Izquierda());
        arquero.mover(new Izquierda());

        assertEquals(false, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,7)));

        // Arma de asedio se mueve para arriba y arquero puede pasar
        armaDeAsedio.mover(new Arriba());
        arquero.mover(new Izquierda());

        assertEquals(true, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,7)));
        arquero.mover(new Izquierda());
        assertEquals(true, arquero.estaEnPosicion(new PosicionDeUnCasillero(mapa,4,7)));
    }

    @Test
    public void testEspadachinPuedeMueverseEnLas8DireccionesPosibles(){
        Posicion posEspadachin = new PosicionDeUnCasillero(mapa,5,5);

        Unidad espadachin = new Espadachin(posEspadachin, new EstrategiaAtaqueEspadachin());

        mapa.posicionar(espadachin);

        espadachin.mover(new Arriba());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,6)));

        espadachin.mover(new Derecha());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,6,6)));

        espadachin.mover(new Abajo());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,6,5)));

        espadachin.mover(new Izquierda());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,5)));

        espadachin.mover(new DerechaArriba());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,6,6)));

        espadachin.mover(new IzquierdaArriba());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,7)));

        espadachin.mover(new IzquierdaAbajo());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,4,6)));

        espadachin.mover(new DerechaAbajo());
        assertEquals(true, espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,5)));
    }

    @Test
    public void testNoSePuedeCaminarATravezDeUnEdificio(){
        Posicion posCuartel = new PosicionCuadrado(5,5,6,4);

        // Posiciono 1 aldeano y un espadachin frente al cuartel.
        //El espadachin esta a la derecha del aldeano
        Posicion posAldeano = new PosicionDeUnCasillero(mapa,5,3);
        Posicion posEspadachin = new PosicionDeUnCasillero(mapa,6,3);

        Unidad aldeano = new Aldeano(posAldeano);
        Unidad espadachin = new Espadachin(posEspadachin, new EstrategiaAtaqueEspadachin());
        Edificio cuartel = new Cuartel(posCuartel,new UnidadesFabrica());

        mapa.posicionar(aldeano);
        mapa.posicionar(espadachin);
        mapa.posicionar(cuartel);


        // Siquiere ir para arriba alguno de los 2 no cambia la posoicion
        aldeano.mover(new Arriba());
        espadachin.mover(new Arriba());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,3)));
        assertEquals(true,espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,6,3)));

        // Si me muevo para el costado y subo si puedo
        aldeano.mover(new Izquierda());
        aldeano.mover(new Arriba());

        espadachin.mover(new Derecha());
        espadachin.mover(new Arriba());

        //Posicion anterior
        assertEquals(false, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,3)));
        assertEquals(false,espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,6,3)));
        //Posicion actual(Uno en cada costado del castillo)
        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,4,4)));
        assertEquals(true,espadachin.estaEnPosicion(new PosicionDeUnCasillero(mapa,7,4)));
    }

    @Test
    public void testAldeanoAcorraladoPorEspadachinesEnOrillaDelMapaNoPuedeMoverse(){
        Posicion posAldeano = new PosicionDeUnCasillero(mapa,5,0);
        Posicion posEspadachin1 = new PosicionDeUnCasillero(mapa,4,0);
        Posicion posEspadachin2 = new PosicionDeUnCasillero(mapa,4,1);
        Posicion posEspadachin3 = new PosicionDeUnCasillero(mapa,5,1);
        Posicion posEspadachin4 = new PosicionDeUnCasillero(mapa,6,1);
        Posicion posEspadachin5 = new PosicionDeUnCasillero(mapa,6,0);

        Unidad aldeano = new Aldeano(posAldeano);
        Unidad espadachin1 = new Espadachin(posEspadachin1, new EstrategiaAtaqueEspadachin());
        Unidad espadachin2 = new Espadachin(posEspadachin2, new EstrategiaAtaqueEspadachin());
        Unidad espadachin3 = new Espadachin(posEspadachin3, new EstrategiaAtaqueEspadachin());
        Unidad espadachin4 = new Espadachin(posEspadachin4, new EstrategiaAtaqueEspadachin());
        Unidad espadachin5 = new Espadachin(posEspadachin5, new EstrategiaAtaqueEspadachin());

        mapa.posicionar(aldeano);
        mapa.posicionar(espadachin1);
        mapa.posicionar(espadachin2);
        mapa.posicionar(espadachin3);
        mapa.posicionar(espadachin4);
        mapa.posicionar(espadachin5);

        // Aldeano al tratar de moverse se queda en la misma posicion
        aldeano.mover(new Izquierda());
        aldeano.mover(new Derecha());
        aldeano.mover(new Arriba());
        aldeano.mover(new Abajo());
        aldeano.mover(new IzquierdaArriba());
        aldeano.mover(new DerechaArriba());
        aldeano.mover(new IzquierdaAbajo());
        aldeano.mover(new DerechaAbajo());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,5,0)));

        // Si se corre el espadachin de la izquierda si me puedo mover
        espadachin5.mover(new Derecha());
        espadachin5.mover(new Arriba());

        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());
        aldeano.mover(new Derecha());

        assertEquals(true, aldeano.estaEnPosicion(new PosicionDeUnCasillero(mapa,8,0)));
    }
}
