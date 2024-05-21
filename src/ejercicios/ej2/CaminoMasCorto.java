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
        this.longitudMasCorta=Integer.MAX_VALUE;
        this.casillasVisitadas= new ArrayList<>();
        this.caminoMasCorto=new ArrayList<>();
    }
    public int getLongitudMasCorta() {
        return longitudMasCorta;
    }

    public List<Casilla> getCaminoMasCorto(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino){
        this.casillasVisitadas.clear();
        this.caminoMasCorto.clear();
        this.longitudMasCorta = Integer.MAX_VALUE;

        Integer longitudParcial=0;
        List<Casilla>caminoParcial=new ArrayList<>();
        Casilla origen=this.laberinto.getCasilla(filaOrigen, columnaOrigen);
        Casilla destino=this.laberinto.getCasilla(filaDestino, columnaDestino);

        caminoParcial.add(origen);
        casillasVisitadas.add(origen);

        getCaminoMasCortoRecursivo(origen, destino, caminoParcial, longitudParcial);

        return this.caminoMasCorto;
    }



    private void getCaminoMasCortoRecursivo(Casilla origen, Casilla fin, List<Casilla>caminoParcial, int longitudMasCortaParcial){
        longitudMasCortaParcial=longitudMasCortaParcial + origen.getValor();

        if(origen.equals(fin)){
            if(longitudMasCortaParcial<longitudMasCorta){
                longitudMasCorta=longitudMasCortaParcial;
                caminoMasCorto.clear();
                caminoMasCorto.addAll(caminoParcial);
            }
        }
        else {
            int[] dx = {-1, 1, 0, 0}; //movimiento en la fila: norte -1 y sur 1
            int[] dy = {0, 0, 1, -1}; //movimientos en la columna: este 1  y oeste -1
            boolean[] direcciones = {origen.puedoIrAlNorte(), origen.puedoIrAlSur(), origen.puedoIrAlEste(), origen.puedoIrAlOeste()};

            for (int i = 0; i < 4; i++) {
                int nuevaFila = origen.getFila() + dx[i];
                int nuevaColumna = origen.getColumna() + dy[i];

                if (nuevaFila >= 0 && nuevaColumna >= 0 && nuevaFila < laberinto.getTamanio() && nuevaColumna < laberinto.getTamanio() && direcciones[i]) {
                    Casilla siguiente = laberinto.getCasilla(nuevaFila, nuevaColumna);
                    if (!casillasVisitadas.contains(siguiente)) {
                        caminoParcial.add(siguiente);
                        casillasVisitadas.add(siguiente);

                        getCaminoMasCortoRecursivo(siguiente, fin, caminoParcial, longitudMasCortaParcial);

                        // Backtracking
                        caminoParcial.remove(siguiente);
                        casillasVisitadas.remove(siguiente);
                    }
                }
            }
        }


        


    }




}
