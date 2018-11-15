package atenea.fiuba.algoIII.ageoOfEmpires;

public class EspadachinFabrica implements IUnidadFabrica<Espadachin> {

    private final int _costoEnOro = 50;
    private final int _vidaMaxima = 100;

    @Override
    public int obtenerCostoEnOro(){
        return _costoEnOro;
    }

    @Override
    public Espadachin crear() {
        return new Espadachin(_vidaMaxima);
    }
}
