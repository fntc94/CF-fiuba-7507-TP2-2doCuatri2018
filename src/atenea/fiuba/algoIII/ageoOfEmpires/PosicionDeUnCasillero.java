package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(int x, int y) {
        this.posicionesOcupadas = new ArrayList<>();

        this.posicionesOcupadas.add(new Casillero(x,y));
    }

}
