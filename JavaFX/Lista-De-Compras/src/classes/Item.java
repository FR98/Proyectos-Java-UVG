package classes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    //Atributos
    private SimpleStringProperty nombre = new SimpleStringProperty();
    private SimpleIntegerProperty cantidad = new SimpleIntegerProperty();
    private SimpleDoubleProperty precioUnitario = new SimpleDoubleProperty();
    private SimpleDoubleProperty total = new SimpleDoubleProperty();
    private SimpleBooleanProperty comprado = new SimpleBooleanProperty();

    //Constructor
    public Item(String nombre, Integer cantidad, Double precio) {
        this.nombre.set(nombre);
        this.cantidad.set(cantidad);
        this.precioUnitario.set(precio);
        this.total.set(precio*cantidad);
        this.comprado.set(false);
    }

    public String getNombre() {
        return this.nombre.get();
    }

    public Integer getCantidad() {
        return this.cantidad.get();
    }

    public Double getPrecioUnitario() {
        return this.precioUnitario.get();
    }

    public Double getTotal() {
        return this.total.get();
    }

    public Boolean getComprado() {
        return comprado.get();
    }

    public void marcarComprado() {
        this.comprado.set(true);
    }

    public void marcarPendiente() {
        this.comprado.set(false);
    }

}
