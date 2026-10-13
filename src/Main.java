void main() {

    TorreControl torre = new TorreControl("Aeropuerto de Mendoza");

    Avion avion1 = new Avion("AR1234", "Aerolíneas Argentinas");
    Avion avion2 = new Avion("LA8070", "LATAM");
    Avion avion3 = new Avion("FB5001", "Flybondi");

    System.out.println("=== Aproximación: tres aviones piden pista ===");
    avion1.solicitarAterrizaje(torre);
    avion2.solicitarAterrizaje(torre);
    avion3.solicitarAterrizaje(torre);

    System.out.println("\n=== El primer avión termina de aterrizar ===");
    avion1.completarAterrizaje(torre);

    System.out.println("\n=== Segunda ronda: los que esperaban vuelven a pedir ===");
    avion2.solicitarAterrizaje(torre);
    avion3.solicitarAterrizaje(torre);

    System.out.println("\n=== Intento inválido: avión ya en tierra pide pista ===");
    avion1.solicitarAterrizaje(torre);

    System.out.println("\n=== Estados finales ===");
    System.out.println(avion1.getCodigoVuelo() + ": " + avion1.getEstadoVuelo());
    System.out.println(avion2.getCodigoVuelo() + ": " + avion2.getEstadoVuelo());
    System.out.println(avion3.getCodigoVuelo() + ": " + avion3.getEstadoVuelo());

}
