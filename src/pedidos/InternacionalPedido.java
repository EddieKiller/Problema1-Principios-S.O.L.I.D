package pedidos;
import java.util.Map;
import producto.Producto;

public class InternacionalPedido extends Pedido {
    private double impuestosAduana;

    public InternacionalPedido(int id, String estado, Map<Producto, Integer> productos, double impuestosAduana) {
        super(id, estado, productos);
        this.impuestosAduana = impuestosAduana;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + impuestosAduana;
    }

    public double getImpuestosAduana() {
        return impuestosAduana;
    }

    public void setImpuestosAduana(double impuestosAduana) {
        this.impuestosAduana = impuestosAduana;
    }
}
