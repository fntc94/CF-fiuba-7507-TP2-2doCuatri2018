package atenea.fiuba.algoIII.ageoOfEmpires;

public class Cuartel extends EdificioReparable implements IEdificioReparable {

    private IUnidadFabrica<Arquero> _arqueroFabrica = new ArqueroFabrica();
    private IUnidadFabrica<Espadachin> _espadachinFabrica = new EspadachinFabrica();

    public Cuartel(int vidaMaxima, int vidaInicial) {
        super(vidaMaxima, vidaInicial);
    }

    public Cuartel(int vidaMaxima){
        this(vidaMaxima, vidaMaxima);
    }

    @Override
    protected int getRecuperoDeVida() {
        return 50;
    }

    public int obtenerCostoArquero(){
        return _arqueroFabrica.obtenerCostoEnOro();
    }

    public Arquero crearArquero(){
        return _arqueroFabrica.crear();
    }

    public int obtenerCostoEspadachin(){
        return _espadachinFabrica.obtenerCostoEnOro();
    }

    public Espadachin crearEspadachin(){
        return _espadachinFabrica.crear();
    }
}