import java.time.*;

public class Revision {
    private java.time.LocalDateTime fecha;
    private String diagnostico;

    //asociacion
    private Vehiculo vehiculo;

    public Revision(LocalDateTime fecha, String diagnostico) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
