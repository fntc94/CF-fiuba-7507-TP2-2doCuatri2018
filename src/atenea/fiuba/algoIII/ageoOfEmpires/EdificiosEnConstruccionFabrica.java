package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosEnConstruccionFabrica {

    private UnidadesFabrica fabricaDeUnidades = new UnidadesFabrica();

    public EdificioEnConstruccion<PlazaCentral> obtenerPlazaCentralEnConstruccion(){

        int turnosEnConstruir = 3;
        int vidaMaximaPlazaCentral = 450;
        return new EdificioEnConstruccion<>(turnosEnConstruir, new PlazaCentral(vidaMaximaPlazaCentral, fabricaDeUnidades));

    }

    public EdificioEnConstruccion<Cuartel> obtenerCuartelEnConstruccion(){

        int turnosEnConstruir = 3;
        int vidaMaximaCuartel = 250;
        return new EdificioEnConstruccion<>(turnosEnConstruir, new Cuartel(vidaMaximaCuartel, fabricaDeUnidades));
    }

}
