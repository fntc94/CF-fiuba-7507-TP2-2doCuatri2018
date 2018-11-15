package atenea.fiuba.algoIII.ageoOfEmpires;

public class AldeanoRecolector implements IEstadoAldeano {

    AldeanoRecolector(){

    }

    @Override
    public int recolectarOro() {
        return 20;
    }

    @Override
    public void reparar(IEdificioReparable edificioReparable) {
        // hace nada;
        // TODO: throw?
    }

    @Override
    public void reparar() {
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
