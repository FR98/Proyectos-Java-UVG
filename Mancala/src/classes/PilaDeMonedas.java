package classes;

public class PilaDeMonedas {
    private Integer cantidad;

    public PilaDeMonedas(int cantidad){
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void empty() {
        this.cantidad = 0;
    }

    public void addMoneda() {
        cantidad += 1;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
