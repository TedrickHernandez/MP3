package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Path;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoosePlayerController implements Initializable {
    private Player player1, player2;

    @FXML
    private Button button_player1, button_player2;

    private Player chosenPlayer;

    public ChoosePlayerController(Player insertPlayer1, Player insertPlayer2) {
        player1 = insertPlayer1;
        player2 = insertPlayer2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_player1.setText("Player " + player1.getPlayerID());
        button_player2.setText("Player " + player2.getPlayerID());
    }

    public void onClickPlayer1(ActionEvent ae) {
        chosenPlayer = player1;
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public void onClickPlayer2(ActionEvent ae) {
        chosenPlayer = player2;

        // when closing
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public int returnPlayerID ()
    {
        return chosenPlayer.getPlayerID();
    }
}
