package atenea.fiuba.algoIII.ageoOfEmpires;

public class EstadoArmaDeAsedioMontada implements IEstadoArmaDeAsedio {

    private final int DANIO_A_EDIFICIOS = 75;

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

    @Override
    public void atacar(IEdificioAtacable edificioAtacable) {
        edificioAtacable.recibirDanio(DANIO_A_EDIFICIOS);
    }

}
