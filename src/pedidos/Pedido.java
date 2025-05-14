package pedidos;
import producto.Producto;
import java.util.Map;

public class Pedido {
    protected int id;
    protected String estado;
    protected Map<Producto,Integer> productos;

    public Pedido(int id, String estado, Map<Producto,Integer> productos) {
        this.id = id;
        this.estado = estado;
        this.productos = productos;
    }

    public double calcularTotal(){
        double total =0.0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }
}
