package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosFabrica {

    private UnidadesFabrica _fabricaDeUnidades = new UnidadesFabrica();


    public PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(new PosicionDeUnCasillero(0,0),_fabricaDeUnidades);
    }

    public Cuartel crearCuartel(){
        return new Cuartel(new PosicionDeUnCasillero(0,0),_fabricaDeUnidades);
    }

    public Castillo crearCastillo(){
        return new Castillo(new PosicionDeUnCasillero(0,0),_fabricaDeUnidades);
    }

}
