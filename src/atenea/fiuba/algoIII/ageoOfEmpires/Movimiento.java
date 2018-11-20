package atenea.fiuba.algoIII.ageoOfEmpires;

public class Movimiento {
    private IDireccion direccion;

    public void hacia(IDireccion direccion) {
        this.direccion = direccion;
    }

    public Posicion calcularPosSiguiente(Posicion pos) {
        return  this.direccion.desplazarPos(pos);
    }
}
