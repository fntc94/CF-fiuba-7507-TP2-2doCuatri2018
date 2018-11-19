package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Posicion {
    protected List<Casillero> listaCasilleros;
    protected Mapa mapa;

    public Posicion(){
        this.listaCasilleros = new ArrayList<>();
    }

    public List<Casillero> getListaCasilleros(){
        return this.listaCasilleros;
    }

    public boolean seSuperponeCon(Posicion otraPosicion){
        List<Casillero> lista1 = this.getListaCasilleros();
        List<Casillero> lista2 = otraPosicion.getListaCasilleros();

        for(Casillero unCasillero : lista1){
            for(Casillero otroCasillero : lista2){
                if(unCasillero.equals(otroCasillero))
                    return true;
            }
        }
        return false;
    }

    // Verifica si los todos casilleros de la posicion
    // estan dentro de un area definida por un alto y ancho
    public boolean estaDentroDelArea(int alto, int ancho){
        for(Casillero casillero : this.listaCasilleros){
            if(!casilleroEstaDentroDelArea(alto,ancho, casillero))
                return false;
        }
        return true;
    }

    private boolean casilleroEstaDentroDelArea(int alto, int ancho, Casillero casillero) {
        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordenadaEnY();

        boolean esValidoEnX = (x <= ancho) && (x >= 0);
        boolean esValidoEnY = (y <= alto) && (y >= 0);

        return (esValidoEnX && esValidoEnY);
    }

    public abstract Posicion modificarCoordenada(int valorEnX, int valorEnY);

    // Devuelve la distancia minima
    public int distanciaA(Posicion pos_2){
        List<Integer> listaDistancias = new ArrayList<>();

        for(Casillero unCasillero : pos_2.getListaCasilleros()){
            for(Casillero otroCasillero : this.listaCasilleros){
                listaDistancias.add(calcularDistancia(unCasillero,otroCasillero));
            }
        }

        // Ordeno de menor a mayor
        Collections.sort(listaDistancias);

        return listaDistancias.get(0);
    }

    protected int calcularDistancia(Casillero c1, Casillero c2){
        int x1 = c1.getCoordenadaEnX();
        int y1 = c1.getCoordenadaEnY();

        int x2 = c2.getCoordenadaEnX();
        int y2 = c2.getCoordenadaEnY();

        int x = (x2-x1)*(x2-x1);
        int y = (y2-y1)*(y2-y1);

        Double res = Math.sqrt(x + y);

        return res.intValue();
    }

    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }
}
