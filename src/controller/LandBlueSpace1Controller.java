package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class LandBlueSpace1Controller implements Initializable {

    @FXML
    private Label label_playerLandText;

    @FXML
    private Label label_cardTypeText;

    private int displayPlayerID;
    private String displayCardType;

    public LandBlueSpace1Controller (int insertPlayerID, String insertCardType)
    {
        displayPlayerID = insertPlayerID;
        displayCardType = insertCardType;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_playerLandText.setText("Player " + displayPlayerID + " landed on a BLUE SPACE!");
        label_cardTypeText.setText("Type: " + displayCardType);
    }

}