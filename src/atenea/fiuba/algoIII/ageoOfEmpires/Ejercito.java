package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.LinkedList;

public class Ejercito {

    LinkedList<Unidad> unidadesEjercito;

    public Ejercito(){
        this.unidadesEjercito = new LinkedList<>();
    }

    public void agregarUnidad(Unidad unidad){
        this.unidadesEjercito.addLast(unidad);
    }
}
