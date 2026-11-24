public class Main {
    public static void main(String[] args) {

        EstacionMeteorologica estacion = new EstacionMeteorologica();

        // creamos distintas pantallas distribuidas en el edificio
        Observador pantallaEntrada = new PantallaRecepcion("Hall Principal");
        Observador panelPiso1 = new PanelPasillo(1);
        Observador panelPiso2 = new PanelPasillo(2);

        // registramos los dispositivos interesados
        estacion.registrarObservador(pantallaEntrada);
        estacion.registrarObservador(panelPiso1);
        estacion.registrarObservador(panelPiso2);

        // 1. Primera lectura: notifica a las 3 pantallas
        estacion.setTemperatura(22.0);

        // 2. Variacion minima (0.2 C): no dispara actualizaciones innecesarias
        estacion.setTemperatura(22.2);

        // 3. Variacion significativa: actualiza todas las pantallas suscritas
        estacion.setTemperatura(28.5);

        // 4. Desvinculamos una pantalla y volvemos a actualizar
        System.out.println("\n--- Desvinculando Panel Piso 1 ---");
        estacion.eliminarObservador(panelPiso1);

        estacion.setTemperatura(14.5);
    }
}
