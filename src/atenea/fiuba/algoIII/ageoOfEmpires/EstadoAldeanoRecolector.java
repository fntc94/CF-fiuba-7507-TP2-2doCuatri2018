package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoAldeanoRecolector implements IEstadoAldeano {

    EstadoAldeanoRecolector(){

    }

    @Override
    public int recolectarOro() {
        return 20;
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        // hace nada;
        // TODO: throw?
    }

    @Override
    public void continuarReparacion() {
        // hace nada;
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        // hace nada;
        // TODO: throw?
    }

    @Override
    public void iniciarConstruccion() {

    }

    @Override
    public void continuarConstruccion() {

    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }
}
