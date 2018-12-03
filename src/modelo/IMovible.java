package modelo;

import modelo.movimiento.IDireccion;

public interface IMovible extends IPosicionable {

    void mover(IDireccion direccion);
}
