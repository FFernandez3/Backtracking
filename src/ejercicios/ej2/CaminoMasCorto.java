package ejercicios.ej2;


import java.util.ArrayList;
import java.util.List;

/*Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
booleanos, uno para cada dirección a la que se permite ir desde allí*/
public class CaminoMasCorto {
    private Laberinto laberinto;
    private int longitudMasCorta;
    private List<Casilla>caminoMasCorto;
    private List<Casilla> casillasVisitadas;
    public CaminoMasCorto(Laberinto laberinto){
        this.laberinto=laberinto;
        this.longitudMasCorta=0;
        this.casillasVisitadas= new ArrayList<>();
        this.caminoMasCorto=new ArrayList<>();
    }

    public List<Casilla> getCaminoMasCorto(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino){

    }




}
