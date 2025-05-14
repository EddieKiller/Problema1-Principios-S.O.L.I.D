package pedidos;
import java.util.Map;
import producto.Producto;

public class ExpressPedido extends Pedido {
    private double cargoExtra;

    public ExpressPedido(int id, String estado, Map<Producto, Integer> productos, double cargoExtra) {
        super(id, estado, productos);
        this.cargoExtra = cargoExtra;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + cargoExtra;
    }

    public double getCargoExtra() {
        return cargoExtra;
    }

    public void setCargoExtra(double cargoExtra) {
        this.cargoExtra = cargoExtra;
    }
}
