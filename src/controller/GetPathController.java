package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Path;

import java.net.URL;
import java.util.ResourceBundle;

public class GetPathController implements Initializable {
    private int playerNo;
    private Path path1, path2;

    @FXML
    private Button path1Button, path2Button;

    @FXML
    private Label label;

    private Path chosenPath;

    public GetPathController(int playerNo, Path path1, Path path2) {
        this.playerNo = playerNo;
        this.path1 = path1;
        this.path2 = path2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("Choose a Path (P" + playerNo + ")");
        path1Button.setText(path1.getName());
        path2Button.setText(path2.getName());
    }

    public void onClickPath1(ActionEvent ae) {
        chosenPath = path1;
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public void onClickPath2(ActionEvent ae) {
        chosenPath = path2;

        // when closing
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
