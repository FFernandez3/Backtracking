package ejercicios.ej5;

public class Tarea {
    private String id;
    private int tiempoEjecucion;

    public Tarea(String id, int tiempoEjecucion) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getId() {
        return id;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    @Override
    public String toString() {
        return id + "(" + tiempoEjecucion + ")";
    }
}

