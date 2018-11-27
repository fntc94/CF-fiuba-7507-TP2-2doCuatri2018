package atenea.fiuba.algoIII.ageoOfEmpires.modelo.edificios;


import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Ejercito;
import atenea.fiuba.algoIII.ageoOfEmpires.modelo.unidades.Plebe;

public class ColeccionDePosisionables {

    private Ejercito ejercito;
    private Plebe plebe;
    private Construcciones construcciones;
    private EdificiosFabrica edificiosFabrica;

    public ColeccionDePosisionables(){
        this.plebe = new Plebe();
        this.ejercito = new Ejercito();
        this.construcciones = new Construcciones();
        this.edificiosFabrica = new EdificiosFabrica();
    }

}