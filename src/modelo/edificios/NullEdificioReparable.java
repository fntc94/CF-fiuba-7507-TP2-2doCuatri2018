package modelo.edificios;

import modelo.IEdificioReparable;
import modelo.unidades.Aldeano;

public class NullEdificioReparable implements IEdificioReparable {

    @Override
    public void recibirReparador(Aldeano reparador) {
        //hace nada.
    }

    @Override
    public void onReparacionTerminada(Runnable action) {
        action.run();
    }
}
