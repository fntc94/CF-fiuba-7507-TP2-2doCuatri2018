package atenea.fiuba.algoIII.ageoOfEmpires;

public class Arriba implements IDireccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        return posicion.modificarCoordenada(0,1);
    }
}
