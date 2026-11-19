import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AsignacionTurno {
    private Conductor conductor;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public AsignacionTurno(Conductor conductor, Vehiculo vehiculo, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        if (!horaFin.isAfter(horaInicio)) {
            throw new IllegalArgumentException("La hora de fin debe ser posterior a la de inicio");
        }
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public double duracionHoras() {
        return Duration.between(horaInicio, horaFin).toMinutes() / 60.0;
    }
}