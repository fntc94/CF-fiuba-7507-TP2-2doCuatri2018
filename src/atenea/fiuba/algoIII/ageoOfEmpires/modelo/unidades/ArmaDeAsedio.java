package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacante;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;


public class ArmaDeAsedio extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 150;
    private IEstadoArmaDeAsedio estado = new EstadoArmaDeAsedioDesmontada();

    public ArmaDeAsedio(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }

    public boolean estaMontada() {
        return this.estado.estaMontada();
    }

    public void montar() {
      this.estado = new EstadoArmaDeAsedioMontada();
    }

    public void desmontar() {
       this.estado = new EstadoArmaDeAsedioDesmontada();
    }

    public void atacar() {
        this.estado.atacar();
    }

    public void mover() {
        this.estado.mover();
    }

}
