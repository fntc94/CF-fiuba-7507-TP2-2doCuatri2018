package atenea.fiuba.algoIII.ageoOfEmpires;

public class Movimiento {
    private Direccion direccion;

    public void hacia(Direccion direccion) {
        this.direccion = direccion;
    }

    public Posicion calcularPosSiguiente(Posicion pos) {
        return this.direccion.desplazarPos(pos);
    }
}
