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

    public boolean cambiarEstado(EstadoPedido nuevoEstado) {
        if (esTransicionValida(this.estado, nuevoEstado)) {
            EstadoPedido anterior = this.estado;
            this.estado = nuevoEstado;
            System.out.println("Cambio exitoso: " + anterior + " > " + nuevoEstado);
            return true;
        } else {
            System.out.println("Transición inválida: " + this.estado + " > " + nuevoEstado);
            return false;
        }
    }

    private boolean esTransicionValida(EstadoPedido actual, EstadoPedido nuevo) {
        return switch (actual) {
            case PENDIENTE -> nuevo == EstadoPedido.PAGADO;
            case PAGADO -> nuevo == EstadoPedido.EN_PREPARACION || nuevo == EstadoPedido.CANCELADO;
            case EN_PREPARACION -> nuevo == EstadoPedido.ENVIADO || nuevo == EstadoPedido.CANCELADO;
            case ENVIADO, CANCELADO -> false;
            default -> throw new IllegalStateException("Valor inesperado: " + actual);
        };
    }

    public double calcularTotal() {
        double subtotal = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            subtotal += entry.getKey().getPrecio() * entry.getValue();
        }
        double descuento = subtotal * cliente.getDescuento();
        double total = subtotal - descuento;
        return total;
    }

    public void descontarStockDeProductos() {
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            producto.descontarStock(cantidad);
        }
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
