public class EnvioInternacional extends Envios {
    private String paisDestino;
    private boolean necesitaSeguro;

    public EnvioInternacional(String codigo, String destinatario, double peso, String paisDestino, boolean necesitaSeguro) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
        this.necesitaSeguro = necesitaSeguro;
    }

    @Override
    public double calcularCosto() {
        double costo = 15000.0 + (9000.0 * peso);
        if (necesitaSeguro) {
            costo += 20000.0;
        }
        return costo;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public boolean isNecestaSeguro() {
        return necesitaSeguro;
    }
}