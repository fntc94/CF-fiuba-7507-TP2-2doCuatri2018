package atenea.fiuba.algoIII.ageoOfEmpires;

public class UnidadesFabrica {

    private final int _costoEnOroAldeano = 25;
    private final int _vidaMaximaAldeano = 50;

    private final int _costoEnOroArquero = 75;
    private final int _vidaMaximaArquero = 75;

    private final int _costoEnOroEspadachin = 50;
    private final int _vidaMaximaEspadachin = 100;

    public int obtenerCostoEnOroAldeano(){
        return _costoEnOroAldeano;
    }
    public Aldeano crearAldeano() {
        return new Aldeano(_vidaMaximaAldeano, new EdificiosEnConstruccionFabrica());
    }

    public int obtenerCostoEnOroArquero() {
        return _costoEnOroArquero;
    }
    public Arquero crearArquero() {
        return new Arquero(_vidaMaximaArquero);
    }

    public int obtenerCostoEspadachin(){
        return _costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(){
        return new Espadachin(_vidaMaximaEspadachin);
    }

}
