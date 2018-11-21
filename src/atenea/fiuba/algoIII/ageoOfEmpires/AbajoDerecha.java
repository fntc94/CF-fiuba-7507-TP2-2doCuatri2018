package atenea.fiuba.algoIII.ageoOfEmpires;

public class AbajoDerecha implements IDireccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        posicion.modificarCoordenada(1,-1);
        return posicion;
    }
}
