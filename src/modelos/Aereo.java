package modelos;

import java.text.DecimalFormat;

import interfaces.ITarifa;

public class Aereo extends Envio implements ITarifa {
     public Aereo(String codigo, String cliente,double peso, double distancia){
        super(codigo, cliente, peso, distancia, 0);
    }

    @Override
    public double calcularTarifa(){
        double costo = getDistancia()*5000 + getPeso()*4000;
        setCosto(costo);
        return costo;
        
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
