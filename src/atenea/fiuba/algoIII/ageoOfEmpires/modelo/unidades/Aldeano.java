package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Cuartel;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosEnConstruccionFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

import java.util.function.Consumer;

public class Aldeano extends Unidad {

    private final static int VIDA_MAXIMA = 50;

    private EdificiosEnConstruccionFabrica fabricaDeEdificios;
    private IAldeanoState estadoAldeano;

    void establecerEstado(IAldeanoState estado){
        this.estadoAldeano = estado;
    }

    public Aldeano(Posicion posicion, EdificiosEnConstruccionFabrica fabricaDeEdificiosEnConstruccion){
        super(posicion, VIDA_MAXIMA);
        this.fabricaDeEdificios = fabricaDeEdificiosEnConstruccion;
        this.estadoAldeano = new AldeanoRecolectorState(this);
    }

    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this.estadoAldeano.iniciarReparacion(edificioReparable);
    }

    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        this.estadoAldeano = new AldeanoConstructorState(this.fabricaDeEdificios.obtenerPlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        this.estadoAldeano.construir();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){
        this.estadoAldeano = new AldeanoConstructorState(this.fabricaDeEdificios.obtenerCuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        this.estadoAldeano.construir();

    }

    public void iniciarConstruccionDeCuartel(){
        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }

    public int trabajar() {

        int oro = this.estadoAldeano.recolectarOro();
        this.estadoAldeano.construir();
        this.estadoAldeano.reparar();
        return oro;

    }
}