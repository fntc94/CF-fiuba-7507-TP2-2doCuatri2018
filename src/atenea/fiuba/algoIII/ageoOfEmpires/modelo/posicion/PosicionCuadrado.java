package atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion;

public class PosicionCuadrado extends Posicion {

    public PosicionCuadrado(int xInicial, int yInicial , int xFinal, int yFinal) {
        super();

        for(int j = yInicial; j >= yFinal; j--)
            for(int i = xInicial; i <= xFinal; i++)
                this.listaCasilleros.add(new Casillero(i, j));
    }


    @Override
    public Posicion modificarCoordenada(int i, int i1) {
        return new PosicionCuadrado(0,0,0,0);
    }
}
