package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoArmaDeAsedioMontada implements IEstadoArmaDeAsedio {

    @Override
    public boolean estaMontada(){
        return true;
    }

    @Override
    public void atacar(){
        // TODO: implementar ataque!
    }

    @Override
    public void mover(){
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

}
