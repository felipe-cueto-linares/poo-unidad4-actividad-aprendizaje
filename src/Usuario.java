import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private String documento;
    private String nombre;
    private List<MedioPago> mediosPago = new ArrayList<>();

    public Usuario(String documento, String nombre) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMedioPago(MedioPago medio) {
        mediosPago.add(medio);
    }

    public List<MedioPago> getMediosPago() {
        return Collections.unmodifiableList(mediosPago);
    }

    public boolean ingresarPor(Estacion estacion, MedioPago medio, double tarifa) {
        if (estacion == null || !mediosPago.contains(medio)) {
            return false;
        }
        return medio.procesarPago(tarifa);
    }
}