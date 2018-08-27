package stage1_Listas;

import classes.ListadeCompra;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /*ObservableList<ListadeCompra> data = FXCollections.observableArrayList(
            new ListadeCompra("Super", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    );*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("screen.fxml"));
        primaryStage.setTitle("Listas de Compras");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
