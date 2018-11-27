package modelo.movimiento;

import modelo.posicion.Posicion;

public class Izquierda implements IDireccion {
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(-1,0);
    }
}
