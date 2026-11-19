import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ruta {
    private String codigo;
    private String nombre;
    private List<ParadaRuta> paradas = new ArrayList<>();

    public Ruta(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El codigo es obligatorio");
        }
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ParadaRuta agregarParada(Estacion estacion, int posicion, int tiempoDesdeAnterior, double distanciaAcumulada) {
        for (ParadaRuta existente : paradas) {
            if (existente.getPosicion() == posicion) {
                throw new IllegalArgumentException("Ya existe una parada en la posicion " + posicion);
            }
        }
        ParadaRuta parada = new ParadaRuta(this, estacion, posicion, tiempoDesdeAnterior, distanciaAcumulada);
        paradas.add(parada);
        paradas.sort(Comparator.comparingInt(ParadaRuta::getPosicion));
        estacion.agregarParada(parada);
        return parada;
    }

    public List<ParadaRuta> getParadas() {
        return Collections.unmodifiableList(paradas);
    }

    public double distanciaTotal() {
        if (paradas.isEmpty()) {
            return 0;
        }
        return paradas.get(paradas.size() - 1).getDistanciaAcumulada();
    }

    public int tiempoTotal() {
        int total = 0;
        for (ParadaRuta parada : paradas) {
            total += parada.getTiempoDesdeAnterior();
        }
        return total;
    }
}