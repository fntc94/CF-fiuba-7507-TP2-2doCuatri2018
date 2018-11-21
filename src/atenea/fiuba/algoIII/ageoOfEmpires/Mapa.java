package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.Collection;

public class Mapa {

    private static final int ANCHO_MIN = 30;
    private static final int ANCHO_MAX = 100;
    private static final int ALTO_MIN = 20;
    private static final int ALTO_MAX = 50;

    private int _alto;
    private int _ancho;

    private Collection<IPosicionable> _posicionables = new ArrayList<>();

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

        if(!posicion.estaDentroDelArea(this._alto,this._ancho)){
            throw new NoPuedeColocarPosicionablesFueraDelMapaException();
        }

        if(!posicionEstaLibre(posicion)){
            throw new NoPuedeColocar2IPosicionablesEnLaMismaPosicionException();
        }

        this._posicionables.add(posicionable);
    }

    private boolean sonDimensionesValidas(int alto, int ancho){
        return ((alto >= ALTO_MIN) && (alto <= ALTO_MAX) && (ancho >= ANCHO_MIN) && (ancho <= ANCHO_MAX));
    }

    private boolean posicionEstaLibre(Posicion posicion) {

        for(IPosicionable otraPosicion : this._posicionables){

            if(posicion.seSuperponeCon(otraPosicion.getPosicion())){
                return false;
            }
        }

        return true;
    }
}
