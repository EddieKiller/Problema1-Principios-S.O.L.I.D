import cliente.Cliente;
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
    }
}