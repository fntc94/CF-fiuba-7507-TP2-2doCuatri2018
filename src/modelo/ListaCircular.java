package modelo;

import java.util.LinkedList;

public class ListaCircular<Jugador> extends LinkedList<Jugador> {

    private int posicionActual = 0;

    public Jugador getSiguiente(){
        if (posicionActual < (this.size()-1)& this.size()>1){
            posicionActual = posicionActual + 1;
        }
        else{
            posicionActual = 0;
        }
        return this.get(posicionActual);
    }
}
