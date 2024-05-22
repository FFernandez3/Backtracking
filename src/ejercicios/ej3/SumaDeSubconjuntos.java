package ejercicios.ej3;

import java.util.ArrayList;
import java.util.List;

public class SumaDeSubconjuntos {
    private List<List<Integer>>resultados;
    public SumaDeSubconjuntos(){
        this.resultados=new ArrayList<List<Integer>>();
    }
    public List<List<Integer>> getResultados() {
        return resultados;
    }
   public List<List<Integer>>sumaSubconjuntos(ArrayList<Integer>conjunto, int m){
       List<Integer> resultadoParcial = new ArrayList<>();
       backtrack(resultadoParcial, conjunto, m, 0, 0);
       return this.resultados;
   }
   private void backtrack(List<Integer> resultadoParcial, ArrayList<Integer>conjunto, int m, int inicio, int sumaParcial ){
        if(sumaParcial==m){
            this.resultados.add(new ArrayList<>(resultadoParcial));
            return;
        }  //PODA
        else if (sumaParcial>m) {
            return;
        }

       for (int i = inicio; i < conjunto.size(); i++) {
           //cambio estado
           resultadoParcial.add(conjunto.get(i));
           //recursion
           backtrack(resultadoParcial, conjunto, m, i + 1, sumaParcial + conjunto.get(i));
           //vuelvo al estado anterior
           resultadoParcial.remove(resultadoParcial.size() - 1);
       }
   }
}
