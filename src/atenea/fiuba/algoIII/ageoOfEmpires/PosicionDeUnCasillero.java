package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(int x, int y) {
        super();

        this.listaCasilleros.add(new Casillero(x,y));
    }

    // Incrementa/Decrementa coordenadas. Para incrementar x seria (1,0), para incrementar y (0,1)
    @Override
    public void modificarCoordenada(int valorParaX, int valorParaY) {
        int valorX = this.listaCasilleros.get(0).getCoordenadaEnX();
        int valorY = this.listaCasilleros.get(0).getCoordenadaEnY();

        this.listaCasilleros.remove(0);
        // Decremento la variable correspondiente y lo agrego a la lista de casilleros
        this.listaCasilleros.add(new Casillero(valorX + valorParaX, valorY + valorParaY));
    }
}
