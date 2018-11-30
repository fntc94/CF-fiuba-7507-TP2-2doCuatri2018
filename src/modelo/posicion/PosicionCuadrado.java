package modelo.posicion;

public class PosicionCuadrado extends Posicion {


    private int dimension;

    public PosicionCuadrado(Limite limite, Casillero casillero, int dimension) {
        this.dimension = dimension;

        int x = casillero.getCoordenadaEnX();
        int y = casillero.getCoordenadaEnY();

        if (limite == Limite.SuperiorIzquierdo) {
            for (int i = x; i < x + dimension; i++) {
                for (int j = y; j < y + dimension; j++) {
                    this.listaCasilleros.add(new Casillero(i, j));
                }
            }
        }

        if(limite == Limite.InferiorDerecho){
            for (int i = x; i >= x - dimension; i--) {
                for (int j = y; j < y - dimension; j++) {
                    this.listaCasilleros.add(new Casillero(i, j));
                }
            }
        }
//
//        if(limite == Limite.SuperiorIzquierdo){
//            for (int i = x; i < ancho; i++) {
//                for (int j = y; j < alto; j++) {
//                    this.listaCasilleros.add(new Casillero(i, j));
//                }
//            }
//        }


    }

    public PosicionCuadrado(int xInicial, int yInicial, int xFinal, int yFinal) {
        super();

        for (int j = yInicial; j >= yFinal; j--)
            for (int i = xInicial; i <= xFinal; i++)
                this.listaCasilleros.add(new Casillero(i, j));
    }


    @Override
    public Casillero getAbajoIzquierda() {
        return this.getListaCasilleros().get(0);
    }

    @Override
    public int getAlto() {
        return dimension;
    }

    @Override
    public int getAncho() {
        return dimension;
    }

    @Override
    public Posicion modificarCoordenada(int i, int i1) {
        return new PosicionCuadrado(0, 0, 0, 0);
    }
}
