package pedidos;
import producto.Producto;
import java.util.Map;
import cliente.Cliente;
import pagos.*;


public class Pedido {

    public enum EstadoPedido {
        PENDIENTE, PAGADO, EN_PREPARACION, ENVIADO, ENTREGADO, CANCELADO
    }

    private int id;
    private EstadoPedido estado;
    private Map<Producto, Integer> productos;
    private Cliente cliente;

    public Pedido(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente) {
        this.id = id;
        this.estado = estado;
        this.productos = productos;
        this.cliente = cliente;
    }

    public double calcularTotal() {
        double subtotal = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            subtotal += entry.getKey().getPrecio() * entry.getValue();
        }
        double descuento = subtotal * cliente.getDescuento();
        return subtotal - descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
