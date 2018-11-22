package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.EstrategiaAtaque;

public class EstrategiaDeAtaqueParaPruebas extends EstrategiaAtaque<AtacanteParaPruebas> {

    public EstrategiaDeAtaqueParaPruebas(int danio, int rangDeAtaque) {
        super(rangDeAtaque, danio, danio);
    }
}
