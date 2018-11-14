package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(int x, int y) {
        super();

        this.posicionesOcupadas.add(new Casillero(x,y));
    }

}
