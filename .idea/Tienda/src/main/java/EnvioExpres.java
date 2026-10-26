public class EnvioExpres extends EnvioNacional {
    private int horasMaximas;

    public EnvioExpres(String codigo, String destinatario, double peso, String ciudadDestino, boolean requiereDomicilio, int horasMaximas) {
        super(codigo, destinatario, peso, ciudadDestino, requiereDomicilio);
        this.horasMaximas = horasMaximas;
    }

    @Override
    public double calcularCosto() {
        // Valor del envío nacional incrementado en un 30%
        double costoNacional = super.calcularCosto();
        double costoTotal = costoNacional * 1.30;

        // Adiciona $5.000 si la entrega debe realizarse en 24 horas o menos
        if (horasMaximas <= 24) {
            costoTotal += 5000.0;
        }

        return costoTotal;
    }

    public int getHorasMaximas() {
        return horasMaximas;
    }
}