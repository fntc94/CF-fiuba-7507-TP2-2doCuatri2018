package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.EdificioNoEsPropioException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Edificio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.ArmaDeAsedio;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Arquero;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Espadachin;


import java.util.LinkedList;

public class Construcciones {

    private LinkedList<Edificio> construcciones;

    public Construcciones(){
        this.construcciones = new LinkedList<>();
    }


    public Aldeano crearUnidad(PlazaCentral plazaCentral){
        this.incluyeA(plazaCentral);
        return plazaCentral.construirAldeano();
    }

    public ArmaDeAsedio crearArmaDeAsedio(Castillo castillo){
        this.incluyeA(castillo);
        return castillo.crearArmaDeAsedio();
    }


    public Arquero crearArquero(Cuartel cuartel){
        this.incluyeA(cuartel);
        return cuartel.crearArquero();
    }

    public Espadachin crearEspadachin(Cuartel cuartel){
        this.incluyeA(cuartel);
        return cuartel.crearEspadachin();
    }


    public void agregarEdificio(Edificio edificio){
        this.construcciones.addLast(edificio);
    }


    private void incluyeA(Edificio edificio){
        if (! (this.construcciones.contains(edificio))){
            throw new EdificioNoEsPropioException();
        }
    }

}
