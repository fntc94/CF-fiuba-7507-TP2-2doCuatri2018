package atenea.fiuba.algoIII.ageoOfEmpires.modelo.movimiento;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

public class Movimiento {
    private IDireccion direccion;

    public void hacia(IDireccion direccion) {
        this.direccion = direccion;
    }

    public Posicion calcularPosSiguiente(Posicion pos) {
        return  this.direccion.desplazarPos(pos);
    }
}
