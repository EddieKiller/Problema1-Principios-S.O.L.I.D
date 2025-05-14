package pedidos;
import java.util.Map;
import producto.Producto;
import cliente.Cliente;

public class InternacionalPedido extends Pedido {
    private double impuestosAduana;

    public InternacionalPedido(int id, String estado, Map<Producto, Integer> productos, double impuestosAduana, Cliente cliente) {
        super(id, estado, productos, cliente);
        this.impuestosAduana = impuestosAduana;
    }

    @Override
    public double calcularTotal() {
        return (super.calcularTotal() + impuestosAduana);
    }

    public double getImpuestosAduana() {
        return impuestosAduana;
    }

    public void setImpuestosAduana(double impuestosAduana) {
        this.impuestosAduana = impuestosAduana;
    }
}
