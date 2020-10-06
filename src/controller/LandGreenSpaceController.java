package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class LandGreenSpaceController implements Initializable {

    @FXML
    private Label label_line1;

    @FXML
    private Label label_line2;

    private int displayPlayerID;
    private int displayPlayerSalary;

    public LandGreenSpaceController (int insertPlayerID, int insertPlayerSalary)
    {
        displayPlayerID = insertPlayerID;
        displayPlayerSalary = insertPlayerSalary;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        label_line1.setText("Player " + displayPlayerID + " landed on a GREEN SPACE!");
        label_line2.setText("Salary Earned: " + displayPlayerSalary);
    }

}

/*package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.CareerCard;
import model.CareerCardDeck;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class LandGreenSpaceController implements Initializable {

    @FXML
    private Label label_lines1;

    @FXML
    private Label label_lines2;

    @FXML
    private Label label_lines3;

    private int playerID;
    private int playerSalary;
    private int playerPayRaises;
    private String playerCareer;
    private boolean landedOnRaise;
    private boolean payRaised = false;
    private ArrayList<CareerCard> careerCards;
    private int activeCardID;

    public LandGreenSpaceController (int insertPlayerID, int insertPlayerSalary, int insertPlayerPayRaises, String insertPlayerCareer, ArrayList<CareerCard> insertCareerCards, boolean insertLandedOnRaise)
    {
        playerID = insertPlayerID;
        playerSalary = insertPlayerSalary;
        playerPayRaises = insertPlayerPayRaises;
        landedOnRaise = insertLandedOnRaise;
        careerCards = insertCareerCards;
        playerCareer = insertPlayerCareer;
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        label_lines1.setText("");
        label_lines2.setText("");
        label_lines3.setText("");
        for (int i = 0; i < 7; i ++)
        {
            if (playerCareer == careerCards.get(i).getCareerCardName())
            {
                activeCardID = i;
            }
        }
        if (landedOnRaise == true)
        {
            label_lines1.setText("Player " + playerID + " landed on a PAY RAISE Space!");
            if (playerPayRaises >= careerCards.get(activeCardID).getCareerCardPayRaiseLimit())
            {
                label_lines3.setText("Maximum number of raises reached.");
            }
            else
            {
                label_lines3.setText("Salary raised by 10000!");
                payRaised = true;
            }
        }
        else
        {
            label_lines1.setText("Player " + playerID + " landed on a GREEN SPACE!");
        }
        label_lines2.setText("Earned Value: " + playerSalary);
    }

    public boolean getPayRaised ()
    {
        return payRaised;
    }

}*/