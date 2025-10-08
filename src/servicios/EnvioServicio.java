package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Envio;
import modelos.TipoEnvio;

public class EnvioServicio {
    public static String[] encabezados = new String[] { "Tipo", "Código", "Cliente", "Peso",
            "Distancia", "Costo"};

    private static List<Envio> envios = new ArrayList<>();

    public static Envio getCuenta(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            return envios.get(posicion);
        } else {
            throw new IllegalArgumentException("Posición no válida");
        }
    }

    public static Envio agregar(TipoEnvio tipo, String codigo, String titular, double peso, double Distancia, double costo ){
        Envio envio = null ;

        envios.add(envio);
        return envio;

    }

    public static void eliminar (int posicion){
        envios.remove(posicion);
    }

    public static void mostrar (JTable tblLogistica){
        String[][] datos = null;
        if (envios.size() > 0) {
            datos = new String[envios.size()][encabezados.length];
            int fila = 0;
            for (Envio c : envios) {
                datos[fila] = c.mostrarDatos();
                fila++;
            }

        }
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tblLogistica.setModel(dtm);

    }

    

}
