package atenea.fiuba.algoIII.ageoOfEmpires;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(Mapa mapa, int x, int y) {
        super();

        this.mapa = mapa;
        this.listaCasilleros.add(new Casillero(x,y));
    }

    public PosicionDeUnCasillero(int x, int y){}  // revisar EdificiosFabrica

    // Incrementa/Decrementa coordenadas. Para incrementar x seria (1,0), para incrementar y (0,1)
    @Override
    public Posicion modificarCoordenada(int valorParaX, int valorParaY) {
        int valorX = this.listaCasilleros.get(0).getCoordenadaEnX();
        int valorY = this.listaCasilleros.get(0).getCoordenadaEnY();

        Posicion nuevaPosicion = new PosicionDeUnCasillero(this.mapa,valorX + valorParaX, valorY + valorParaY);

        //  Si se quiere mover fuera del mapa se queda en la misma posicion
        if(!nuevaPosicion.estaDentroDelArea(this.mapa.getAlto(),this.mapa.getAncho()))
            return this;

        return nuevaPosicion;
    }
}
