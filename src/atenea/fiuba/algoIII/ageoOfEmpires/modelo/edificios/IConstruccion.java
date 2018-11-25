package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;

import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Aldeano;

import java.util.function.Consumer;

public interface IConstruccion<TEdificio> {

    void recibirConstructor(Aldeano aldeano);
    void onConstruccionTerminada(Consumer<TEdificio> contruccionTerminadaHanlder);

}
