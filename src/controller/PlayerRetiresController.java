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

    @FXML
    private Label label_initialCashText;

    @FXML
    private Label label_childCashText;

    @FXML
    private Label label_houseSellText;

    @FXML
    private Label label_loansText;

    @FXML
    private Label label_finalCashText;

    private int displayPlayerID;
    private int displayPlayerInitialCash;
    private int displayChildCash;
    private HouseCard displayHouseSell;
    private int displayLoans;
    private int displayFinalCash;

    public PlayerRetiresController (int insertPlayerID, int insertPlayerInitialCash, int insertPlayerChildren,
                                    HouseCard insertPlayerHouse, int insertPlayerLoans)
    {
        displayPlayerID = insertPlayerID;
        displayPlayerInitialCash = insertPlayerInitialCash;
        displayChildCash = insertPlayerChildren;
        /* Put house card here */
        displayLoans = insertPlayerLoans;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_retireText.setText("Player " + displayPlayerID + " has retired!");
    }

}