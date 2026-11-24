import java.util.ArrayList;
import java.util.List;

public class EstacionMeteorologica implements SujetoObservable {
    private List<Observador> observadores;
    private double temperaturaActual;
    private boolean primeraLectura;

    public EstacionMeteorologica() {
        this.observadores = new ArrayList<>();
        this.primeraLectura = true;
    }

    @Override
    public void registrarObservador(Observador observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar(temperaturaActual);
        }
    }

    public void setTemperatura(double nuevaTemperatura) {
        // notificamos si es la primera lectura o si la variacion es de al menos 0.5 grados
        if (primeraLectura || Math.abs(nuevaTemperatura - temperaturaActual) >= 0.5) {
            this.temperaturaActual = nuevaTemperatura;
            this.primeraLectura = false;
            System.out.println("\n[Estacion Meteorologica] Nueva temperatura registrada: " + temperaturaActual + " C");
            notificarObservadores();
        } else {
            System.out.println("\n[Estacion Meteorologica] Lectura de " + nuevaTemperatura + " C sin cambios significativos.");
        }
    }
}
