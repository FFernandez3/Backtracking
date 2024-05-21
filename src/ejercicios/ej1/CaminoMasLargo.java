package ejercicios.ej1;

import entidades.Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
puerta es un arco dirigido hacia otra habitación.*/
public class CaminoMasLargo {
    private Grafo<Integer> salas;
    private List<Integer> caminoMasLargo;
    private List<Integer>visitados;

    public CaminoMasLargo(Grafo<Integer>grafo){
        caminoMasLargo=new ArrayList<>();
        this.visitados=new ArrayList<>();
        salas=grafo;
    }

    public List<Integer>caminoMayor(int entrada, int salida){
        this.visitados.clear();
        this.caminoMasLargo.clear();

        //configuro estado inicial
        ArrayList<Integer>caminoParcial=new ArrayList<>();
        caminoParcial.add(entrada);
        this.visitados.add(entrada);
        caminoMayorRecursivo(entrada, salida, caminoParcial);
        return this.caminoMasLargo;

    }
    private void caminoMayorRecursivo(int entrada, int salida, ArrayList<Integer>caminoParcial){
        if(entrada==salida){//si el origen es igual al destino
            if(caminoParcial.size()>=caminoMasLargo.size()){
                this.caminoMasLargo.clear();
                this.caminoMasLargo.addAll(caminoParcial);
            }
        }
        else {
            Iterator<Integer>it=this.salas.obtenerAdyacentes(entrada);
            while (it.hasNext()){
                Integer adyacente=it.next();
                if(!this.visitados.contains(adyacente)){
                    //actualizo estado
                    caminoParcial.add(adyacente);
                    this.visitados.add(adyacente);
                    //llamada recursiva
                    caminoMayorRecursivo(adyacente, salida, caminoParcial);
                    //deshago cambios en el estado, vuelvo al estado anterior
                    caminoParcial.remove(adyacente);
                    this.visitados.remove(adyacente);
                }
            }
        }
    }

}
