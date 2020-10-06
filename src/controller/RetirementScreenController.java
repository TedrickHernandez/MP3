package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class RetirementScreenController implements Initializable {

    @FXML
    private Label label_winnerText;

    @FXML
    private Label label_finalCashText;

    private int winnerID, winnerID2;
    private int winnerFinalCash;
    private int drawGame;

    public RetirementScreenController (int insertWinnerID, int insertWinnerID2, int insertWinnerFinalCash, int insertDrawGame)
    {
        winnerID = insertWinnerID;
        winnerID2 = insertWinnerID2;
        winnerFinalCash = insertWinnerFinalCash;
        drawGame = insertDrawGame;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        switch (drawGame)
        {
            case 0: /* No draws. */
                label_winnerText.setText("Player " + winnerID + " has won the game!");
                break;

            case 1: /* 2 draws. */
                label_winnerText.setText("Players " + winnerID + " and " + winnerID2 + " tied for first place!");
                break;

            case 2: /* All drew. */
                label_winnerText.setText("All players tied for first place!");
                break;

        }

        label_finalCashText.setText("Final Cash: PHP " + winnerFinalCash);
    }

}