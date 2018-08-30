package classes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;

public class ListadeCompra {
    //Atributos
    private SimpleStringProperty nombre = new SimpleStringProperty();
    private String descripcion;
    private SimpleDateFormat fecha = new SimpleDateFormat();
    private SimpleIntegerProperty pendientes = new SimpleIntegerProperty();
    private SimpleDoubleProperty estimado = new SimpleDoubleProperty();
    private ObservableList<Item> listaDeCompras = FXCollections.observableArrayList();

    //Constructor
    public ListadeCompra(String nombre, String descripcion) {
        this.nombre.set(nombre);
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ObservableList<Item> getListaDeCompras() {
        return listaDeCompras;
    }

    public SimpleDateFormat getFecha() {
        return fecha;
    }

    public int getPendientes() {
        return pendientes.get();
    }

    public double getEstimado() {
        return estimado.get();
    }
}
