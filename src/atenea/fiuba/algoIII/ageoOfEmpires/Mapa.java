package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    private int alto;
    private int ancho;

    private Map<Posicion, IPosicionable> listaPosicionables;

    public Mapa(int alto, int ancho) {
        if(alto == 0 || ancho == 0) //Numero magico?
            throw new DimensionDeMapaNoPuedeSerCeroException();

        //Si me pasan negativos los hago positivo
        this.alto = Math.abs(alto);
        this.ancho = Math.abs(ancho);

        this.listaPosicionables = new HashMap<>();
    }

    public int[] getDimensiones() {
        int limites[] = {this.alto, this.ancho};
        return limites;
    }

    public boolean estaVacio() {
        return this.listaPosicionables.isEmpty();
    }

    //Todavia no se agrega en ningun lado la posicion
    public void colocarPosicionable(IPosicionable posicionable, Posicion posicion) {
        if(!estaDentroDelMapa(posicion))
            throw new NoPuedeColocarPosicionablesFueraDelMapaException();

        //Si en esa posicion hay otro IPosicionable
        if(!posicionLibre(posicion))
            throw new NoPuedeColocar2IPosicionablesEnLaMismaPosicionException();

        this.listaPosicionables.put(posicion, posicionable);
    }

    private boolean posicionLibre(Posicion posicion) {

        for(Posicion otraPosicion : this.listaPosicionables.keySet())
            if(posicion.equals(otraPosicion))
                return false;

        return true;
    }

    private boolean estaDentroDelMapa(Posicion posicion) {
        int x = posicion.getEjeX();
        int y = posicion.getEjeY();

        boolean esValidoEnX = (x < this.ancho) && (x > 0);
        boolean esValidoEnY = (y < this.alto) && (y > 0);

        return (esValidoEnX && esValidoEnY);
    }
}
