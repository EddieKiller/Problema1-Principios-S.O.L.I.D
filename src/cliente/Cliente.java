package cliente;

public class Cliente {

    private String nombre;
    private String email;
    private String direccion;
    private TipoCliente tipoCliente;

    public Cliente(String nombre, String email, String direccion, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    public double getDescuento() {
        switch (tipoCliente) {
            case NUEVO: return 0.05;
            case FRECUENTE: return 0.10;
            case VIP: return 0.15;
            default: return 0.0;
        }
    }

    public boolean tieneEnvioGratis() {
        return tipoCliente == TipoCliente.VIP;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public enum TipoCliente {
        NUEVO, FRECUENTE, VIP
    }
}
