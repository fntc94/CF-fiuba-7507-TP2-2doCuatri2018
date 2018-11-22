package atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

public class Abajo implements IDireccion {
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(0,-1);
    }
}
