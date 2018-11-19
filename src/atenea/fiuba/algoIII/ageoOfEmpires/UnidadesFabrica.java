package atenea.fiuba.algoIII.ageoOfEmpires;

public class UnidadesFabrica implements IUnidadesPlazaCentralFabrica, IUnidadesCuartelFabrica, IUnidadesCastilloFabrica {

    private final int _costoEnOroAldeano = 25;
    private final int _costoEnOroArquero = 75;
    private final int _costoEnOroEspadachin = 50;
    private final int _costoEnOroArmaDeAsedio = 200;

    public int obtenerCostoAldeano(){
        return _costoEnOroAldeano;
    }
    public Aldeano crearAldeano() {
        return new Aldeano(new PosicionDeUnCasillero(0,0), new EdificiosEnConstruccionFabrica());
    }

    public int obtenerCostoArquero() {
        return _costoEnOroArquero;
    }
    public Arquero crearArquero() {
        return new Arquero(null);
    }

    public int obtenerCostoEspadachin(){
        return _costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(){
        return new Espadachin(new PosicionDeUnCasillero(0,0));

    }

    public int obtenerCostoArmaDeAsedio(){
        return _costoEnOroArmaDeAsedio;
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        return new ArmaDeAsedio(new PosicionDeUnCasillero(0,0));
    }

}
