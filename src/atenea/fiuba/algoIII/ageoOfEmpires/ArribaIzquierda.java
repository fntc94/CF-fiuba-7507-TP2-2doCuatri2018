package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArribaIzquierda implements Direccion {
    @Override
    public Posicion desplazarPos(Posicion posicion) {
        posicion.modificarCoordenada(-1,1);
        return posicion;
    }
}
