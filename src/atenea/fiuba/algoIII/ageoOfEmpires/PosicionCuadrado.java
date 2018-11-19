package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionCuadrado extends Posicion {

    public PosicionCuadrado(int xInicial, int yInicial , int xFinal, int yFinal) {
        super();

        for(int j = yInicial; j >= yFinal; j--)
            for(int i = xInicial; i <= xFinal; i++)
                this.listaCasilleros.add(new Casillero(i, j));
    }

    //  Una unidad que ocupa varios casilleros no puede moverse
    @Override
    public Posicion modificarCoordenada(int i, int i1) {
        return new PosicionCuadrado(0,0,0,0);
    }
}
