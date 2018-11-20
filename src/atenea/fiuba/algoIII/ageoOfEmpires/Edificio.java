package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class Edificio implements IPosicionable, IEdificioReparable, IAtacable  {

    private Posicion _posicion;
    private final int VIDA_MAXIMA;
    private final int VELOCIDAD_DE_REPARACION;

    protected int vidaActual;
    private IEstadoReparador _reparadorActivo;

    protected Edificio(Posicion posicion, int vidaMaxima, int velocidadDeReparacion){
        _posicion = posicion;
        this.VIDA_MAXIMA = vidaMaxima;
        this.vidaActual = VIDA_MAXIMA;
        this.VELOCIDAD_DE_REPARACION = velocidadDeReparacion;
    }

    public int getVida(){
        return this.vidaActual;
    }

    public Posicion getPosicion(){
        return _posicion;
    }

    @Override // IEdificioReparable
    public void recibirReparador(IEstadoReparador reparador) {

        if(_reparadorActivo == null){
            _reparadorActivo = reparador;
        }

        else if (_reparadorActivo != reparador){
            return;
        }

        vidaActual += VELOCIDAD_DE_REPARACION;

        if(this.vidaActual > this.VIDA_MAXIMA){
            this.vidaActual = this.VIDA_MAXIMA;
            _reparadorActivo.darPorTerminadaLaReparacion();
        }
    }

    @Override // IAtacable
    public void recibirAtaque(IAtacante atacante) {

        int danio = atacante.obtenerDanio(this);

        if(this.vidaActual <= danio){
            this.vidaActual = 0;
            return;
        }

        this.vidaActual -= danio;
    }

}
