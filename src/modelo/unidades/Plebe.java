package modelo.unidades;

import modelo.excepciones.UnidadNoEsPropiaException;

import java.util.LinkedList;

public class Plebe {

    private LinkedList<Aldeano> aldeanos;

    public Plebe(){
        this.aldeanos = new LinkedList<>();
    }

    public void agregar(Aldeano aldeano){
        this.aldeanos.addLast(aldeano);
    }

    public void incluyeA(Aldeano aldeano){
        if (! (this.aldeanos.contains(aldeano))){
            throw new UnidadNoEsPropiaException();
        }
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
}
