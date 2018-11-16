package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionCuadrado extends Posicion {

    public PosicionCuadrado(int xInicial, int yInicial , int xFinal, int yFinal) {
        super();

        for(int j = yInicial; j >= yFinal; j--)
            for(int i = xInicial; i <= xFinal; i++)
                this.casillerosOcupados.add(new Casillero(i, j));
    }
}
