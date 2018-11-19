package atenea.fiuba.algoIII.ageoOfEmpires;

public abstract class EdificioReparable implements IEdificioReparable, IEdificioAtacable {

    private final int VIDA_MAXIMA;
    private final int VELOCIDAD_DE_REPARACION;

    protected int vidaActual;
    private IEstadoReparador _reparadorActivo;

    protected EdificioReparable(int vidaMaxima, int velocidadDeReparacion){
        this.VIDA_MAXIMA = vidaMaxima;
        this.vidaActual = VIDA_MAXIMA;
        this.VELOCIDAD_DE_REPARACION = velocidadDeReparacion;
    }

    public int getVida(){
        return this.vidaActual;
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

    @Override // IEdificioAtacable
    public void recibirDanio(int danio) {
        this.vidaActual -= danio;
    }

}
