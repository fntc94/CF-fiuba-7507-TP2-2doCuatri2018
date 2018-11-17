package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arriba implements Direccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        posicion.modificarCoordenada(0,1);
        return posicion;
    }
}
