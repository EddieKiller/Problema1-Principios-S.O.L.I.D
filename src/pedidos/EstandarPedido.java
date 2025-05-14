package pedidos;
import cliente.Cliente;
import pagos.MetodoPago;
import producto.Producto;
import java.util.Map;

public class EstandarPedido extends Pedido {
    public EstandarPedido(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente) {
        super(id, estado, productos, cliente);
    }
}