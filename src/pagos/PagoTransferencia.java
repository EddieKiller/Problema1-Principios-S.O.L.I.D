package pagos;

public class PagoTransferencia implements MetodoPago{
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago por transferencia de $" + monto);
        return true;
    }

}
