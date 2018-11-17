package atenea.fiuba.algoIII.ageoOfEmpires;

public class Izquierda implements Direccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        posicion.modificarCoordenada(-1,0);
        return posicion;
    }
}
