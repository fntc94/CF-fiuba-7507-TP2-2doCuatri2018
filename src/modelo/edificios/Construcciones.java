package modelo.edificios;

import modelo.Edificio;


import java.util.LinkedList;

public class Construcciones {

    private LinkedList<Edificio> construcciones;

    public Construcciones(){
        this.construcciones = new LinkedList<>();
    }


    public void agregarEdificio(Edificio edificio){
        this.construcciones.addLast(edificio);
    }

    public void limpiarEscombros(){
        for(int i=0; i < this.construcciones.size(); i++){
            if (!this.construcciones.get(i).sigueEnPie()){
                this.construcciones.remove(i);
            }
        }
    }
}
