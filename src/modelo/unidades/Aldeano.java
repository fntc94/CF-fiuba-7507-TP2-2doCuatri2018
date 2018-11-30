package modelo.unidades;

import modelo.IEdificioReparable;
import modelo.Unidad;
import modelo.edificios.IConstruccion;
import modelo.posicion.Posicion;

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