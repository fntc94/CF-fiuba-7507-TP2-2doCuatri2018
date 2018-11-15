package atenea.fiuba.algoIII.ageoOfEmpires;

public class NullAledeanoReparador implements IEstadoReparador {

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        // hace nada;
    }

    @Override
    public void continuarReparando() {
        // hace nada;
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        // hace nada;
    }

    @Override
    public boolean estaReparando() {
        return false;
    }

}
