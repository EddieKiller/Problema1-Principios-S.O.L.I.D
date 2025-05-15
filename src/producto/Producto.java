package producto;

import java.util.Objects;

public class Producto {
    private String nombre;
    private String codigo;
    private int precio;
    private int stock;

    public Producto(String nombre, String codigo, int precio, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public void descontarStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return Objects.equals(codigo, p.codigo);
    }
    public int hashCode() {
        return Objects.hash(codigo);
    }


    public String getNombre() {
        return nombre;
    }


    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
