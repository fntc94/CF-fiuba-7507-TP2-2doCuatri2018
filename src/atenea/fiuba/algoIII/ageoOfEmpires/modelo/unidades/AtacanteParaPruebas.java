package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

public class AtacanteParaPruebas extends UnidadMilitar implements IAtacante {

    private static int VIDA = 100;

    public AtacanteParaPruebas(Posicion posicion, int rangoDeAtaque, int danio) {
        super(posicion, VIDA, new EstrategiaDeAtaqueParaPruebas(danio, rangoDeAtaque));
    }
}
