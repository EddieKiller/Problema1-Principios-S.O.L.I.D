import cliente.Cliente;
import pedido.Pedido;
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

        Pedido pedido1 = new Pedido("Chocolate", "123456", 2500, 100);

        // Mostrar info
        System.out.println("----------------------------------------------------");
        System.out.println("Nombre: " + pedido1.getNombre());
        System.out.println("Precio: " + pedido1.getPrecio() + "$");
        System.out.println("Stock: " + pedido1.getStock());

    }
}