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

    public void setCasilla(int fila, int columna, Casilla casilla) {
        tablero[fila][columna] = casilla;
    }

    public int getTamanio() {
        return tamanio;
    }


}
