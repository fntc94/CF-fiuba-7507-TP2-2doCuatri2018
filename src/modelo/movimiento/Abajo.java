package modelo.movimiento;

import modelo.posicion.Posicion;

public class Abajo implements IDireccion {

    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(0,1);
    }
}
