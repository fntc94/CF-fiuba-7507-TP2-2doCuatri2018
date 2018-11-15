package atenea.fiuba.algoIII.ageoOfEmpires;

import java.awt.dnd.InvalidDnDOperationException;

public class PlazaCentralEnConstruccion implements IEdificioEnConstruccion<PlazaCentral> {

    private int _vidaMaxima = 250;
    private int _turnosEnConstruccion = 0;

    public PlazaCentralEnConstruccion() {

    }

    public boolean estaTerminado(){
        return _turnosEnConstruccion == 3;
    }

    public void avanzarConstruccion(){
        _turnosEnConstruccion += 1;
    }

    public PlazaCentral obtenerEdificioTerminado(){

        if(!estaTerminado()){
            throw new InvalidDnDOperationException();
        }

        return new PlazaCentral(_vidaMaxima, _vidaMaxima);
    }
}
