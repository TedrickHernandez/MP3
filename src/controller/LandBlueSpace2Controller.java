package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class LandBlueSpace2Controller implements Initializable {

    @FXML
    private Label label_line1;

    @FXML
    private Label label_line2;

    @FXML
    private Label label_line3;

    private String cardType;
    private int cardValue;
    private int taxDue;
    private int randomNumber;
    private int finalValue;
    private int numberOfPlayers;
    private int playerSalary;
    private boolean sameCareer;

    public LandBlueSpace2Controller (String insertCardType, int insertCardValue, int insertTaxDue, int insertNumberOfPlayers, int insertPlayerSalary, boolean insertSameCareer)
    {
        cardType = insertCardType;
        cardValue = insertCardValue;
        taxDue = insertTaxDue;
        numberOfPlayers = insertNumberOfPlayers;
        playerSalary = insertPlayerSalary;
        sameCareer = insertSameCareer;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        if (sameCareer == false) {
            switch (cardType) {
                case "Lawsuit":
                    label_line1.setText("LAWSUIT: Pay a flat randomly-generated amount to the Lawyer/bank.");
                    label_line2.setText("");
                    label_line3.setText("Value: " + cardValue);
                    finalValue = cardValue;
                    break;

                case "Salary Tax Due":
                    label_line1.setText("SALARY TAX DUE: Pay your Tax Due to the Accountant/bank.");
                    label_line2.setText("");
                    label_line3.setText("Value: " + taxDue);
                    finalValue = taxDue;
                    break;

                case "Tip the Server":
                    Random random = new Random();
                    randomNumber = random.nextInt(20) + 1;
                    label_line1.setText("TIP THE SERVER: Roll a number (1-20) and pay x1000 to the Server/bank.");
                    label_line2.setText("Generated Number: " + randomNumber);
                    label_line3.setText("Value: " + (randomNumber * 1000));
                    finalValue = randomNumber * 1000;
                    break;

                case "Ski Accident":
                    label_line1.setText("SKI ACCIDENT: Pay a flat amount to the Doctor/bank.");
                    label_line2.setText("");
                    label_line3.setText("Value: 10000");
                    finalValue = 10000;
                    break;

                case "Computer Repair":
                    Random random2 = new Random();
                    randomNumber = random2.nextInt(20) + 1;
                    label_line1.setText("COMPUTER REPAIR: Roll an odd/even number and pay 5000/10000 to Computer Consultant/bank.");
                    if (randomNumber % 2 == 0) {
                        label_line2.setText("Generated Number: " + randomNumber + " (Even)");
                        label_line3.setText("Value: 5000");
                        finalValue = 5000;
                    } else {
                        label_line2.setText("Generated Number: " + randomNumber + " (Odd)");
                        label_line3.setText("Value: 10000");
                        finalValue = 10000;
                    }
                    break;

                case "World Cup":
                    label_line1.setText("WORLD CUP: Pay no. of players x 5000 to Athlete/bank.");
                    label_line2.setText("No. of Players: " + numberOfPlayers);
                    label_line3.setText("Value: " + (numberOfPlayers * 5000));
                    finalValue = numberOfPlayers * 5000;
                    break;

                case "F1 Race":
                    label_line1.setText("F1 RACE: Pay 10% of salary to Racecar Driver/bank.");
                    label_line2.setText("Salary: " + playerSalary);
                    label_line3.setText("Value: " + (playerSalary / 10));
                    finalValue = playerSalary / 10;
                    break;
            }
        }
        else
        {
            label_line1.setText("SAME CAREER: You get a flat amount cash reward.");
            label_line2.setText("");
            label_line3.setText("Value: 15000");
            finalValue = 15000;
        }
    }
    public int getFinalValue ()
    {
        return finalValue;
    }

    public boolean getSameCareer ()
    {
        return sameCareer;
    }

}