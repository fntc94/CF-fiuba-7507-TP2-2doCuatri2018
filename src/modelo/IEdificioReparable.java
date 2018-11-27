package modelo;

import modelo.unidades.Aldeano;

public interface IEdificioReparable {

    void recibirReparador(Aldeano reparador);
    void onReparacionTerminada(Runnable action);

}
