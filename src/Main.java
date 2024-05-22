import ejercicios.ej2.CaminoMasCorto;
import ejercicios.ej2.Casilla;
import ejercicios.ej2.Laberinto;
import ejercicios.ej3.SumaDeSubconjuntos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Laberinto laberinto = new Laberinto(4);

        // Fila 1
        laberinto.setCasilla(0, 0, new Casilla(4, false, true, true, false, 0, 0));
        laberinto.setCasilla(0, 1, new Casilla(10, false, true, true, true, 0, 1));
        laberinto.setCasilla(0, 2, new Casilla(8, false, true, true, true, 0, 2));
        laberinto.setCasilla(0, 3, new Casilla(17, false, true, false, true, 0, 3));

        // Fila 2
        laberinto.setCasilla(1, 0, new Casilla(1, true, true, true, false, 1, 0));
        laberinto.setCasilla(1, 1, new Casilla(3, true, true, true, true, 1, 1));
        laberinto.setCasilla(1, 2, new Casilla(9, true, true, true, true, 1, 2));
        laberinto.setCasilla(1, 3, new Casilla(15, true, true, false, true, 1, 3));
        // Fila 3
        laberinto.setCasilla(2, 0, new Casilla(7, true, true, true, false, 2, 0));
        laberinto.setCasilla(2, 1, new Casilla(5, true, true, true, true, 2, 1));
        laberinto.setCasilla(2, 2, new Casilla(2, true, true, true, true, 2, 2));
        laberinto.setCasilla(2, 3, new Casilla(28, true, true, false, true, 2, 3));
        // Fila 4
        laberinto.setCasilla(3, 0, new Casilla(20, true, false, true, false, 3, 0));
        laberinto.setCasilla(3, 1, new Casilla(6, true, false, true, true, 3, 1));
        laberinto.setCasilla(3, 2, new Casilla(35, true, false, true, true, 3, 2));
        laberinto.setCasilla(3, 3, new Casilla(13, true, false, false, true, 3, 3));

        CaminoMasCorto caminoMasCorto = new CaminoMasCorto(laberinto);
        List<Casilla> camino = caminoMasCorto.getCaminoMasCorto(0, 0, 2, 2);

        System.out.println("Casillero que forman parte del camino más corto:");
        for (Casilla casilla : camino) {
            System.out.println("Casilla (" + casilla.getFila() + ", " + casilla.getColumna() + ") con valor " + casilla.getValor());


        }
        System.out.println("Longitud/sumatoria de valores del camino más corto: " + caminoMasCorto.getLongitudMasCorta());

        /*EJERCICIO 3-------------------------------------------------*/
        SumaDeSubconjuntos sds = new SumaDeSubconjuntos();
        ArrayList<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(3);
        conjunto.add(8);
        conjunto.add(7);
        conjunto.add(2);
        conjunto.add(5);
        int m = 15;
        sds.sumaSubconjuntos(conjunto, m);
        System.out.println("EJERCICIO 3 -------------------");
        System.out.println("Subconjuntos que suman  " + m + ": " + sds.getResultados());


    }
}