import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpresaTransporte {
    private String nit;
    private String nombre;
    private List<Ruta> rutas = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public EmpresaTransporte(String nit, String nombre) {
        if (nit == null || nit.isBlank()) {
            throw new IllegalArgumentException("El NIT es obligatorio");
        }
        this.nit = nit;
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarRuta(Ruta ruta) {
        rutas.add(ruta);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<Ruta> getRutas() {
        return Collections.unmodifiableList(rutas);
    }

    public List<Vehiculo> getVehiculos() {
        return Collections.unmodifiableList(vehiculos);
    }

    public double costoTotalOperacion() {
        double total = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getRuta() != null) {
                total += vehiculo.calcularCostoRecorrido(vehiculo.getRuta().distanciaTotal());
            }
        }
        return total;
    }
}