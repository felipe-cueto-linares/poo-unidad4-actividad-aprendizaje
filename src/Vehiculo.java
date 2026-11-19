public abstract class Vehiculo {
    protected String placa;
    protected int capacidad;

    public Vehiculo(String placa, int capacidad) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("La placa es obligatoria");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
        }
        this.placa = placa;
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public abstract double calcularCostoRecorrido(double distanciaKm);
}