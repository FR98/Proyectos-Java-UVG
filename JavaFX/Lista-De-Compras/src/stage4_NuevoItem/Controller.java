package stage4_NuevoItem;

import classes.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField inputNombreItem;
    @FXML
    private TextField inputCantidad;
    @FXML
    private TextField inputPrecioUnitario;

    private ObservableList<Item> data2;

    public void asignarData(ObservableList<Item> data) {
        this.data2 = data;
    }

    public void crearItem(ActionEvent event) {
        //Crear nuevo item
        try {
            //Cargar las ventanas
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/stage3_ListaDescrip/screen.fxml"));
            Parent root3 = loader3.load();

            //Se obtienen los valores ingresados
            String nombreItem = inputNombreItem.getText();
            Integer cantidad = Integer.parseInt(inputCantidad.getText());
            Double precio = Double.parseDouble(inputPrecioUnitario.getText());

            if ((inputNombreItem != null) && (inputCantidad != null) && (inputPrecioUnitario != null)) {
                //Nuevo item con valores ingresados
                Item nuevoItem = new Item(nombreItem, cantidad, precio);

                //Se agrega el item a la lista
                this.data2.add(nuevoItem);
                stage3_ListaDescrip.Controller listasController = loader3.getController();
                listasController.setData(this.data2);

                //Cierra ventana actual
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } else {
                System.out.println("Falta llenar un campo");
            }

        } catch (Exception e)  {
            System.out.println("No se pudo cargar la pagina"+e);
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
