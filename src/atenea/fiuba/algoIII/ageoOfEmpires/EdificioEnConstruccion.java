package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class EdificioEnConstruccion<TEdificio> {


    private int _turnosEnConstruir;
    private int _turnosEnConstruccion = 0;

    protected abstract TEdificio _crearEdificio();

    public EdificioEnConstruccion(int turnosEnConstruir){
        _turnosEnConstruir = turnosEnConstruir;
    }

    public void avanzarConstruccion(){
        _turnosEnConstruccion += 1;
    }

    public Boolean estaTerminado(){
        return _turnosEnConstruccion == _turnosEnConstruir;
    }

    public TEdificio obtenerEdificioTerminado(){
        return this._crearEdificio();
    }

}
