package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label myLabel;
    @FXML
    private ListView<String> myListView;
    @FXML
    private TextField myTextField;

    public void handleButtonClick(ActionEvent event) {
        System.out.println("HOLA MUNDO");
        myLabel.setText("Hola " + Math.random());
    }

    public void addElement(ActionEvent event) {
        System.out.println("Texto: " + myTextField.getText());
        String textValue = myTextField.getText();
        ObservableList<String> items = myListView.getItems();

        if (items != null) {
            items.add(textValue);
        } else {
            ObservableList<String> rItems = FXCollections.observableArrayList(textValue);
        }

        myTextField.setText("");
        myTextField.requestFocus();
    }
}
