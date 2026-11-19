import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CASO PRINCIPAL ===");

        EmpresaTransporte empresa = new EmpresaTransporte("900123456-1", "Movilidad Cartagena");

        Estacion centro = new Estacion("E1", "Centro", "Av. Venezuela");
        EstacionTransferencia bazurto = new EstacionTransferencia("E2", "Bazurto", "Av. Pedro de Heredia", 5);
        Estacion universidad = new Estacion("E3", "Universidad", "Campus Piedra de Bolivar");
        Estacion crespo = new Estacion("E4", "Crespo", "Via al Aeropuerto");

        Ruta ruta1 = new Ruta("R1", "Centro - Universidad");
        ruta1.agregarParada(centro, 1, 0, 0);
        ruta1.agregarParada(bazurto, 2, 10, 4.5);
        ruta1.agregarParada(universidad, 3, 12, 9.0);

        Ruta ruta2 = new Ruta("R2", "Bazurto - Crespo");
        ruta2.agregarParada(bazurto, 1, 0, 0);
        ruta2.agregarParada(crespo, 2, 15, 7.0);

        empresa.agregarRuta(ruta1);
        empresa.agregarRuta(ruta2);

        BusConvencional convencional = new BusConvencional("ABC123", 80, 8);
        BusElectrico electrico = new BusElectrico("ELE456", 90, 1.2);
        VehiculoArticulado articulado = new VehiculoArticulado("ART789", 160, 3);

        convencional.setRuta(ruta1);
        electrico.setRuta(ruta1);
        articulado.setRuta(ruta2);

        empresa.agregarVehiculo(convencional);
        empresa.agregarVehiculo(electrico);
        empresa.agregarVehiculo(articulado);

        System.out.println("Ruta " + ruta1.getNombre() + ": " + ruta1.distanciaTotal() + " km, " + ruta1.tiempoTotal() + " min");
        System.out.println("Ruta " + ruta2.getNombre() + ": " + ruta2.distanciaTotal() + " km, " + ruta2.tiempoTotal() + " min");

        for (Vehiculo v : empresa.getVehiculos()) {
            double costo = v.calcularCostoRecorrido(v.getRuta().distanciaTotal());
            System.out.println(v.getClass().getSimpleName() + " " + v.getPlaca() + " en ruta " + v.getRuta().getCodigo() + ": costo $" + costo);
        }
        System.out.println("Costo total de operacion: $" + empresa.costoTotalOperacion());

        Conductor conductor = new Conductor("1143000111", "Carlos Perez", "LIC-2024-001");
        AsignacionTurno turno = conductor.asignarTurno(convencional, LocalDate.of(2026, 11, 20), LocalTime.of(6, 0), LocalTime.of(14, 0));
        System.out.println("Turno de " + conductor.getNombre() + " con " + turno.getVehiculo().getPlaca() + ": " + turno.duracionHoras() + " horas");

        Usuario usuario = new Usuario("1050222333", "Ana Gomez");
        TarjetaPrepago tarjeta = new TarjetaPrepago("TP-0001", 10000);
        BilleteraDigital billetera = new BilleteraDigital("NequiPay", 20000, 3000);
        usuario.agregarMedioPago(tarjeta);
        usuario.agregarMedioPago(billetera);

        boolean ingreso = usuario.ingresarPor(centro, tarjeta, 2950);
        System.out.println("Ingreso por " + centro.getNombre() + " con tarjeta: " + ingreso + ", saldo: $" + tarjeta.getSaldo());

        System.out.println();
        System.out.println("=== CASO DE PRUEBA DISTINTO ===");

        System.out.println("Rutas que pasan por " + bazurto.getNombre() + ": " + bazurto.rutasConectadas().size());
        System.out.println("Tiempo de transbordo en " + bazurto.getNombre() + ": " + bazurto.getTiempoTransbordo() + " min");

        Usuario usuario2 = new Usuario("1050444555", "Luis Mora");
        TarjetaPrepago tarjetaPobre = new TarjetaPrepago("TP-0002", 1000);
        BilleteraDigital billeteraLimitada = new BilleteraDigital("DaviPlata", 50000, 3000);
        usuario2.agregarMedioPago(tarjetaPobre);
        usuario2.agregarMedioPago(billeteraLimitada);

        System.out.println("Ingreso con saldo insuficiente: " + usuario2.ingresarPor(universidad, tarjetaPobre, 2950));
        System.out.println("Ingreso con billetera: " + usuario2.ingresarPor(universidad, billeteraLimitada, 2950));
        System.out.println("Segundo ingreso supera limite diario: " + usuario2.ingresarPor(universidad, billeteraLimitada, 2950));

        tarjetaPobre.recargar(5000);
        System.out.println("Ingreso tras recargar: " + usuario2.ingresarPor(universidad, tarjetaPobre, 2950) + ", saldo: $" + tarjetaPobre.getSaldo());

        try {
            conductor.asignarTurno(electrico, LocalDate.of(2026, 11, 20), LocalTime.of(12, 0), LocalTime.of(18, 0));
        } catch (IllegalStateException e) {
            System.out.println("Turno rechazado: " + e.getMessage());
        }
    }
}