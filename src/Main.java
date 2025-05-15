import cliente.Cliente;
import producto.Producto;
import pedidos.*;
import pagos.*;
import factura.Factura;
import java.util.*;
import static pedidos.Pedido.EstadoPedido.*;


public class Main {
    public static void main(String[] args) {
        // Crear un cliente nuevo de tipo VIP
        Cliente cliente = new Cliente(
                "Nataniel Palacios",
                "nataniel.palacios@gmail.com",
                "Mozart 1490, Villa Alemana",
                Cliente.TipoCliente.VIP
        );


        // Mostrar información
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Tipo: " + cliente.getTipoCliente());
        System.out.println("Descuento: " + (cliente.getDescuento() * 100) + "%");
        System.out.println("¿Envío gratis?: " + cliente.tieneEnvioGratis());
        System.out.println("\n");

        Producto producto1 = new Producto("Chocolate", "123456", 2500, 100);
        Producto producto2 = new Producto("Vainilla", "153165", 1500, 200);
        Producto producto3 = new Producto("Leche", "983745", 1100, 50);


        Map<Producto, Integer> productosPedido1 = new HashMap<>();
        productosPedido1.put(producto1, 3); // 3 chocolates
        productosPedido1.put(producto2, 2); // 2 vainillas

        Map<Producto, Integer> productosPedido2 = new HashMap<>();
        productosPedido2.put(producto3, 1); // 1 leche

        Pedido pedidoEstandar = new EstandarPedido(100, PENDIENTE, productosPedido1, cliente);

        Pedido pedidoInt = new InternacionalPedido(101, Pedido.EstadoPedido.PENDIENTE, productosPedido2, 25.0, cliente);

        pedidoInt.descontarStockDeProductos();
        pedidoEstandar.descontarStockDeProductos();

        System.out.println("-------------- Descuentos despues del pedido ---------------");
        System.out.println("Stock de chocolates después del pedido: " + producto1.getStock());
        System.out.println("Stock de vainillas después del pedido: " + producto2.getStock());
        System.out.println("Stock de leche después del pedido: " + producto3.getStock());
        System.out.println("\n");

        GestorMetodosPago gestor = new GestorMetodosPago();
        gestor.registrarMetodo("tarjeta",new PagoTarjeta());
        gestor.registrarMetodo("transferencia", new PagoTransferencia());
        gestor.registrarMetodo("cripto", new PagoCripto());
        gestor.registrarMetodo("pagoContraEntrega", new PagoContraEntrega());



        Factura factura1 = new Factura(pedidoEstandar);
        factura1.imprimirFactura();

        factura1.pagarFactura("cripto",gestor);

        System.out.println(pedidoEstandar.getEstado());
        GestorEstadosPedidos.cambiarEstado(pedidoEstandar,CANCELADO);
        System.out.println(pedidoEstandar.getEstado());
        GestorEstadosPedidos.cambiarEstado(pedidoEstandar,EN_PREPARACION);
        System.out.println(pedidoEstandar.getEstado());

    }
}