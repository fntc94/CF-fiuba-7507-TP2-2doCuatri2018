package atenea.fiuba.algoIII.ageoOfEmpires;

import java.awt.dnd.InvalidDnDOperationException;

public class CuartelEnConstruccion implements IEdificioEnConstruccion<Cuartel> {

    private int _vidaMaxima = 450;
    private int _vidaActual = 0;
    private int _avancePorTurno = 150;

    public CuartelEnConstruccion() {
    }


    public boolean estaTerminado(){
        return _vidaActual == _vidaMaxima;
    }

    public void avanzarConstruccion(){
        _vidaActual += _avancePorTurno;
    }

    public Cuartel obtenerEdificioTerminado(){

        if(!estaTerminado()){
            throw new InvalidDnDOperationException();
        }

        return new Cuartel(_vidaMaxima, _vidaActual);
    }

}
