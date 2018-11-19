package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.function.Consumer;

public class Aldeano extends Unidad implements IPosicionable, IRecolectorOro, IConstructor, IReparador, IAtacable {

    private final static int VIDA_MAXIMA = 50;

    private EdificiosEnConstruccionFabrica _fabricaDeEdificios;
    private IEstadoAldeano _estadoAldeano = new EstadoAldeanoRecolector();

    void establecerEstado(IEstadoAldeano estado){
        _estadoAldeano = estado;
    }

    public Aldeano(Posicion posicion, EdificiosEnConstruccionFabrica fabricaDeEdificiosEnConstruccion){
        super(posicion, VIDA_MAXIMA);
        _fabricaDeEdificios = fabricaDeEdificiosEnConstruccion;
    }

    //IRecolectorDeOro
    @Override
    public int recolectarOro() {
        return _estadoAldeano.recolectarOro();
    }

    @Override
    public boolean estaRecolectandoOro() {
        return _estadoAldeano.estaRecolectandoOro();
    }
    //fin IRecolectorDeOro

    //IConstructor
    @Override
    public boolean estaConstruyendo() {
        return _estadoAldeano.estaConstruyendo();
    }

    @Override
    public void continuarConstruyendo() {
        _estadoAldeano.continuarConstruyendo();
    }
    //fin IConstructor

    //IReparador
    @Override
    public void iniciarReparacion(IEdificioReparable edificioReparable){
        _estadoAldeano = new EstadoAldeanoReparador(edificioReparable, this);
        _estadoAldeano.iniciarReparacion(edificioReparable);
    }

    @Override
    public boolean estaReparando() {
        return _estadoAldeano.estaReparando();
    }

    @Override
    public void continuarReparando(){
        _estadoAldeano.continuarReparando();
    }
    //fin IReparador


    public void iniciarConstruccionDePlazaCentral(Consumer<PlazaCentral> accionAlTerminarConstruccion){
        _estadoAldeano = new EstadoAldeanoConstructor(_fabricaDeEdificios.obtenerPlazaCentralEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();
    }

    public void iniciarConstruccionDePlazaCentral(){
        this.iniciarConstruccionDePlazaCentral(plazaCentral -> {});
    }

    public void iniciarConstruccionDeCuartel(Consumer<Cuartel> accionAlTerminarConstruccion){

        _estadoAldeano = new EstadoAldeanoConstructor(_fabricaDeEdificios.obtenerCuartelEnConstruccion(), accionAlTerminarConstruccion, this);
        _estadoAldeano.iniciarConstruccion();

    }

    public void iniciarConstruccionDeCuartel(){
        this.iniciarConstruccionDeCuartel(cuartel -> {});
    }
}