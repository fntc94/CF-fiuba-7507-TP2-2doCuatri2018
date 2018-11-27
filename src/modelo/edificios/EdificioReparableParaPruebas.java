package modelo.edificios;

import modelo.IEdificioReparable;
import modelo.unidades.Aldeano;

public class EdificioReparableParaPruebas implements IEdificioReparable {

    private Runnable reparacionTerminadaHandler = () -> {};
    private int turnosEnReparar;
    private int turnosReparado = 0;

    public EdificioReparableParaPruebas(int turnosEnReparar){
        this.turnosEnReparar = turnosEnReparar;
    }

    @Override
    public void recibirReparador(Aldeano reparador) {

        this.turnosReparado += 1;
        if(this.reparacionEstaTerminada()){
            this.reparacionTerminadaHandler.run();
        }

    }

    @Override
    public void onReparacionTerminada(Runnable reparacionTerminadaHandler) {
        this.reparacionTerminadaHandler = reparacionTerminadaHandler;
    }

    private boolean reparacionEstaTerminada(){
        return this.turnosEnReparar == this.turnosReparado;
    }
}
