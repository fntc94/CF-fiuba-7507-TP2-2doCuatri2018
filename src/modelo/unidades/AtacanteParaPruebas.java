package modelo.unidades;

import modelo.IAtacante;
import modelo.posicion.Posicion;

public class AtacanteParaPruebas extends UnidadMilitar implements IAtacante {

    private static int VIDA = 100;

    public AtacanteParaPruebas(Posicion posicion, int rangoDeAtaque, int danio) {
        super(posicion, VIDA, new EstrategiaDeAtaqueParaPruebas(danio, rangoDeAtaque));
    }
}
