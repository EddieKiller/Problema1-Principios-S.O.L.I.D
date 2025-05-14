package pagos;

public class PagoCripto implements MetodoPago{
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con criptomoneda por $" + monto);
        return true;
    }
}
