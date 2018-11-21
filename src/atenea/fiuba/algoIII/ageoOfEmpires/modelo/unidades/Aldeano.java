package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IAtacable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEdificioReparable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPosicionable;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.Cuartel;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.EdificiosEnConstruccionFabrica;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.PlazaCentral;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.Posicion;

import java.util.function.Consumer;

public class Aldeano extends Unidad implements IPosicionable, IRecolectorOro, IConstructor, IReparador, IAtacable {

    private final static int VIDA_MAXIMA = 50;

    private EdificiosEnConstruccionFabrica fabricaDeEdificios;
    private IEstadoAldeano estadoAldeano = new EstadoAldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        this.estadoAldeano = estado;
    }

    public Aldeano(Posicion posicion, EdificiosEnConstruccionFabrica fabricaDeEdificiosEnConstruccion){
        super(posicion, VIDA_MAXIMA);
        this.fabricaDeEdificios = fabricaDeEdificiosEnConstruccion;
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return this.estadoAldeano.recolectarOro();
    }

    @Override
    public boolean estaRecolectandoOro() {
        return this.estadoAldeano.estaRecolectandoOro();
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public boolean estaConstruyendo() {
        return this.estadoAldeano.estaConstruyendo();
    }

    @Override
    public void continuarConstruyendo() {
        this.estadoAldeano.continuarConstruyendo();
    }
    //fin IConstructor

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        this.estadoAldeano = new EstadoAldeanoReparador(edificioReparable, this);
        this.estadoAldeano.iniciarReparacion(edificioReparable);
    }

    @Override
    public boolean estaReparando() {
        return this.estadoAldeano.estaReparando();
    }

    @Override
    public void continuarReparando(){
        this.estadoAldeano.continuarReparando();
    }
    //fin IReparador


    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        this.estadoAldeano = new EstadoAldeanoConstructor(this.fabricaDeEdificios.obtenerPlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        this.estadoAldeano.iniciarConstruccion();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        this.estadoAldeano = new EstadoAldeanoConstructor(this.fabricaDeEdificios.obtenerCuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        this.estadoAldeano.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){
        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }
}