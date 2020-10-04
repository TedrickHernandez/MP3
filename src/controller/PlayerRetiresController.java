package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayerRetiresController implements Initializable {

    @FXML
    private Label label_retireText;

    private int displayPlayerID;

    public PlayerRetiresController (int insertPlayerID)
    {
        displayPlayerID = insertPlayerID;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_retireText.setText("Player " + displayPlayerID + " has retired!");
    }

}