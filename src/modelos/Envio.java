package modelos;

public abstract class Envio {
    private String codigo;
    private String cliente;
    private double peso;
    private double distancia;
    private double costo;

    public Envio(String codigo, String cliente, double peso, double distancia,double costo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.peso = peso;
        this.distancia = distancia;
        this.costo = costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getCosto() {
        return costo;
    }
     
    // Métodos polimórficos
    public abstract String[] mostrarDatos();

    public abstract double calcularTarifa();

}
