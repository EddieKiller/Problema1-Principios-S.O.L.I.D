package pedidos;
import java.awt.*;
import java.util.Map;

import pagos.MetodoPago;
import producto.Producto;
import cliente.Cliente;

public class InternacionalPedido extends Pedido {
    private double impuestosAduana;

    public InternacionalPedido(int id, EstadoPedido estado, Map<Producto, Integer> productos, double impuestosAduana, Cliente cliente) {
        super(id, estado, productos, cliente);
        this.impuestosAduana = impuestosAduana;
    }


    public double getImpuestosAduana() {
        return impuestosAduana;
    }

    public void setImpuestosAduana(double impuestosAduana) {
        this.impuestosAduana = impuestosAduana;
    }
}
