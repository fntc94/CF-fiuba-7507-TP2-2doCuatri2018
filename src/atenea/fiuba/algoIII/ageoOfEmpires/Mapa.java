package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

    private static final int ANCHO_MIN = 30;
    private static final int ANCHO_MAX = 100;
    private static final int ALTO_MIN = 20;
    private static final int ALTO_MAX = 50;

    private int _alto;
    private int _ancho;

    private Map<Posicion, IPosicionable> _posicionables = new HashMap<>();

    public Mapa(int alto, int ancho) {

        if(!sonDimensionesValidas(alto, ancho)){

            String mensaje = String.format("Ancho debe estar entre %d y %d. Alto entre %d y %d", ANCHO_MIN, ANCHO_MAX, ALTO_MIN, ALTO_MAX);
            throw new DimensionDelMapaInvalidaException(mensaje);
        }

        this._alto = alto;
        this._ancho = ancho;

    }

    public boolean estaVacio() {
        return this._posicionables.isEmpty();
    }

    public void posicionar(IPosicionable posicionable) {

        Posicion posicion = posicionable.getPosicion();

        if(!posicionEstaDentroDelMapa(posicion)){
            throw new NoPuedeColocarPosicionablesFueraDelMapaException();
        }

        if(!posicionEstaLibre(posicion)){
            throw new NoPuedeColocar2IPosicionablesEnLaMismaPosicionException();
        }

        this._posicionables.put(posicion, posicionable);
    }

    private boolean sonDimensionesValidas(int alto, int ancho){
        return ((alto >= ALTO_MIN) && (alto <= ALTO_MAX) && (ancho >= ANCHO_MIN) && (ancho <= ANCHO_MAX));
    }

    private boolean posicionEstaDentroDelMapa(Posicion posicion) {

        for(Casillero casillero : posicion.getCasillerosOcupados()){

            if(!estaDentroDelMapa(casillero)){
                return false;
            }
        }


        return true;
    }

    private boolean posicionEstaLibre(Posicion posicion) {

        for(Posicion otraPosicion : this._posicionables.keySet()){

            if(posicion.seSuperponeCon(otraPosicion)){
                return false;
            }
        }

        return true;
    }

    private boolean estaDentroDelMapa(Casillero casillero){

        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordendadaEnY();

        boolean esValidoEnX = (x <= this._ancho) && (x > 0);
        boolean esValidoEnY = (y <= this._alto) && (y > 0);

        return (esValidoEnX && esValidoEnY);
    }

}
