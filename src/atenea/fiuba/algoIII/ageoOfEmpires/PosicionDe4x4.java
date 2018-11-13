package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.List;

public class PosicionDe4x4 extends Posicion {

    public PosicionDe4x4(int x, int y) {
        this.posicionesOcupadas = new ArrayList<>();

        //Agrego todas las 16 posiciones ocupadas
        //fila_1
        this.posicionesOcupadas.add(new Casillero(x,y));
        this.posicionesOcupadas.add(new Casillero(x+1,y));
        this.posicionesOcupadas.add(new Casillero(x+2,y));
        this.posicionesOcupadas.add(new Casillero(x+3,y));

        //fila_2
        this.posicionesOcupadas.add(new Casillero(x,y-1));
        this.posicionesOcupadas.add(new Casillero(x+1,y-1));
        this.posicionesOcupadas.add(new Casillero(x+2,y-1));
        this.posicionesOcupadas.add(new Casillero(x+3,y-1));

        //fila_3
        this.posicionesOcupadas.add(new Casillero(x,y-2));
        this.posicionesOcupadas.add(new Casillero(x+1,y-2));
        this.posicionesOcupadas.add(new Casillero(x+2,y-2));
        this.posicionesOcupadas.add(new Casillero(x+3,y-2));

        //fila_4
        this.posicionesOcupadas.add(new Casillero(x,y-3));
        this.posicionesOcupadas.add(new Casillero(x+1,y-3));
        this.posicionesOcupadas.add(new Casillero(x+2,y-3));
        this.posicionesOcupadas.add(new Casillero(x+3,y-3));
    }

}
