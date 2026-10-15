public class Envios {
    private final int codigo;
    private String destinatario;
    private double peso;

    public void envios (int codigo, String destinatario, double peso){
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
