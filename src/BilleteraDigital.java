public class BilleteraDigital implements MedioPago {
    private String proveedor;
    private double saldo;
    private double limiteDiario;

    public BilleteraDigital(String proveedor, double saldo, double limiteDiario) {
        if (saldo < 0 || limiteDiario < 0) {
            throw new IllegalArgumentException("Saldo y limite no pueden ser negativos");
        }
        this.proveedor = proveedor;
        this.saldo = saldo;
        this.limiteDiario = limiteDiario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteDiario() {
        return limiteDiario;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= 0 || monto > saldo || monto > limiteDiario) {
            return false;
        }
        saldo -= monto;
        limiteDiario -= monto;
        return true;
    }
}