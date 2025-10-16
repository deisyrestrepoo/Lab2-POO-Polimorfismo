package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Envio;
import modelos.TipoEnvio;

public class EnvioServicio {
    public static String[] encabezados = new String[] {
        "Tipo",
        "Código",
        "Cliente",
        "Peso",
        "Distancia",
        "Costo"
    };

    private static List<Envio> envios = new ArrayList<>();

    public static Envio getEnvio(int posicion) {
        if (posicion >= 0 && posicion < envios.size()) {
            return envios.get(posicion);
        } else {
            throw new IllegalArgumentException("Posición no válida");
        }
    }

    public static Envio agregar(TipoEnvio tipo, String codigo, String cliente, double peso, double distancia){
        Envio envio = null;
        switch (tipo) {
            case TERRESTRE -> envio = new modelos.Terrestre(codigo, cliente, peso, distancia);
            case AEREO -> envio = new modelos.Aereo(codigo, cliente, peso, distancia);
            case FLUVIAL -> envio = new modelos.Fluvial(codigo, cliente, peso, distancia);
        }
        envios.add(envio);
        return envio;
    }

    public static void eliminar (int posicion){
        envios.remove(posicion);
    }

    public static void mostrar (JTable tblLogistica){
        String[][] datos = null;
        if (!envios.isEmpty()) {
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