package modelo.unidades;

import modelo.EstrategiaAtaque;

public class EstrategiaDeAtaqueParaPruebas extends EstrategiaAtaque<AtacanteParaPruebas> {

    public EstrategiaDeAtaqueParaPruebas(int danio, int rangDeAtaque) {
        super(rangDeAtaque, danio, danio);
    }
}
