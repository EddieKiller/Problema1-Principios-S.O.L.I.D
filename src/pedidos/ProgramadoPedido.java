package pedidos;
import java.util.Map;

import cliente.Cliente;
import producto.Producto;

public class ProgramadoPedido extends Pedido {
    private String fechaEntrega;

    public ProgramadoPedido(int id, String estado, Map<Producto, Integer> productos, String fechaEntrega, Cliente cliente) {
        super(id, estado, productos, cliente);
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
