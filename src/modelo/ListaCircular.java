package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListaCircular<Jugador> extends LinkedList<Jugador> {

    private int posicionActual = 0;

    public Jugador get(int index)
    {
        if (index == -1)
        {
            index = size()-1;
        }

        else if (index == size())
        {
            index = 0;
        }

        return super.get(index);
    }



    public Jugador getSiguiente(){
        if (posicionActual<= this.size()){
            posicionActual = posicionActual + 1;
            return this.get(posicionActual);
        }
        else {
            posicionActual = 0;
            return this.getFirst();
        }

    }

}
