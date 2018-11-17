package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.List;

public abstract class Posicion {
    protected List<Casillero> casillerosOcupados;

    public Posicion(){
        this.casillerosOcupados = new ArrayList<>();
    }

    public List<Casillero> getCasillerosOcupados(){
        return this.casillerosOcupados;
    }

    public boolean seSuperponeCon(Posicion otraPosicion){
        List<Casillero> lista1 = this.getCasillerosOcupados();
        List<Casillero> lista2 = otraPosicion.getCasillerosOcupados();

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
    public boolean estaDentroDe(int alto, int ancho){
        for(Casillero casillero : this.casillerosOcupados){
            if(!estaDentroDelRango(alto,ancho, casillero))
                return false;
        }
        return true;
    }

    private boolean estaDentroDelRango(int alto, int ancho, Casillero casillero) {
        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordenadaEnY();

        boolean esValidoEnX = (x <= ancho) && (x > 0);
        boolean esValidoEnY = (y <= alto) && (y > 0);

        return (esValidoEnX && esValidoEnY);
    }

    public abstract void modificarCoordenada(int i, int i1);
}
