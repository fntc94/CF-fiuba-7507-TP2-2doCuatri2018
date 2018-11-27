package modelo.edificios;

import modelo.Edificio;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;

public class ConstruccionParaPruebas extends Construccion<Edificio> {

    public ConstruccionParaPruebas(Posicion posicion, int turnosEnConstruir, Aldeano constructor) {
        super(posicion, turnosEnConstruir);
    }

    @Override
    protected Edificio crearEdificio() {
        return null;
    }
}

