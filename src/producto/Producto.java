package producto;

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

    public boolean descontarStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
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
