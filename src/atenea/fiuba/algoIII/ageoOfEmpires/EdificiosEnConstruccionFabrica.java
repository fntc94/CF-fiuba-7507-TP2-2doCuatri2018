package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosEnConstruccionFabrica {

    private EdificiosFabrica _fabricaDeEdificio = new EdificiosFabrica();

    public EdificioEnConstruccion<PlazaCentral> obtenerPlazaCentralEnConstruccion(){

        int turnosEnConstruir = 3;
        return new EdificioEnConstruccion<>(turnosEnConstruir, _fabricaDeEdificio.crearPlazaCentral());

    }

    public EdificioEnConstruccion<Cuartel> obtenerCuartelEnConstruccion(){

        int turnosEnConstruir = 3;
        return new EdificioEnConstruccion<>(turnosEnConstruir, _fabricaDeEdificio.crearCuartel());
    }

}
