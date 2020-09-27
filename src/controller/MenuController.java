package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    public void onClick2Players(ActionEvent ae) throws IOException {
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();

        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
        GameController gameController = new GameController(2);
        gameLoader.setController(gameController);

        stage.setScene(new Scene(gameLoader.load()));
//        stage.setMaximized(true);
        gameController.startGame();
    }

    @FXML
    public void onClick3Players(ActionEvent ae) throws IOException {
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();

        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
        GameController gameController = new GameController(3);
        gameLoader.setController(gameController);

        stage.setScene(new Scene(gameLoader.load()));
//        stage.setMaximized(true);
        gameController.startGame();
    }
}
