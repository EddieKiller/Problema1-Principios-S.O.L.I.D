package pedidos;

public class InternacionalPedido extends PedidoConCobro {

    private double cobroAduana;

    public InternacionalPedido(int id, EstadoPedido estado, java.util.Map<producto.Producto, Integer> productos, cliente.Cliente cliente, double cobroAduana) {
        super(id, estado, productos, cliente);
        this.cobroAduana = cobroAduana;
    }

    @Override
    public double sumarCobro() {
        double total = super.calcularTotal();
        return total + cobroAduana;
    }
}
