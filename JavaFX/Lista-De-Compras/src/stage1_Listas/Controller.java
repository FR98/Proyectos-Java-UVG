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

    private ObservableList<ListadeCompra> data = FXCollections.observableArrayList();

    /*public Controller(ObservableList<ListadeCompra> data) {
        this.data = data;
    }*/

    public void initialize() {
        columnaNombres.setCellValueFactory(new PropertyValueFactory<ListadeCompra,String>("nombre"));
        columnaPendientes.setCellValueFactory(new PropertyValueFactory<ListadeCompra,String>("pendiente"));
        tablaListas.setItems(data);
    }

    public void abrirCrearNuevaListaWindow(ActionEvent event) {
        try {
            //Carga la ventana
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/stage2_NuevaLista/screen.fxml"));
            Parent root2 = loader2.load();
            Stage screen2 = new Stage();
            screen2.setTitle("Nueva Lista");
            screen2.setScene(new Scene(root2, 500, 300));
            //Cierra ventana actual
            //((Node)(event.getSource())).getScene().getWindow().hide();
            //Muestra la ventana
            screen2.show();


            stage2_NuevaLista.Controller nuevaListaController = loader2.getController();
            //nuevaListaController.crearLista();


        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void abrirEditarListaWindow(ActionEvent event) {
        try {
            //Carga la ventana
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/stage3_ListaDescrip/screen.fxml"));
            Parent root3 = loader3.load();
            Stage screen3 = new Stage();
            screen3.setTitle("Lista");
            screen3.setScene(new Scene(root3, 500, 500));

            //Seleccion de Lista
            stage3_ListaDescrip.Controller listaDescripController = loader3.getController();
            ListadeCompra selectedLista = tablaListas.getSelectionModel().getSelectedItem();
            if (selectedLista != null) {
                listaDescripController.setScreen(selectedLista);
                //Muestra la ventana
                screen3.show();
            } else {
                System.out.println("No hay elemento seleccionado");
            }

        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void addListToData(ListadeCompra listaNueva) {
        this.data.add(listaNueva);
        //System.out.println(data);
        //tablaListas.setItems(data);
    }

    public void eliminarLista(ActionEvent event) {
        try {
            //Seleccion de Lista
            ListadeCompra selectedLista = tablaListas.getSelectionModel().getSelectedItem();
            if (selectedLista != null) {
                this.data.remove(selectedLista);
            } else {
                System.out.println("No hay elemento seleccionado");
            }

        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

}
