package pedidos;
import cliente.Cliente;
import pedidos.Pedido;
import producto.Producto;

import java.util.Map;

public abstract class PedidoConCobro extends Pedido{

    public PedidoConCobro(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente) {
        super(id, estado, productos, cliente);
    }

    public abstract double sumarCobro();
}
