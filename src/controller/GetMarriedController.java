package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GetMarriedController implements Initializable {

    @FXML
    private Label label_playerMarriedText;

    @FXML
    private Label label_generatedNumberText;

    @FXML
    private Label label_collectCashText;

    private int playerID;
    private int rollNumber;
    private int finalValue;

    public GetMarriedController (int insertPlayerID)
    {
        playerID = insertPlayerID;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {

        Random random = new Random();
        rollNumber = random.nextInt(10) + 1;

        label_playerMarriedText.setText("Player " + playerID + " just married!");
        if (rollNumber % 2 == 0) {
            label_generatedNumberText.setText("Generated Number: " + rollNumber + " (Even)");
            finalValue = 10000;
            label_collectCashText.setText("Collect from Player/s: " + finalValue);
        }
        else
        {
            label_generatedNumberText.setText("Generated Number: " + rollNumber + " (Odd)");
            finalValue = 5000;
            label_collectCashText.setText("Collect from Player/s: " + finalValue);
        }

    }

    public int getFinalValue ()
    {
        return finalValue;
    }

}