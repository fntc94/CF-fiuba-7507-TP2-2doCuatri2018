package atenea.fiuba.algoIII.ageoOfEmpires;

public class PlazaCentral extends EdificioReparable implements IEdificioReparable {

    private IUnidadFabrica<Aldeano> _fabricaDeAldeanos = new AldeanoFabrica();

    public PlazaCentral(int vidaMaxima, int vidaInicial) {
        super(vidaMaxima, vidaInicial);

    }

    public PlazaCentral(int vidaMaxima) {
        this(vidaMaxima, vidaMaxima);
    }

    @Override
    protected int getRecuperoDeVida() {
        return 25;
    }

    public int obtenerCostoAldeano(){

        return _fabricaDeAldeanos.obtenerCostoEnOro();
    }

    public Aldeano construirAldeano() {

        return _fabricaDeAldeanos.crear();

    }
}
