package atenea.fiuba.algoIII.ageoOfEmpires;

public class ArqueroFabrica implements IUnidadFabrica<Arquero> {


    private final int _costo = 75;
    private final int _vidaMaxima = 75;

    @Override
    public int obtenerCosto() {
        return _costo;
    }

    @Override
    public Arquero crear() {
        return new Arquero(_vidaMaxima);
    }
}
