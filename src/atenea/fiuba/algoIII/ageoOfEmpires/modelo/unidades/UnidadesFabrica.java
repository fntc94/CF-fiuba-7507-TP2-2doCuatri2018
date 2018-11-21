package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IEstrategiaAtaque;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios.*;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.posicion.PosicionDeUnCasillero;

public class UnidadesFabrica implements IUnidadesPlazaCentralFabrica, IUnidadesCuartelFabrica, IUnidadesCastilloFabrica {

    private final int costoEnOroAldeano = 25;
    private final int costoEnOroArquero = 75;
    private final int costoEnOroEspadachin = 50;
    private final int costoEnOroArmaDeAsedio = 200;

    public int obtenerCostoAldeano(){
        return this.costoEnOroAldeano;
    }
    public Aldeano crearAldeano() {
        return new Aldeano(new PosicionDeUnCasillero(0,0), new EdificiosEnConstruccionFabrica());
    }

    public int obtenerCostoArquero() {
        return this.costoEnOroArquero;
    }
    public Arquero crearArquero() {
        IEstrategiaAtaque estrategiaAtaqueArquero = new EstrategiaAtaqueArquero();
        return new Arquero(null, estrategiaAtaqueArquero);
    }

    public int obtenerCostoEspadachin(){
        return this.costoEnOroEspadachin;
    }
    public Espadachin crearEspadachin(){
        IEstrategiaAtaque estrategiaAtaqueEspadachin = new EstrategiaAtaqueEspadachin();
        return new Espadachin(new PosicionDeUnCasillero(0,0),estrategiaAtaqueEspadachin);

    }

    public int obtenerCostoArmaDeAsedio(){
        return this.costoEnOroArmaDeAsedio;
    }

    public ArmaDeAsedio crearArmaDeAsedio(){
        IEstrategiaAtaque estrategiaAtaqueArmaDeAsedio = new EstrategiaAtaqueArmaDeAsedio();
        return new ArmaDeAsedio(new PosicionDeUnCasillero(0,0), estrategiaAtaqueArmaDeAsedio);
    }

}
