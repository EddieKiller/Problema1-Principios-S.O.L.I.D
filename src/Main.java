import cliente.Cliente;
import producto.Producto;
import pedidos.*;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        Producto producto1 = new Producto("Chocolate", "123456", 2500, 100);
        Producto producto2 = new Producto("Vainilla", "153165", 1500, 200);


        // Mostrar info
        System.out.println("----------------------------------------------------");
        System.out.println("Nombre: " + producto1.getNombre());
        System.out.println("Precio: " + producto1.getPrecio() + "$");
        System.out.println("Stock: " + producto1.getStock());



        Map<Producto, Integer> productos = new HashMap<>();
        productos.put(producto1, 3); // 3 chocolates
        productos.put(producto2, 2); // 2 vainillas

        Pedido pedidoEstandar = new EstandarPedido(100, "Enviado", productos, cliente);
        Pedido pedidoInt = new InternacionalPedido(101, "Entregado", productos, 25.0, cliente);

        System.out.println("-------------------------------------------------------");
        System.out.println("Total pedido estandar: " + pedidoEstandar.calcularTotal());
        System.out.println("Total pedido internacional: " + pedidoInt.calcularTotal());

    }
}