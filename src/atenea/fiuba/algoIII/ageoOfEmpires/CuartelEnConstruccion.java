package atenea.fiuba.algoIII.ageoOfEmpires;

import java.awt.dnd.InvalidDnDOperationException;

public class CuartelEnConstruccion implements IEdificioEnConstruccion<Cuartel> {

    private int _vidaMaxima = 450;
    private int _vidaActual = 0;
    private int _avancePorTurno = 150;

    @Override
    public boolean estaTerminado(){
        return _vidaActual == _vidaMaxima;
    }

    @Override
    public void avanzarConstruccion(){
        _vidaActual += _avancePorTurno;
    }

    @Override
    public Cuartel obtenerEdificioTerminado(){

        if(!estaTerminado()){
            throw new InvalidDnDOperationException();
        }

        return new Cuartel(_vidaMaxima);
    }

}
