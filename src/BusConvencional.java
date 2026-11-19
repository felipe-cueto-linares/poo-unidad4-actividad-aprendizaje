public class BusConvencional extends Vehiculo {
    private static final double PRECIO_GALON = 15000;
    private double rendimientoKmPorGalon;

    public BusConvencional(String placa, int capacidad, double rendimientoKmPorGalon) {
        super(placa, capacidad);
        if (rendimientoKmPorGalon <= 0) {
            throw new IllegalArgumentException("El rendimiento debe ser mayor que cero");
        }
        this.rendimientoKmPorGalon = rendimientoKmPorGalon;
    }

    public double getRendimientoKmPorGalon() {
        return rendimientoKmPorGalon;
    }

    @Override
    public double calcularCostoRecorrido(double distanciaKm) {
        return (distanciaKm / rendimientoKmPorGalon) * PRECIO_GALON;
    }
}