package atenea.fiuba.algoIII.ageoOfEmpires;

public class AbajoDerecha implements IDireccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(1,-1);
    }
}
