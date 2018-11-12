package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private int alto;
    private int ancho;

    private List<IPosicionable> listaPosicionables;

    public Mapa(int alto, int ancho) {
        if(alto == 0 || ancho == 0) //Numero magico?
            throw new DimensionDeMapaNoPuedeSerCeroException();

        //Si me pasan negativos los hago positivos
        this.alto = Math.abs(alto);
        this.ancho = Math.abs(ancho);

        this.listaPosicionables = new ArrayList<>();
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

        this.listaPosicionables.add(posicionable);
    }

    private boolean estaDentroDelMapa(Posicion posicion) {
        int x = posicion.getEjeX();
        int y = posicion.getEjeY();

        boolean esValidoEnX = (x < this.ancho) && (x > 0);
        boolean esValidoEnY = (y < this.alto) && (y > 0);

        return (esValidoEnX && esValidoEnY);
    }
}
