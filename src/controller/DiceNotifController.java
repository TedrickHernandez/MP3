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

public class DiceNotifController implements Initializable {

    @FXML
    private Label label_diceText;

    private int displayPlayerID;
    private int displayDiceRoll;

    public DiceNotifController (int insertPlayerID, int insertDiceRoll)
    {
        displayPlayerID = insertPlayerID;
        displayDiceRoll = insertDiceRoll;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_diceText.setText("Player " + displayPlayerID + " rolled " + displayDiceRoll + "!");
    }

}