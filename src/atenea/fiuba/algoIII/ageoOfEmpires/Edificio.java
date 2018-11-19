package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class Edificio implements IEdificioReparable, IAtacable  {

    private final int VIDA_MAXIMA;
    private final int VELOCIDAD_DE_REPARACION;

    protected int vidaActual;
    private IEstadoReparador _reparadorActivo;

    protected Edificio(int vidaMaxima, int velocidadDeReparacion){
        this.VIDA_MAXIMA = vidaMaxima;
        this.vidaActual = VIDA_MAXIMA;
        this.VELOCIDAD_DE_REPARACION = velocidadDeReparacion;
    }

    public int getVida(){
        return this.vidaActual;
    }

    public Posicion getPosicion(){
        // TODO: recibir en constructor
        return null;
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
