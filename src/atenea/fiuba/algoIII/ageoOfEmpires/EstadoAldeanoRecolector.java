package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoAldeanoRecolector implements IEstadoAldeano {

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 20;
    }

    @Override
    public boolean estaRecolectandoOro() {
        return true;
    }
    //fin IRecolectorDeOro

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public boolean estaReparando() {
        return false;
    }

    @Override
    public void continuarReparando() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IReparador

    //IConstructor
    @Override
    public void iniciarConstruccion() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }

    @Override
    public void continuarConstruyendo() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    // fin IConstructor
}
