package modelos;

import java.text.DecimalFormat;

public class Aereo extends Envio {
    public Aereo(String codigo, String cliente, double peso, double distancia){
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa(){
        return getDistancia() * 5000 + getPeso() * 4000;
    }

    @Override
    public String[] mostrarDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[]{
            "AEREO",
            getCodigo(),
            getCliente(),
            df.format(getPeso()),
            df.format(getDistancia()),
            df.format(getCosto()),
        };
    }
}