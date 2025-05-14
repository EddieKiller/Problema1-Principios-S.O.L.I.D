package pedidos;
import java.util.Map;
import producto.Producto;

public class ProgramadoPedido extends Pedido {
    private String fechaEntrega;

    public ProgramadoPedido(int id, String estado, Map<Producto, Integer> productos, String fechaEntrega) {
        super(id, estado, productos);
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
