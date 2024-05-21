package ejercicios.ej2;

public class Laberinto {
    //es una matriz cuadrada por ende es de NxN
    private Casilla[][] tablero;
    private int tamanio;

    public Laberinto(int tamanio) {
        this.tamanio = tamanio;
        this.tablero=new Casilla[tamanio][tamanio];
    }
    public Casilla getCasilla(int fila, int columna){
        return tablero[fila][columna];
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
