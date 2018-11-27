package modelo.movimiento;

import modelo.posicion.Posicion;

public class AbajoDerecha implements IDireccion {
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(1,-1);
    }
}
