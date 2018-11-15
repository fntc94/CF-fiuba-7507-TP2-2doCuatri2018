package atenea.fiuba.algoIII.ageoOfEmpires;

public class Cuartel implements IEdificioReparable {

    private int _vidaMaxima;
    private int _vidaActual;
    private IReparadorDeEdificios _reparadorActivo;

    private IUnidadFabrica<Arquero> _arqueroFabrica = new ArqueroFabrica();
    private IUnidadFabrica<Espadachin> _espadachinFabrica = new EspadachinFabrica();

    public Cuartel(int vidaMaxima, int vidaInicial) {

        _vidaMaxima = vidaMaxima;
        _vidaActual = vidaInicial;
    }

    public Cuartel(int vidaMaxima){
        this(vidaMaxima, vidaMaxima);
    }

    public int getVida() {
        return _vidaActual;
    }

    private int getRecuperoDeVida() {
        return 50;
    }

    @Override
    public void recibirReparador(IReparadorDeEdificios reparador) {

        if(_reparadorActivo == null){
            _reparadorActivo = reparador;
        }

        else if (_reparadorActivo != reparador){
            return;
        }

        this._vidaActual += getRecuperoDeVida();

        if(_vidaActual > _vidaMaxima){
            _vidaActual = _vidaMaxima;
        }
    }


    public int obtenerCostoArquero(){
        return _arqueroFabrica.obtenerCosto();
    }

    public Arquero crearArquero(){
        return _arqueroFabrica.crear();
    }

    public int obtenerCostoEspadachin(){
        return _espadachinFabrica.obtenerCosto();
    }

    public Espadachin crearEspadachin(){
        return _espadachinFabrica.crear();
    }
}