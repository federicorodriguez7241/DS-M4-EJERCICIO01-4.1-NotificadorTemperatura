public class PantallaRecepcion implements Observador {
    private String ubicacion;

    public PantallaRecepcion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void actualizar(double temperatura) {
        System.out.println("[Pantalla Recepcion - " + ubicacion + "] Temperatura actual: " + temperatura + " C");
    }
}
