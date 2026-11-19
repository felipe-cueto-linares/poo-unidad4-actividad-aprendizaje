public class TarjetaPrepago implements MedioPago {
    private String numero;
    private double saldo;

    public TarjetaPrepago(String numero, double saldo) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("El numero es obligatorio");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void recargar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de recarga debe ser mayor que cero");
        }
        saldo += monto;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        return true;
    }
}