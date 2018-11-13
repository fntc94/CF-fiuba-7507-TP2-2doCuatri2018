package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;

public class PosicionDe2x2 extends Posicion {

    public PosicionDe2x2(int x, int y) {
        this.posicionesOcupadas = new ArrayList<>();

        //Agrego todas las 4 posiciones ocupadas
        //fila_1
        this.posicionesOcupadas.add(new Casillero(x,y));
        this.posicionesOcupadas.add(new Casillero(x+1,y));

        //fila_2
        this.posicionesOcupadas.add(new Casillero(x,y-1));
        this.posicionesOcupadas.add(new Casillero(x+1,y-1));

    }

}
