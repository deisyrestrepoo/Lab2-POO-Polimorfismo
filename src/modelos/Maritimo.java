package modelos;

import java.text.DecimalFormat;

public class Maritimo extends Envio{
    public Maritimo(String codigo, String cliente,double peso, double distancia, double costo){
        super(codigo, cliente, peso, distancia, costo);
    }

    @Override
    public double calcularTarifa(){
        return getDistancia()*800 + getPeso()*1000;
    }

    @Override
    public String[] mostrarDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[]{
            "MARITIMO",
            getCodigo(),
            getCliente(),
            df.format(getPeso()),
            df.format(getDistancia()),
            df.format(getCosto()),
        };
    } 

}
