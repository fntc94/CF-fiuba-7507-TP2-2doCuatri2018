package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.NullEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaExcepcion;

public class EstadoAldeanoReparador implements IEstadoAldeano {

    private Aldeano contexto;
    private IEdificioReparable edificioReparable;

    EstadoAldeanoReparador(IEdificioReparable edificioReparable, Aldeano contexto){
        this.contexto = contexto;
        this.edificioReparable = edificioReparable;
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return 0;
    }

    @Override
    public boolean estaRecolectandoOro() {
        return false;
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public void iniciarConstruccion() {
        throw new OperacionInvalidaExcepcion();
    }

    @Override
    public boolean estaConstruyendo() {
        return false;
    }

    @Override
    public void continuarConstruyendo() {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }
    //fin IConstructor

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this.edificioReparable = edificioReparable;
        this.edificioReparable.recibirReparador(this);
    }

    @Override
    public boolean estaReparando() {
        return true;
    }

    @Override
    public void continuarReparando(){
        this.edificioReparable.recibirReparador(this);
    }

    @Override
    public void darPorTerminadaLaReparacion() {
        this.edificioReparable = new NullEdificioReparable();
        this.contexto.establecerEstado(new EstadoAldeanoRecolector());
    }
    //fin IReparador

}
