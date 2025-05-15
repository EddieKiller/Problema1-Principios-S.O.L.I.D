package pedidos;

public class GestorEstadosPedidos {

    public static boolean cambiarEstado(Pedido pedido, Pedido.EstadoPedido nuevoEstado) {
        Pedido.EstadoPedido estadoActual = pedido.getEstado();

        if (esTransicionValida(estadoActual, nuevoEstado)) {
            pedido.setEstado(nuevoEstado);
            System.out.println("Cambio exitoso: " + estadoActual + " > " + nuevoEstado);
            return true;
        } else {
            System.out.println("Transicion invalida: " + estadoActual + " > " + nuevoEstado);
            return false;
        }
    }
    private static boolean esTransicionValida(Pedido.EstadoPedido actual, Pedido.EstadoPedido nuevo) {
        return switch (actual) {
            case PENDIENTE -> nuevo == Pedido.EstadoPedido.PAGADO || nuevo == Pedido.EstadoPedido.CANCELADO;
            case PAGADO -> nuevo == Pedido.EstadoPedido.EN_PREPARACION || nuevo == Pedido.EstadoPedido.CANCELADO;
            case EN_PREPARACION -> nuevo == Pedido.EstadoPedido.ENVIADO || nuevo == Pedido.EstadoPedido.CANCELADO;
            case ENVIADO, CANCELADO -> false;
            default -> throw new IllegalStateException("Unexpected value: " + actual);
        };
    }
}
