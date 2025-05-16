package pedidos;

import cliente.Cliente;
import producto.Producto;
import java.util.Map;

public class ProgramadoPedido extends PedidoCambioFecha {

    private String fechaEntrega;

    public ProgramadoPedido(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente, String fechaEntrega) {
        super(id, estado, productos, cliente);
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public void cambiarFecha() {
        System.out.println("La fecha del pedido programado ha sido cambiada al día elegido.");
    }
}