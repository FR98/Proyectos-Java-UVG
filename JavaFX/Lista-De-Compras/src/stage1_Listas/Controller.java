package stage1_Listas;

import classes.ListadeCompra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TableView<ListadeCompra> tablaListas;

    public void abrirCrearNuevaListaWindow(ActionEvent event) {
        try {
            Parent root1 = new FXMLLoader(getClass().getResource("/stage2_NuevaLista/screen2.fxml")).load();
            Stage screen2 = new Stage();
            screen2.setTitle("Nueva Lista");
            screen2.setScene(new Scene(root1, 500, 300));
            screen2.show();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

    public void abrirEditarListaWindow(ActionEvent event) {
        try {
            Parent root2 = new FXMLLoader(getClass().getResource("/stage3_ListaDescrip/screen3.fxml")).load();
            Stage screen3 = new Stage();
            screen3.setTitle("Lista");
            screen3.setScene(new Scene(root2, 500, 500));
            screen3.show();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }

}
