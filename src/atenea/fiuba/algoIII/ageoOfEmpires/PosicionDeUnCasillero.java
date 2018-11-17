package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(int x, int y) {
        super();

        this.casillerosOcupados.add(new Casillero(x,y));
    }

    // Incrementa/Decrementa coordenadas. Para incrementar x seria (1,0), para incrementar y (0,1)
    @Override
    public void modificarCoordenada(int valorParaX, int valorParaY) {
        int valorX = this.casillerosOcupados.get(0).getCoordenadaEnX();
        int valorY = this.casillerosOcupados.get(0).getCoordenadaEnY();

        this.casillerosOcupados.remove(0);
        // Decremento la variable correspondiente y lo agrego a la lista de casilleros
        this.casillerosOcupados.add(new Casillero(valorX + valorParaX, valorY + valorParaY));
    }
}
