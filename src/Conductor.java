import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conductor {
    private String documento;
    private String nombre;
    private String numeroLicencia;
    private List<AsignacionTurno> turnos = new ArrayList<>();

    public Conductor(String documento, String nombre, String numeroLicencia) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        if (numeroLicencia == null || numeroLicencia.isBlank()) {
            throw new IllegalArgumentException("La licencia es obligatoria");
        }
        this.documento = documento;
        this.nombre = nombre;
        this.numeroLicencia = numeroLicencia;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public AsignacionTurno asignarTurno(Vehiculo vehiculo, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        AsignacionTurno nuevo = new AsignacionTurno(this, vehiculo, fecha, horaInicio, horaFin);
        for (AsignacionTurno existente : turnos) {
            if (existente.getFecha().equals(fecha)
                    && horaInicio.isBefore(existente.getHoraFin())
                    && horaFin.isAfter(existente.getHoraInicio())) {
                throw new IllegalStateException("El conductor ya tiene un turno que se cruza con ese horario");
            }
        }
        turnos.add(nuevo);
        return nuevo;
    }

    public List<AsignacionTurno> getTurnos() {
        return Collections.unmodifiableList(turnos);
    }
}