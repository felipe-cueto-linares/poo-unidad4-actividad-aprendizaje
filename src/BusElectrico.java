public class BusElectrico extends Vehiculo {
    private static final double PRECIO_KWH = 700;
    private double consumoKwhPorKm;

    public BusElectrico(String placa, int capacidad, double consumoKwhPorKm) {
        super(placa, capacidad);
        if (consumoKwhPorKm <= 0) {
            throw new IllegalArgumentException("El consumo debe ser mayor que cero");
        }
        this.consumoKwhPorKm = consumoKwhPorKm;
    }

    public double getConsumoKwhPorKm() {
        return consumoKwhPorKm;
    }

    @Override
    public double calcularCostoRecorrido(double distanciaKm) {
        return distanciaKm * consumoKwhPorKm * PRECIO_KWH;
    }
}