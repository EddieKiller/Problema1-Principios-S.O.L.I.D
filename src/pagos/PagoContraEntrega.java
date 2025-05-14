package pagos;

public class PagoContraEntrega implements MetodoPago{
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago contra entrega: $" + monto);
        return true;
    }
}
