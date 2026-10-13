public class TorreControl {

    private String aeropuerto;
    private boolean pistaLibre;
    private Avion avionEnPista; // quién ocupa la pista (null si está libre)

    public TorreControl(String aeropuerto) {
        this.aeropuerto = aeropuerto;
        this.pistaLibre = true;
        this.avionEnPista = null;
    }

    public boolean autorizarAterrizaje(Avion avion) {

        // Validación 1: solo puede aterrizar un avión que está en vuelo
        if (!avion.getEstadoVuelo().equals("En vuelo")) {
            System.out.println("Torre " + aeropuerto + ": " + avion.getCodigoVuelo()
                    + " no está en vuelo (estado: " + avion.getEstadoVuelo() + "), solicitud rechazada.");
            return false;
        }

        // Validación 2: la pista debe estar libre
        if (!pistaLibre) {
            System.out.println("Torre " + aeropuerto + ": pista ocupada por "
                    + avionEnPista.getCodigoVuelo() + ", " + avion.getCodigoVuelo() + " debe esperar.");
            return false;
        }

        // Autorizado: se ocupa la pista y se le ordena al avión cambiar de estado
        pistaLibre = false;
        avionEnPista = avion;

        System.out.println("Torre " + aeropuerto + ": " + avion.getCodigoVuelo() + " autorizado, pista asignada.");
        avion.cambiarEstado("Aterrizando");

        return true;
    }

    public void confirmarAterrizaje(Avion avion) {

        if (avion != avionEnPista) {
            System.out.println("Torre " + aeropuerto + ": " + avion.getCodigoVuelo()
                    + " no tenía la pista asignada, confirmación ignorada.");
            return;
        }

        avion.cambiarEstado("En tierra");
        pistaLibre = true;
        avionEnPista = null;

        System.out.println("Torre " + aeropuerto + ": pista liberada.");
    }
}