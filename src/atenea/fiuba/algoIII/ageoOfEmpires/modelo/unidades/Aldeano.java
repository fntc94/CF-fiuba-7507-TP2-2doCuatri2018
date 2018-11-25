package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Cuartel;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosEnConstruccionFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

import java.util.function.Consumer;

public class Aldeano extends Unidad {

    private final static int VIDA_MAXIMA = 50;

    private EdificiosEnConstruccionFabrica fabricaDeEdificios;
    private IAldeanoState aldeanoState;
    private int oro;

    void setOro(int oro){
        this.oro = oro;
    }

    void setEstado(IAldeanoState estado){
        this.aldeanoState = estado;
    }

    public Aldeano(Posicion posicion, EdificiosEnConstruccionFabrica fabricaDeEdificiosEnConstruccion){
        super(posicion, VIDA_MAXIMA);
        this.fabricaDeEdificios = fabricaDeEdificiosEnConstruccion;
        this.aldeanoState = new AldeanoRecolectorState(this);
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this.aldeanoState.iniciarReparacion(edificioReparable);
    }

    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        this.aldeanoState = new AldeanoConstructorState(this.fabricaDeEdificios.obtenerPlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        this.aldeanoState.trabajar();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){
        this.aldeanoState = new AldeanoConstructorState(this.fabricaDeEdificios.obtenerCuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        this.aldeanoState.trabajar();

    }

    public void iniciarConstruccionDeCuartel(){
        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }

    public int trabajar(){
        this.aldeanoState.trabajar();
        return this.oro;
    }

}