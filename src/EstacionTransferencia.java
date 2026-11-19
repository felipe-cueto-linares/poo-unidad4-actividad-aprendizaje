import java.util.ArrayList;
import java.util.List;

public class EstacionTransferencia extends Estacion {
    private int tiempoTransbordo;

    public EstacionTransferencia(String codigo, String nombre, String direccion, int tiempoTransbordo) {
        super(codigo, nombre, direccion);
        if (tiempoTransbordo < 0) {
            throw new IllegalArgumentException("El tiempo de transbordo no puede ser negativo");
        }
        this.tiempoTransbordo = tiempoTransbordo;
    }

    public int getTiempoTransbordo() {
        return tiempoTransbordo;
    }

    public List<Ruta> rutasConectadas() {
        List<Ruta> rutas = new ArrayList<>();
        for (ParadaRuta parada : getParadas()) {
            if (!rutas.contains(parada.getRuta())) {
                rutas.add(parada.getRuta());
            }
        }
        return rutas;
    }
}