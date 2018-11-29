package modelo.edificios;

import modelo.excepciones.EdificioNoEsPropioException;
import modelo.Edificio;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;


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


    public void incluyeA(Edificio edificio){
        if (! (this.construcciones.contains(edificio))){
            throw new EdificioNoEsPropioException();
        }
    }

    public void limpiarEscombros(){
        for(int i=0; i < this.construcciones.size(); i++){
            if (!this.construcciones.get(i).sigueEnPie()){
                this.construcciones.remove(i);
            }
        }
    }
}
