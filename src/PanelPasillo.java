public class PanelPasillo implements Observador {
    private int piso;

    public PanelPasillo(int piso) {
        this.piso = piso;
    }

    @Override
    public void actualizar(double temperatura) {
        String estado = "Confortable";
        if (temperatura >= 28.0) {
            estado = "Calor elevado";
        } else if (temperatura <= 15.0) {
            estado = "Ambiente frio";
        }
        System.out.println("[Panel Piso " + piso + "] Marcador: " + temperatura + " C (" + estado + ")");
    }
}