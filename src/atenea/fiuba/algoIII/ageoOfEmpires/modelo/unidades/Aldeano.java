package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.IConstruccion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

public class Aldeano extends Unidad {

    private final static int VIDA_MAXIMA = 50;

    private IAldeanoState aldeanoState;
    private int oro;

    void setOro(int oro){
        this.oro = oro;
    }

    void setEstado(IAldeanoState estado){
        this.aldeanoState = estado;
    }

    public Aldeano(Posicion posicion){
        super(posicion, VIDA_MAXIMA);
        this.aldeanoState = new AldeanoRecolectorState(this);
    }

    public void iniciarConstruccion(IConstruccion construccion){
        this.aldeanoState.iniciarConstruccion(construccion);
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this.aldeanoState.iniciarReparacion(edificioReparable);
    }

    public int trabajar(){
        this.aldeanoState.trabajar();
        return this.oro;
    }

}