package atenea.fiuba.algoIII.ageoOfEmpires.unitTests;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Mapa;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionCuadrado;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionDeUnCasillero;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DistanciaEntrePosicionesTest {
    private Mapa mapa = new Mapa(20,30);

    @Test
    public void testDistanciaEntrePosicionesContiguasEsUno(){
        Posicion pos_1 = new PosicionDeUnCasillero(mapa,5,5);
        Posicion pos_2 = new PosicionDeUnCasillero(mapa,5,6);

        int dist = pos_1.distanciaA(pos_2);

        assertEquals(1, dist);
    }

    @Test
    public void testDistanciaEntrePosicionDeUnCasilleroYPosicionDeVariosCasillerosDevuelveLaMenorDistancia(){
        //  Compara la distancia entre todos los casilleros y devuelve la menor
        Posicion pos_1 = new PosicionDeUnCasillero(mapa,5,5);
        Posicion pos_2 = new PosicionCuadrado(3,13,7,10);

        int dist = pos_1.distanciaA(pos_2);

        assertEquals(5, dist);
    }
}
