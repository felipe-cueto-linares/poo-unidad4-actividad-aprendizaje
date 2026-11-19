public class VehiculoArticulado extends Vehiculo {
    private static final double COSTO_KM_POR_SECCION = 2500;
    private int numeroSecciones;

    public VehiculoArticulado(String placa, int capacidad, int numeroSecciones) {
        super(placa, capacidad);
        if (numeroSecciones < 2) {
            throw new IllegalArgumentException("Un articulado tiene al menos 2 secciones");
        }
        this.numeroSecciones = numeroSecciones;
    }

    public int getNumeroSecciones() {
        return numeroSecciones;
    }

    @Override
    public double calcularCostoRecorrido(double distanciaKm) {
        return distanciaKm * numeroSecciones * COSTO_KM_POR_SECCION;
    }
}