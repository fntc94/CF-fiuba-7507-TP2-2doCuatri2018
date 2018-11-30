package modelo.posicion;

public class PosicionDeUnCasillero extends Posicion {

    public PosicionDeUnCasillero(Mapa mapa, int x, int y) {
        super();

        this.mapa = mapa;
        this.listaCasilleros.add(new Casillero(x,y));
    }

    public PosicionDeUnCasillero(int x, int y){
        this.listaCasilleros.add(new Casillero(x,y));
    }

    @Override
    public Casillero getAbajoIzquierda() {
        return this.getListaCasilleros().get(0);
    }

    @Override
    public int getAlto() {
        return 1;
    }

    @Override
    public int getAncho() {
        return 1;
    }

    // Incrementa/Decrementa coordenadas. Para incrementar x seria (1,0), para incrementar y (0,1)
    @Override
    public Posicion modificarCoordenada(int valorParaX, int valorParaY) {
        int valorX = this.listaCasilleros.get(0).getCoordenadaEnX();
        int valorY = this.listaCasilleros.get(0).getCoordenadaEnY();

        Posicion nuevaPosicion = new PosicionDeUnCasillero(this.mapa,valorX + valorParaX, valorY + valorParaY);

        // La posicion a la que me quiero mover debe estar dentro del mapa y no debe haber otra unidad/edificio
        boolean dentroDelArea = nuevaPosicion.estaDentroDelArea(this.mapa.getAlto(),this.mapa.getAncho());
        boolean posicionLibre = this.mapa.posicionEstaLibre(nuevaPosicion);

        // Si pasa alguna de las cosas anteriores, no cambio la posicion
        if(!dentroDelArea || !posicionLibre)
            return this;

        return nuevaPosicion;
    }
}
