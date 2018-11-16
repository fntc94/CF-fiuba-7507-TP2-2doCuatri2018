package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoArmaDeAsedioDesmontada implements IEstadoArmaDeAsedio {

    @Override
    public boolean estaMontada() {
        return false;
    }

    @Override
    public void atacar() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void mover() {
        // TODO: implementar movimiento!
    }


}
