public class EnvioNacional extends Envios {
    protected String ciudadDestino;
    protected boolean requiereDomicilio;

    public EnvioNacional(String codigo, String destinatario, double peso, String ciudadDestino, boolean requiereDomicilio) {
        super(codigo, destinatario, peso);
        this.ciudadDestino = ciudadDestino;
        this.requiereDomicilio = requiereDomicilio;
    }

    @Override
    public double calcularCosto() {
        double costo = 6000.0 + (2000.0 * peso);
        if (requiereDomicilio) {
            costo += 3000.0;
        }
        return costo;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public boolean isRequiereDomicilio() {
        return requiereDomicilio;
    }
}