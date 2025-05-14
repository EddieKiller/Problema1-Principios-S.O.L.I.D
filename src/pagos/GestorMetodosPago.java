package pagos;

import java.util.HashMap;
import java.util.Map;

public class GestorMetodosPago {
    private Map<String, MetodoPago> metodos = new HashMap<>();

    public void registrarMetodo(String nombre, MetodoPago metodo) {
        metodos.put(nombre.toLowerCase(), metodo);
    }

    public void eliminarMetodo(String nombre) {
        metodos.remove(nombre.toLowerCase());
    }

    public MetodoPago obtenerMetodo(String nombre) {
        return metodos.get(nombre.toLowerCase());
    }

    public boolean existeMetodo(String nombre) {
        return metodos.containsKey(nombre.toLowerCase());
    }
}