package servicios;

public class realServicio {
    public static double leerReal(String texto) {
        if (texto.isEmpty()) {
            return 0;
        }
        try {
            return Double.parseDouble(texto);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Valor numérico real no válido");
        }
    }

}
