package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosFabrica {

    private UnidadesFabrica _fabricaDeUnidades = new UnidadesFabrica();

    private final int VIDA_PLAZA_CENTRAL = 450;
    private final int VIDA_CUARTEL = 450;
    private final int VIDA_CASTILLO = 450;


    public PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(VIDA_PLAZA_CENTRAL, _fabricaDeUnidades);
    }

    public Cuartel crearCuartel(){
        return new Cuartel(VIDA_CUARTEL, _fabricaDeUnidades);
    }

    public Castillo crearCastillo(){
        return new Castillo(VIDA_CASTILLO, _fabricaDeUnidades);
    }

}
