package util;

public class Validador {

    public static boolean correoValido(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean edadValida(int edad) {
        return edad > 0 && edad < 150;
    }

    public static boolean positivo(double valor) {
        return valor > 0;
    }

    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean telefonoValido(String telefono) {
        return telefono.matches("\\d+");
    }

}
