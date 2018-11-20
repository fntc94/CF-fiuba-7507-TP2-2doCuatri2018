package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.*;
import java.util.function.Consumer;

public class ColaDeConstruccion {

    private LinkedList<Aldeano> colaDeConstruccion;

    public ColaDeConstruccion(){
        this.colaDeConstruccion = new LinkedList<>();
    }

    public void actualizarColaDeConstruccion(Aldeano aldeano){
        colaDeConstruccion.add(aldeano);

    }

    public void avanzarConstruccion(Consumer<Aldeano> accionAlTerminar){
        accionAlTerminar = accionAlTerminar != null ? accionAlTerminar : aldeanoLibre -> { };

        int cantidad = 0;

        if(this.colaDeConstruccion.isEmpty()){
            throw (new OperacionInvalidaDadoElEstadoActualDelObjetoExcepcion());
        }

       while ( (cantidad < this.colaDeConstruccion.size()) && !(this.colaDeConstruccion.isEmpty()) ){
           Aldeano aldeano = this.colaDeConstruccion.get(cantidad);
           aldeano.continuarConstruyendo();
           cantidad++;
           if(!aldeano.estaConstruyendo()){
               accionAlTerminar.accept(this.colaDeConstruccion.pop());
               cantidad = 0;
           }
       }

    }

}
