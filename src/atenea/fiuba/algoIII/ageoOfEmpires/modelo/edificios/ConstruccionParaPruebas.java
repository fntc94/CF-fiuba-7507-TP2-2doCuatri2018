package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;

public class ConstruccionParaPruebas extends Construccion<Edificio> {

    public ConstruccionParaPruebas(Posicion posicion, int turnosEnConstruir, Aldeano constructor) {
        super(posicion, turnosEnConstruir);
    }

    @Override
    protected Edificio crearEdificio() {
        return null;
    }
}

