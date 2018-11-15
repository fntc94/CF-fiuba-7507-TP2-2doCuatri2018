package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

    private static final int alto_max = 50;
    private static final int ancho_max = 100;
    private static final int alto_min = 20;
    private static final int ancho_min = 30;

    private int alto;
    private int ancho;

    private Map<Posicion, IPosicionable> listaPosicionables;

    public Mapa(int alto, int ancho) {
        if((alto < alto_min) || (alto >  alto_max) || (ancho < ancho_min) || (ancho > ancho_max))
            throw new DimensionDelMapaInvalidaException("Ancho debe estar entre 30 y 100. Alto entre 20 y 50");

        this.alto = alto;
        this.ancho = ancho;

        this.listaPosicionables = new HashMap<>();
    }

    public boolean estaVacio() {
        return this.listaPosicionables.isEmpty();
    }

    public void colocarPosicionable(Posicion posicion, IPosicionable posicionable) {
        if(!estaDentroDelMapa(posicion))
            throw new NoPuedeColocarPosicionablesFueraDelMapaException();

        if(!posicionLibre(posicion))
            throw new NoPuedeColocar2IPosicionablesEnLaMismaPosicionException();

        this.listaPosicionables.put(posicion, posicionable);
    }

    private boolean posicionLibre(Posicion posicion) {
        for(Posicion otraPosicion : this.listaPosicionables.keySet())
            if(posicion.seSuperponeCon(otraPosicion))
                return false;

        return true;
    }

    private boolean estaDentroDelMapa(Posicion posicion) {
        for(Casillero casillero : posicion.getCasillerosOcupados())
            if(!estaDentro(casillero))
                return false;

        return true;
    }

    private boolean estaDentro(Casillero casillero){

        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordendadaEnY();

        boolean esValidoEnX = (x <= this.ancho) && (x > 0);
        boolean esValidoEnY = (y <= this.alto) && (y > 0);

        return (esValidoEnX && esValidoEnY);
    }

}
