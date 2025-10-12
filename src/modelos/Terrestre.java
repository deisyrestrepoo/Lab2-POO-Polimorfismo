package modelos;

import java.text.DecimalFormat;

public class Terrestre extends Envio {
    
    public Terrestre(String codigo, String cliente,double peso, double distancia){
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa(){
        return getDistancia()*1500 + getPeso()*2000;
    }

    @Override
    public String[] mostrarDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[]{
            "TERRESTRE",
            getCodigo(),
            getCliente(),
            df.format(getPeso()),
            df.format(getDistancia())
        };
    }

}
