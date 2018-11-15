package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.List;

public abstract class Posicion {
    protected List<Casillero> posicionesOcupadas;

    public Posicion(){
        this.posicionesOcupadas = new ArrayList<>();
    }

    public List<Casillero> getPosicionesOcupadas(){
        return this.posicionesOcupadas;
    }

    public boolean seSuperponeCon(Posicion otraPosicion){
        List<Casillero> lista1 = this.getPosicionesOcupadas();
        List<Casillero> lista2 = otraPosicion.getPosicionesOcupadas();

        for(Casillero unCasillero : lista1){
            for(Casillero otroCasillero : lista2){
                if(unCasillero.equals(otroCasillero))
                    return true;
            }
        }
        return false;
    }

}
