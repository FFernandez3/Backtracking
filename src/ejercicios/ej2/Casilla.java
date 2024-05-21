package ejercicios.ej2;

public class Casilla {
    private int valor;
    private boolean norte, sur, este, oeste;

    public Casilla(int valor, boolean norte, boolean sur, boolean este, boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
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
}
