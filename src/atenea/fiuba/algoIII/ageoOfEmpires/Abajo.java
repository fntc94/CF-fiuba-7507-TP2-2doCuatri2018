package atenea.fiuba.algoIII.ageoOfEmpires;

public class Abajo implements IDireccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        posicion.modificarCoordenada(0,-1);
        return posicion;
    }
}
