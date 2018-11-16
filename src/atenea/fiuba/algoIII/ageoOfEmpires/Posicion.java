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

}
