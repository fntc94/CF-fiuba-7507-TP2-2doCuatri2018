package atenea.fiuba.algoIII.ageoOfEmpires;

import org.mockito.Mockito;

public class AtacablesSustitutosFabrica {


    private IPosicionable _atacante;

    public AtacablesSustitutosFabrica(IPosicionable atacante){

        _atacante = atacante;
    }

    private Posicion crearPosicionParaSustituto(IPosicionable atacante, int distancia){
        Posicion posicionAtacante = atacante.getPosicion();
        Posicion posicionAtacado = Mockito.mock(Posicion.class);
        Mockito.when(posicionAtacante.distanciaA(posicionAtacado)).thenReturn(distancia);
        return posicionAtacado;
    }

    public Aldeano crearAldeanoADistancia(int distancia){
        Posicion posicionAldeano = this.crearPosicionParaSustituto(_atacante, 1);
        return new Aldeano(posicionAldeano, Mockito.mock(EdificiosEnConstruccionFabrica.class));
    }

    public Espadachin crearEspadachinADistancia(int distancia){
        Posicion posicionEspadachin = this.crearPosicionParaSustituto(_atacante, distancia);
        return new Espadachin(posicionEspadachin);
    }

    public Arquero crearArqueroADistancia(int distancia){
        Posicion posicionArquero = this.crearPosicionParaSustituto(_atacante, distancia);
        return new Arquero(posicionArquero);
    }

    public ArmaDeAsedio crearArmaDeAsedioADistancia(int distancia){
        Posicion posicionArmaDeAsedio = this.crearPosicionParaSustituto(_atacante, distancia);
        return new ArmaDeAsedio(posicionArmaDeAsedio);
    }

}
