package atenea.fiuba.algoIII.ageoOfEmpires;

public class AldeanoReparador  implements IReparadorDeEdificios {

    private IEdificioReparable _edificioReparable;

    public AldeanoReparador(IEdificioReparable edificioReparable){
        _edificioReparable = edificioReparable;
    }

    @Override
    public void reparar(IEdificioReparable edificioReparable){
        this._edificioReparable = edificioReparable;
        _edificioReparable.recibirReparador(this);
    }

    @Override
    public void reparar(){
        _edificioReparable.recibirReparador(this);
    }
}
