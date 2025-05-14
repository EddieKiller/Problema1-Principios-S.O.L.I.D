package pedidos;
import producto.Producto;
import java.util.Map;

public class EstandarPedido extends Pedido {
    public EstandarPedido(int id, String estado, Map<Producto, Integer> productos) {
        super(id, estado, productos);
    }
}