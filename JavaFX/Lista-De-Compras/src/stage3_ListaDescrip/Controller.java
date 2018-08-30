package stage3_ListaDescrip;

import classes.Item;
import classes.ListadeCompra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label nombreLista;
    @FXML
    private TextArea descripcionLista;
    @FXML
    private TableView<Item> tablaLista;
    @FXML
    private TableColumn columnaArticulo;
    @FXML
    private TableColumn columnaCantidad;
    @FXML
    private TableColumn columnaUnitario;
    @FXML
    private TableColumn columnaTotal;
    @FXML
    private TableColumn columnaEstado;

    private ListadeCompra listadeCompras;
    private ObservableList<Item> data2 = FXCollections.observableArrayList();

    public void initialize() {
        //-----------------------------------------------------------------------------------------------
        columnaArticulo.setCellValueFactory(new PropertyValueFactory<Item,String>("nombre"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<Item,String>("cantidad"));
        columnaUnitario.setCellValueFactory(new PropertyValueFactory<Item,String>("precioUnitario"));
        columnaTotal.setCellValueFactory(new PropertyValueFactory<Item,String>("total"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<Item,String>("comprado"));
        tablaLista.setItems(data2);
    }

    public void setScreen(ListadeCompra lista) {
        this.nombreLista.setText("Lista: " + lista.getNombre());
        this.descripcionLista.setText("Descripcion: " + lista.getDescripcion());
        this.listadeCompras = lista;
    }

    public void abrirCrearItemWindow(ActionEvent event) {
        try {
            System.out.println(this.listadeCompras.getListaDeCompras());
            //Carga la ventana
            FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/stage4_NuevoItem/screen.fxml"));
            Parent root4 = loader4.load();
            Stage screen4 = new Stage();
            screen4.setTitle("Nueva Lista");
            screen4.setScene(new Scene(root4, 500, 300));

            //Se manda informacion al controlador
            stage4_NuevoItem.Controller nuevaListaController = loader4.getController();
            nuevaListaController.asignarData(this.data2, listadeCompras);
            //nuevaListaController.asignarData(this.listadeCompras.getListaDeCompras());

            //Muestra la ventana
            screen4.show();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void setData(ObservableList<Item> data2) {
        this.data2 = data2;
        //this.listadeCompras.setListaDeCompras(data2);
    }

    public void eliminarItem(ActionEvent event) {
        try {
            //Seleccion de Lista
            Item selectedItem = (Item) tablaLista.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                this.data2.remove(selectedItem);
            } else {
                System.out.println("No hay elemento seleccionado");
            }

        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void retroceder(ActionEvent event) {
        try {
            //Cierra ventana actual
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e)  {
            System.out.println("No se pudo retroceder");
        }
    }
}
