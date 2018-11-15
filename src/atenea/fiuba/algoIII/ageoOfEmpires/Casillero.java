package atenea.fiuba.algoIII.ageoOfEmpires;

public class Casillero {
    private int coordenadaEnX;
    private int coordenadaEnY;

    public Casillero(int x, int y) {
        this.coordenadaEnX = x;
        this.coordenadaEnY = y;
    }

    public int getCoordenadaEnX() {
        return this.coordenadaEnX;
    }

    public int getCoordendadaEnY(){
        return this.coordenadaEnY;
    }

    @Override
    public boolean equals(Object obj) {
        //Si me pasan algo que no sea un casillero va a ser diferente
        if (!(obj instanceof Casillero)) {
            return false;
        }
        //Si comparo a un casillero consigo mismo va a ser igual
        if (obj == this) {
            return true;
        }
        //Casteo el tipo Object

        Casillero other = (Casillero) obj;

        int x = other.getCoordenadaEnX();
        int y = other.getCoordendadaEnY();

        return (this.coordenadaEnX == x && this.coordenadaEnY == y);
    }
}
