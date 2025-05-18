package pagos;

import java.util.HashMap;
import java.util.Map;

public class GestorMetodosPago {
    private Map<String, MetodoPago> metodosPago = new HashMap<>();

    public void registrarMetodo(String nombre, MetodoPago metodo) {
        metodosPago.put(nombre.toLowerCase(), metodo);
    }

    public void eliminarMetodo(String nombre) {
        metodosPago.remove(nombre.toLowerCase());
    }

    public MetodoPago obtenerMetodo(String nombre) {
        return metodosPago.get(nombre.toLowerCase());
    }

    public boolean existeMetodo(String nombre) {
        return metodosPago.containsKey(nombre.toLowerCase());
    }
}