package modelo.unidades;

import java.util.LinkedList;

public class Ejercito {

    LinkedList<UnidadMilitar> unidadesEjercito;

    public Ejercito(){
        this.unidadesEjercito = new LinkedList<>();
    }

    public void agregarUnidad(UnidadMilitar unidadMilitar){
        this.unidadesEjercito.addLast(unidadMilitar);
    }

    public void borrarCadaveres(){
        for(int i=0; i < this.unidadesEjercito.size(); i++){
            if (this.unidadesEjercito.get(i).estaMuerto()){
                this.unidadesEjercito.remove(i);
            }
        }
    }

    public int cantidadDeSoldados(){
        return this.unidadesEjercito.size();
    }
}