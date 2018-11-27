package modelo.edificios;

import modelo.unidades.Aldeano;

import java.util.function.Consumer;

public interface IConstruccion<TEdificio> {

    void recibirConstructor(Aldeano aldeano);
    void onConstruccionTerminada(Consumer<TEdificio> contruccionTerminadaHanlder);

}
