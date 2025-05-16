package pedidos;

import cliente.Cliente;
import producto.Producto;
import java.util.Map;

public class ExpressPedido extends PedidoCambioFecha {

    private double cargoExtra;

    public ExpressPedido(int id, EstadoPedido estado, Map<Producto, Integer> productos, Cliente cliente, double cargoExtra) {
        super(id, estado, productos, cliente);
        this.cargoExtra = cargoExtra;
    }

    @Override
    public void cambiarFecha() {
        System.out.println("La fecha del pedido express ha sido cambiada.");
        // Aquí podrías modificar fechaEntrega si fuera dinámico
    }

    //-------IMPORTANTE------
    //esta deberia ser un @Override pero como en Java no existe la herencia múltiple
    //la "simulamos" heredando de PedidoCambioFecha y usando composición para el cobro
    public double sumarCobro() {
        double total = super.calcularTotal();
        return total + cargoExtra;
    }

}

