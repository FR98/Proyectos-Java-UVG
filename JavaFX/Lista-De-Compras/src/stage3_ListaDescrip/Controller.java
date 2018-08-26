package stage3_ListaDescrip;

import classes.ListadeCompra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private Label nombreLista;
    @FXML
    private TextArea descripcionLista;

    public void setScreen(ListadeCompra lista) {
        this.nombreLista.setText("Lista: " + lista.getNombre());
        this.descripcionLista.setText("Descripcion: " + lista.getDescripcion());
    }

    public void retroceder(ActionEvent event) {
        try {
            //Cierra ventana actual
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina");
        }
    }
}
