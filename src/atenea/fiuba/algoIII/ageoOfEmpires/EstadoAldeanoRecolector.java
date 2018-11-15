package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoAldeanoRecolector implements IEstadoAldeano {

    EstadoAldeanoRecolector(){

    }

    @Override
    public boolean estaRecolectandoOro() {
        return true;
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
        throw new OperacionInvalidaDadoElEstadoActualDelObjectoExcepcion();
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        // hace nada;
        // TODO: throw?
    }

    @Override
    public boolean estaReparando() {
        return false;
    }

    @Override
    public void iniciarConstruccion() {

    }

    @Override
    public void continuarConstruccion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjectoExcepcion();
    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }
}
