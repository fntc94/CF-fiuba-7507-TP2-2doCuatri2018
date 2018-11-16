package atenea.fiuba.algoIII.ageoOfEmpires;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Jugador {
    private Castillo castillo;
    private PlazaCentral plazaCentral;
    private Cuartel cuartel;


    public Jugador (){
        EdificiosFabrica edificiosFabrica = new EdificiosFabrica();
        castillo = edificiosFabrica.crearCastillo();
        plazaCentral = edificiosFabrica.crearPlazaCentral();
        cuartel = edificiosFabrica.crearCuartel();
    }

    public int tienePlazaCentral(){
        return plazaCentral.getVida();
    }

    public int tienePlazaCuartel(){
        return cuartel.getVida();
    }





}
