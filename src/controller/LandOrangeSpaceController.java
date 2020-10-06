package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class LandOrangeSpaceController implements Initializable {

    @FXML
    private Label label_playerLandedText;

    @FXML
    private Label label_cardTypeText;

    @FXML
    private Label label_cardTitleText;

    @FXML
    private Label label_cardValueText;

    private int displayPlayerID;
    private String displayCardType;
    private String displayCardTitle;
    private int displayCardValue;

    public LandOrangeSpaceController (int insertPlayerID, String insertCardType, String insertCardTitle, int insertCardValue)
    {
        displayPlayerID = insertPlayerID;
        displayCardType = insertCardType;
        displayCardTitle = insertCardTitle;
        displayCardValue = insertCardValue;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_playerLandedText.setText("Player " + displayPlayerID + " landed on an ORANGE SPACE!");
        label_cardTypeText.setText("Type: " + displayCardType);
        label_cardTitleText.setText("Title: " + displayCardTitle);
        label_cardValueText.setText("Value: PHP " + displayCardValue);
    }

}