package ejercicios.ej5;

import java.util.ArrayList;
import java.util.List;

/*Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas.*/

public class Backtracking {
    private List<Tarea> tareas;
    private int cantProcesadores;
    private int[] tiemposProcesadores;
    private int tiempoMinimo;
    private List<List<Tarea>> mejorAsignacion;
    private List<List<Tarea>> asignacionActual;

    public Backtracking(List<Tarea> tareas, int m) {
        this.tareas = tareas;
        this.cantProcesadores = m;
        this.tiemposProcesadores = new int[m];
        this.tiempoMinimo = Integer.MAX_VALUE;
        this.mejorAsignacion = new ArrayList<>();
        this.asignacionActual = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            mejorAsignacion.add(new ArrayList<>());
            asignacionActual.add(new ArrayList<>());
        }
    }

    public int minimizarTiempoEjecucion() {
        backtrack(0);
        return tiempoMinimo;
    }

    private void backtrack(int tareaIndex) {
        if (tareaIndex == tareas.size()) {
            int tiempoMaximo = Integer.MIN_VALUE;
            for (int tiempo : tiemposProcesadores) {
                tiempoMaximo = Math.max(tiempoMaximo, tiempo);
            }
            if (tiempoMaximo < tiempoMinimo) {
                tiempoMinimo = tiempoMaximo;
                actualizarMejorAsignacion();
            }
            return;
        }

        Tarea tarea = tareas.get(tareaIndex);
        int tiempoTarea = tarea.getTiempoEjecucion();

        for (int i = 0; i < cantProcesadores; i++) {
            tiemposProcesadores[i] += tiempoTarea;
            asignacionActual.get(i).add(tarea);

            backtrack(tareaIndex + 1);

            tiemposProcesadores[i] -= tiempoTarea;
            asignacionActual.get(i).remove(asignacionActual.get(i).size() - 1); // backtrack
        }
    }

    private void actualizarMejorAsignacion() {
        for (int i = 0; i < cantProcesadores; i++) {
            mejorAsignacion.get(i).clear();
            mejorAsignacion.get(i).addAll(asignacionActual.get(i));
        }
    }

    public List<List<Tarea>> obtenerMejorAsignacion() {
        return mejorAsignacion;
    }
}
