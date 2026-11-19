import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estacion {
    private String codigo;
    private String nombre;
    private String direccion;
    private List<ParadaRuta> paradas = new ArrayList<>();

    public Estacion(String codigo, String nombre, String direccion) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El codigo es obligatorio");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarParada(ParadaRuta parada) {
        paradas.add(parada);
    }

    public List<ParadaRuta> getParadas() {
        return Collections.unmodifiableList(paradas);
    }
}