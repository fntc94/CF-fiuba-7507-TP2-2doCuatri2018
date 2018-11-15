package atenea.fiuba.algoIII.ageoOfEmpires;

public class AldeanoFabrica implements IUnidadFabrica<Aldeano> {

    private final int _costoEnOro = 25;
    private final int _vidaMaxima = 50;

    public int obtenerCosto(){
        return _costoEnOro;
    }

    @Override
    public Aldeano crear() {
        return new Aldeano(_vidaMaxima);
    }
}
