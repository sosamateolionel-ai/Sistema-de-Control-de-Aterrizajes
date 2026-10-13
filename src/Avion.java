public class Avion {

    private String codigoVuelo;
    private String aerolinea;
    private String estadoVuelo; // "En vuelo", "Aterrizando", "En tierra"

    public Avion(String codigoVuelo, String aerolinea) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.estadoVuelo = "En vuelo"; // todo avión arranca en el aire
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getEstadoVuelo() {
        return estadoVuelo;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estadoVuelo = nuevoEstado;
        System.out.println(codigoVuelo + ": estado -> " + nuevoEstado + ".");
    }

    public void solicitarAterrizaje(TorreControl torre) {

        System.out.println("\n" + codigoVuelo + " (" + aerolinea + ") solicita permiso de aterrizaje.");

        boolean autorizado = torre.autorizarAterrizaje(this);

        if (!autorizado) {
            System.out.println(codigoVuelo + ": permiso denegado, continúa en circuito de espera.");
        }
    }

    public void completarAterrizaje(TorreControl torre) {
        System.out.println("\n" + codigoVuelo + " toca pista y avisa a la torre.");
        torre.confirmarAterrizaje(this);
    }
}