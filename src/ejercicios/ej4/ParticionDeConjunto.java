package ejercicios.ej4;

import java.util.ArrayList;
import java.util.List;

public class ParticionDeConjunto {
    private List<Integer>conjunto;
    private List<Integer>subconjunto1;
    private List<Integer> subconjunto2;
    private List<List<Integer>>resultados;

    public ParticionDeConjunto(List<Integer>conjunto){
        this.conjunto=conjunto;
        this.subconjunto1=new ArrayList<>();
        this.subconjunto2=new ArrayList<>();
        this.resultados=new ArrayList<>();
    }
    public int sumaDelConjunto(){
        int resultado=0;
        for (Integer numero : conjunto) {
            resultado += numero;
        }
        return resultado;
    }
    public List<List<Integer>> puedeParticionarse(){
        if (this.sumaDelConjunto() % 2 != 0) {
            return resultados;
        }
        // Quiero encontrar subconjuntos que sumen la mitad del total
        int sumaObjetivo = this.sumaDelConjunto() / 2;

        if (backtrack(sumaObjetivo, 0)) {
            resultados.add(new ArrayList<>(subconjunto1));
            resultados.add(new ArrayList<>(subconjunto2));
        }

        return resultados;
    }
    public boolean backtrack(int sumaObjetivo, int startIndex ){
        if (sumaObjetivo == 0) {
            for (int i = startIndex; i < conjunto.size(); i++) {
                subconjunto2.add(conjunto.get(i));
            }
            return true;
        }
        if (sumaObjetivo < 0 || startIndex >= conjunto.size()) {
            return false;
        }

        for (int i = startIndex; i < conjunto.size(); i++) {
            int num = conjunto.get(i);
            subconjunto1.add(num);

            if (backtrack(sumaObjetivo - num, i + 1)) {
                return true;
            }

            subconjunto1.remove(subconjunto1.size() - 1);  // backtrack
        }
        return false;
    }



    public List<Integer> getConjunto() {
        return conjunto;
    }

    public List<List<Integer>> getResultados() {
        return resultados;
    }
}
