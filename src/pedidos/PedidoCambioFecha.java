package pedidos;

import cliente.Cliente;
import producto.Producto;

import java.util.Map;

public abstract class PedidoCambioFecha extends Pedido {

    public PedidoCambioFecha(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente) {
        super(id, estado, productos, cliente);
    }

    public abstract void cambiarFecha();
}
