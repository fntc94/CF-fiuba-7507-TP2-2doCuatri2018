package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.LinkedList;

public class Edificios {

    private LinkedList<Edificio> edificios;

    public Edificios(){
        this.edificios = new LinkedList<>();
    }


    public Unidad crearUnidad(PlazaCentral plazaCentral){
      if (this.edificios.contains(plazaCentral)){
           return plazaCentral.construirAldeano();
      }
      else{
          throw new EdificioInexistenteException();
      }
    }

    public void agregarEdificio(Edificio edificio){
        this.edificios.addLast(edificio);
    }

    public void removerEdificio(PlazaCentral plazaCentral){
        this.edificios.removeFirstOccurrence(plazaCentral);
    }

}
