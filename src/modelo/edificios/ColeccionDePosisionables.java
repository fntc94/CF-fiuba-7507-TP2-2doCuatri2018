package modelo.edificios;


import modelo.unidades.Ejercito;
import modelo.unidades.Plebe;

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