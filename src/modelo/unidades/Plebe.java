package modelo.unidades;

import java.util.LinkedList;

public class Plebe {

    private LinkedList<Aldeano> aldeanos;

    public Plebe(){
        this.aldeanos = new LinkedList<>();
    }

    public void agregar(Aldeano aldeano){
        this.aldeanos.addLast(aldeano);
    }


    public int trabajar(){
        int oroRecolectado = 0;
        for (Aldeano aldeano : this.aldeanos) {
            oroRecolectado = oroRecolectado + aldeano.trabajar();
        }
        return oroRecolectado;
    }

    public void borrarCadaveres(){
        for(int i=0; i < this.aldeanos.size(); i++){
            if (this.aldeanos.get(i).estaMuerto()){
                this.aldeanos.remove(i);
            }
        }
    }

    public int cantidadDeAldeanos(){
        return this.aldeanos.size();
    }
}
