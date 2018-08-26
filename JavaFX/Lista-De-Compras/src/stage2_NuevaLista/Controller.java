package stage2_NuevaLista;

import classes.ListadeCompra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField inputNombreLista;
    @FXML
    private TextArea inputDescripLista;

    public void retroceder(ActionEvent event) {
        try {
            //Cierra ventana actual
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void abrirCrearListaWindow(ActionEvent event) {
        try {
            //Carga la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/stage3_ListaDescrip/screen.fxml"));
            Parent root = loader.load();
            Stage screen = new Stage();
            screen.setTitle("Lista Descripcion");
            screen.setScene(new Scene(root, 500, 500));

            //Crear Lista
            stage3_ListaDescrip.Controller listaDescripController = loader.getController();
            String nombreListaNueva = inputNombreLista.getText();
            String descripListaNueva = inputDescripLista.getText();

            if (nombreListaNueva != null && descripListaNueva != null) {
                listaDescripController.setScreen(new ListadeCompra(nombreListaNueva, descripListaNueva));
                //Cierra ventana actual
                ((Node)(event.getSource())).getScene().getWindow().hide();
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
