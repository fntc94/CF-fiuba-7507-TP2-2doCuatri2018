package atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.IPerteneciente;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.excepciones.UnidadNoEsPropiaException;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.Unidad;

import java.util.LinkedList;

public class Ejercito implements IPerteneciente {

    LinkedList<UnidadMilitar> unidadesEjercito;

    public Ejercito(){
        this.unidadesEjercito = new LinkedList<>();
    }

    public void agregarUnidad(UnidadMilitar unidadMilitar){
        this.unidadesEjercito.addLast(unidadMilitar);
    }

    public void incluyeA(Unidad unidadMilitar){
        if (! (this.unidadesEjercito.contains(unidadMilitar))){
            throw new UnidadNoEsPropiaException();
        }
    }

   /*
    public void actualizarVidaDeUnidadesMilitares(){
        for (UnidadMilitar unidadMilitar : this.unidadesEjercito) {
            if (unidadMilitar.);
        }
    }
    */
}