package atenea.fiuba.algoIII.ageoOfEmpires;

public class EdificiosFabrica {

    private UnidadesFabrica fabricaDeUnidades = new UnidadesFabrica();
    private IEstrategiaAtaque<Castillo> estrategiaAtaqueCastillo = new EstrategiaAtaqueCastillo();


    public PlazaCentral crearPlazaCentral(){
        return new PlazaCentral(new PosicionDeUnCasillero(0,0), fabricaDeUnidades);
    }

    public Cuartel crearCuartel(){
        return new Cuartel(new PosicionDeUnCasillero(0,0), fabricaDeUnidades);
    }

    public Castillo crearCastillo(){
        return new Castillo(new PosicionDeUnCasillero(0,0), fabricaDeUnidades, estrategiaAtaqueCastillo);
    }

}
