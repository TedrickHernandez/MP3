package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.*;
import java.net.URL;
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
    private int finalCashTotal;

    public PlayerRetiresController (int insertPlayerID, int insertPlayerInitialCash, int insertPlayerChildren,
                                    HouseCard insertPlayerHouse, int insertPlayerLoans)
    {
        displayPlayerID = insertPlayerID;
        displayPlayerInitialCash = insertPlayerInitialCash;
        displayChildCash = insertPlayerChildren;
        displayHouseSell = insertPlayerHouse;
        displayLoans = insertPlayerLoans;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        int childCashTotal = displayChildCash * 10000;
        int loanCashTotal = displayLoans * -25000;
        finalCashTotal = displayPlayerInitialCash + (displayChildCash * 10000) + displayHouseSell.getHouseCardSellValue() + (displayLoans * -25000);
        label_retireText.setText("Player " + displayPlayerID + " has retired!");
        label_initialCashText.setText("Initial Cash: PHP " + displayPlayerInitialCash);
        label_childCashText.setText("Child Cash Bonus: " + displayChildCash + " x PHP 10000 = PHP " + childCashTotal);
        label_houseSellText.setText(displayHouseSell.getHouseCardName() + " Sell Price: PHP " + displayHouseSell.getHouseCardSellValue());
        label_loansText.setText("Loans Deduction/s: " + displayLoans + " x PHP 25000 = " + loanCashTotal);
        label_finalCashText.setText("Final Cash: PHP " + finalCashTotal);
    }

    public int getPlayerFinalCash ()
    {
        return finalCashTotal;
    }

}