package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosFabrica {

    private UnidadesFabrica _fabricaDeUnidades = new UnidadesFabrica();


    public PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(_fabricaDeUnidades);
    }

    public Cuartel crearCuartel(){
        return new Cuartel(_fabricaDeUnidades);
    }

    public Castillo crearCastillo(){
        return new Castillo(_fabricaDeUnidades);
    }

}
