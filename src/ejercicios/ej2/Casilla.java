package ejercicios.ej2;

public class Casilla {
    private int valor;
    private boolean norte, sur, este, oeste;
    private int fila, columna;

    public Casilla(int valor, boolean norte, boolean sur, boolean este, boolean oeste, int fila, int columna) {
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
        this.fila=fila;
        this.columna=columna;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean puedoIrAlNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public boolean puedoIrAlSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean puedoIrAlEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public boolean puedoIrAlOeste() {
        return oeste;
    }
    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casilla casilla = (Casilla) o;

        if (fila != casilla.fila) return false;
        return columna == casilla.columna;
    }

    @Override
    public int hashCode() {
        int result = fila;
        result = 31 * result + columna;
        return result;
    }
}
