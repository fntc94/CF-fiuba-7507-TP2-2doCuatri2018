package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionDeUnCasillero;

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
        IEstrategiaAtaque estrategiaAtaqueArquero = new EstrategiaAtaqueArquero();
        return new Arquero(null, estrategiaAtaqueArquero);
    }

    public int obtenerCostoEspadachin(){
        return _costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(){
        IEstrategiaAtaque estrategiaAtaqueEspadachin = new EstrategiaAtaqueEspadachin();
        return new Espadachin(new PosicionDeUnCasillero(0,0),estrategiaAtaqueEspadachin);

    }

    public int obtenerCostoArmaDeAsedio(){
        return _costoEnOroArmaDeAsedio;
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        IEstrategiaAtaque estrategiaAtaqueArmaDeAsedio = new EstrategiaAtaqueArmaDeAsedio();
        return new ArmaDeAsedio(new PosicionDeUnCasillero(0,0), estrategiaAtaqueArmaDeAsedio);
    }

}
