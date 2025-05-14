package pagos;


public class PagoTarjeta implements MetodoPago{
    @Override
    public boolean procesarPago(double monto){
        System.out.println("Procesando pago con tarjeta por $"+ monto );
        return true;
    }
}
