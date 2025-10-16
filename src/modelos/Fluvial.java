package modelos;

import java.text.DecimalFormat;

public class Fluvial extends Envio{
    public Fluvial(String codigo, String cliente, double peso, double distancia){
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa(){
        return getDistancia() * 800 + getPeso() * 1000;
    }

    @Override
    public String[] mostrarDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return new String[]{
            "FLUVIAL",
            getCodigo(),
            getCliente(),
            df.format(getPeso()),
            df.format(getDistancia()),
            df.format(getCosto()),
        };
    } 
}
