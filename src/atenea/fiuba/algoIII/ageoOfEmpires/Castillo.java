package atenea.fiuba.algoIII.ageoOfEmpires;

public class Castillo extends EdificioReparable {

    public Castillo(int vidaMaxima, int vidaInicial) {
        super(vidaMaxima, vidaInicial);
    }

    @Override
    protected int getRecuperoDeVida() {
        return 15;
    }
}
