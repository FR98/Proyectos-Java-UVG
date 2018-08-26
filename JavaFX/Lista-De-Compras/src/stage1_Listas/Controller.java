package stage1_Listas;

import classes.ListadeCompra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
    //Se hace la conexion con los elementos graficos
    @FXML
    private TableView<ListadeCompra> tablaListas;
    @FXML
    private TableColumn columnaNombres;
    @FXML
    private TableColumn columnaFechas;
    @FXML
    private TableColumn columnaPendientes;
    @FXML
    private TableColumn columnaEstimados;

    private ObservableList<ListadeCompra> data = FXCollections.observableArrayList(
            new ListadeCompra("Super", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    );

    public void addListToData(ListadeCompra listaNueva) {
        System.out.println("Lista creada");
        this.data.add(listaNueva);
    }

    public void initialize() {

        /*ObservableList<ListadeCompra> data = FXCollections.observableArrayList(
                new ListadeCompra("Super", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        );*/

        columnaNombres.setCellValueFactory(new PropertyValueFactory<ListadeCompra,String>("nombre"));
        columnaPendientes.setCellValueFactory(new PropertyValueFactory<ListadeCompra,String>("pendiente"));

        tablaListas.setItems(data);
    }

    public void abrirCrearNuevaListaWindow(ActionEvent event) {
        try {
            //Carga la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/stage2_NuevaLista/screen.fxml"));
            Parent root = loader.load();
            Stage screen = new Stage();
            screen.setTitle("Nueva Lista");
            screen.setScene(new Scene(root, 500, 300));
            //Cierra ventana actual
            ((Node)(event.getSource())).getScene().getWindow().hide();
            //Muestra la ventana
            screen.show();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void abrirEditarListaWindow(ActionEvent event) {
        try {
            //Carga la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/stage3_ListaDescrip/screen.fxml"));
            Parent root = loader.load();
            Stage screen = new Stage();
            screen.setTitle("Lista");
            screen.setScene(new Scene(root, 500, 500));

            //Seleccion de Lista
            stage3_ListaDescrip.Controller listaDescripController = loader.getController();
            ListadeCompra selectedLista = tablaListas.getSelectionModel().getSelectedItem();
            if (selectedLista != null) {
                listaDescripController.setScreen(selectedLista);
                //Muestra la ventana
                screen.show();
            } else {
                System.out.println("No hay elemento seleccionado");
            }

        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }



}
