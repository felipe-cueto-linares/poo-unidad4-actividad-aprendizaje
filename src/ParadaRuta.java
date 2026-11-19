public class ParadaRuta {
    private Ruta ruta;
    private Estacion estacion;
    private int posicion;
    private int tiempoDesdeAnterior;
    private double distanciaAcumulada;

    public ParadaRuta(Ruta ruta, Estacion estacion, int posicion, int tiempoDesdeAnterior, double distanciaAcumulada) {
        if (posicion < 1) {
            throw new IllegalArgumentException("La posicion debe ser 1 o mayor");
        }
        if (tiempoDesdeAnterior < 0 || distanciaAcumulada < 0) {
            throw new IllegalArgumentException("Tiempo y distancia no pueden ser negativos");
        }
        this.ruta = ruta;
        this.estacion = estacion;
        this.posicion = posicion;
        this.tiempoDesdeAnterior = tiempoDesdeAnterior;
        this.distanciaAcumulada = distanciaAcumulada;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getTiempoDesdeAnterior() {
        return tiempoDesdeAnterior;
    }

    public double getDistanciaAcumulada() {
        return distanciaAcumulada;
    }
}