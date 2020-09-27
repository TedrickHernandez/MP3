import controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // steps to load fxml file
        // 1. Load through FXMLLoader (through FXMLLoader.load() / FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("filepath"));
        // 2. Set the controller manually (optional)
        // 3. Set .fxml file as the Scene of the Stage

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
        MenuController menuController = new MenuController();
        menuLoader.setController(menuController);

        Parent root = menuLoader.load();
        primaryStage.setTitle("That's Life!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}