package pedidos;
import cliente.Cliente;
import producto.Producto;
import java.util.Map;

public class EstandarPedido extends Pedido {
    public EstandarPedido(int id, String estado, Map<Producto, Integer> productos, Cliente cliente) {
        super(id, estado, productos, cliente);
    }
}