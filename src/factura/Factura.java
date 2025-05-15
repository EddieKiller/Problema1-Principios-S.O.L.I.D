package factura;
import pedidos.Pedido.*;
import pedidos.Pedido;
import producto.Producto;
import cliente.Cliente;
import java.util.*;

public class Factura {

    private Pedido pedido;
    private double totalBruto;
    private double descuento;
    private double impuesto;
    private double montoFinal;
    private boolean pagado;

    public Factura(Pedido pedido) {
        this.pedido = pedido;
        this.pagado = pedido.getEstado() == Pedido.EstadoPedido.PAGADO;

        calcularValores();
    }

    private void calcularValores() {
        totalBruto = calcularTotalBruto();
        descuento = calcularDescuento();
        impuesto = calcularImpuesto();
        montoFinal = totalBruto - descuento + impuesto;
    }

    private double calcularTotalBruto() {
        double total = 0;
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }

    private double calcularDescuento() {
        Cliente cliente = pedido.getCliente();
        return totalBruto * cliente.getDescuento();
    }

    private double calcularImpuesto() {
            // Simulación simple: si en la dirección aparece "internacional", aplicamos impuesto
        if (pedido.getCliente().getDireccion().toLowerCase().contains("internacional")) {
            return totalBruto * 0.2; // 20% de impuesto aduanero
        }
        return 0;
    }

    public void imprimirFactura() {
        System.out.println("----- FACTURA -----");
        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Productos:");
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println(" - " + producto.getNombre() + " x" + cantidad + " = $" + (producto.getPrecio() * cantidad));
        }
        System.out.println("Total bruto: $" + totalBruto);
        System.out.println("Descuento aplicado: -$" + descuento);
        System.out.println("Impuestos: +$" + impuesto);
        System.out.println("Total final: $" + montoFinal);
        System.out.println("Estado de pago: " + (pagado ? "Pagado" : "Pendiente"));
        System.out.println("-------------------");
    }


    public double getTotalBruto() {
        return totalBruto;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public Pedido getPedido() {
        return pedido;
    }

}

