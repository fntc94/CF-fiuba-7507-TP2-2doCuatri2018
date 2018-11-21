package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.EstadoArmaDeAsedioDesmontada;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.EstadoArmaDeAsedioMontada;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.IEstadoArmaDeAsedio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.UnidadMilitar;


public class ArmaDeAsedio extends UnidadMilitar implements IPosicionable, IAtacable, IAtacante {

    private final static int VIDA_MAXIMA = 150;
    private IEstadoArmaDeAsedio _estado = new EstadoArmaDeAsedioDesmontada();

    public ArmaDeAsedio(Posicion posicion, IEstrategiaAtaque estrategiaAtaque){
        super(posicion, VIDA_MAXIMA, estrategiaAtaque);
    }

    public boolean estaMontada() {
        return _estado.estaMontada();
    }

    public void montar() {
      _estado = new EstadoArmaDeAsedioMontada();
    }

    public void desmontar() {
       _estado = new EstadoArmaDeAsedioDesmontada();
    }

    public void atacar() {
        _estado.atacar();
    }

    public void mover() {
        _estado.mover();
    }

}
