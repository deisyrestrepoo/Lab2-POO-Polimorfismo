package servicios;

public class validarServicio {
     public static boolean validarCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            return false;
        }
        
        if (cliente.trim().length() < 1 || cliente.trim().length() > 100) {
            return false;
        }
        
        if (!cliente.equals(cliente.trim())) {
            return false;
        }
        
        if (!cliente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s\\.\\-']+$")) {
            return false;
        }
        
        if (cliente.contains("  ")) {
            return false;
        }
        
        String[] partes = cliente.trim().split("\\s+");
        
        for (String parte : partes) {
            if (parte.length() < 1) {
                return false;
            }
            if (!parte.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$")) {
                return false;
            }
        }
        
        return true;
    }
    
    public static String obtenerMensajeErrorCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            return "El nombre del cliente no puede estar vacío";
        }
        
        if (cliente.trim().length() < 1) {
            return "El nombre del cliente debe tener al menos 1 carácter";
        }
        
        if (cliente.trim().length() > 100) {
            return "El nombre del cliente no puede tener más de 100 caracteres";
        }
        
        if (!cliente.equals(cliente.trim())) {
            return "El nombre del cliente no puede empezar o terminar con espacios";
        }
        
        if (cliente.contains("  ")) {
            return "El nombre del cliente no puede tener múltiples espacios consecutivos";
        }
        
        if (!cliente.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s\\.\\-']+$")) {
            return "El nombre del cliente solo puede contener letras, espacios, puntos, guiones y apostrofes";
        }
        
        String[] partes = cliente.trim().split("\\s+");
        
        for (String parte : partes) {
            if (parte.length() < 1) {
                return "Cada parte del nombre debe tener al menos 1 carácter";
            }
            if (!parte.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$")) {
                return "Cada parte del nombre solo puede contener letras";
            }
        }
        
        return "Formato de nombre inválido";
    }
    

}
