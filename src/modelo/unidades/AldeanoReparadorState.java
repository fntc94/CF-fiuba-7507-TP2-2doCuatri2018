package modelo.unidades;

import modelo.IEdificioReparable;
import modelo.edificios.IConstruccion;
import modelo.edificios.NullEdificioReparable;
import modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;

class AldeanoReparadorState implements IAldeanoState {

    private Aldeano aldeano;
    private IEdificioReparable edificioEnReparacion;
    private final int ORO_RECOLECTADO = 0;

    AldeanoReparadorState(IEdificioReparable edificioReparable, Aldeano contexto){
        this.aldeano = contexto;
        this.edificioEnReparacion = edificioReparable;

        this.edificioEnReparacion.onReparacionTerminada(() -> {
                this.edificioEnReparacion = new NullEdificioReparable();
                this.aldeano.setEstado(new AldeanoRecolectorState(this.aldeano));
            });
    }

    @Override
    public void iniciarConstruccion(IConstruccion edificioEnConstruccion){
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable) {
        throw new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion();
    }

    @Override
    public void trabajar(){
        this.reparar();
        this.aldeano.setOro(ORO_RECOLECTADO);
    }

    private void reparar(){
        this.edificioEnReparacion.recibirReparador(this.aldeano);
    }

}
