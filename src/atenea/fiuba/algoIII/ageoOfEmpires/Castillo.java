package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends EdificioReparable implements IEdificioReparable {

    private final int VELOCIDAD_DE_REPARACION = 15;

    public Castillo(int vidaMaxima, int vidaInicial) {
        super(vidaMaxima, vidaInicial);
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }
}
