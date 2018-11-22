package atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

public class ArribaIzquierda implements IDireccion {
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(-1,1);
    }
}
