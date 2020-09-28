package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;
import java.util.Random;


public class GameController {
    private int turn = 0, numPlayers;
    Game game;

    @FXML
    private Button rollButton;

    public GameController(int numPlayers) {
        this.numPlayers = numPlayers;
        game = new Game(numPlayers);
    }

    @FXML
    public void onClickBackToMenu(ActionEvent ae) throws IOException {
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
        MenuController menuController = new MenuController();
        menuLoader.setController(menuController);

        stage.setScene(new Scene(menuLoader.load()));
    }

    public void rollDice(ActionEvent ae) throws IOException {
        if(game.getActivePlayers().size() == 0) {
            Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();

//            FXMLLoader gameEndLoader = new FXMLLoader(getClass().getResource(""));
//            GameEndController gameEndController = new GameEndController();
//            gameEndLoader.setController(gameEndLoader);

//            stage.setScene(gameEndLoader.load());
            stage.setMaximized(false);
        } else {
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();

            Random random = new Random();
            int rolled = random.nextInt(10) + 1;

            Space spaceLanded = new Space();
            game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).removePlayer(game.getCurrentPlayer());
            for(int i = 0; i < rolled; i++) {
                game.getCurrentPlayer().addPlayerSpace();
                spaceLanded = game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace());

                // magenta space so break
                if(game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName().equals("Magenta Space")) break;
            }
            handleSpace(spaceLanded);
            game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).addPlayer(game.getCurrentPlayer());

            turn++;
            if(turn == game.getActivePlayers().size()) {
                turn = 0;
            }
        }
        if(game.getActivePlayers().size() == 0) rollButton.setText("End Game");
    }

    /**
     *
     * @param space space where the player landed
     */
    public void handleSpace(Space space) {
        if(space.getName().equals("Orange Space")) {
//           game.getCurrentPlayer()
        } else if(space.getName().equals("Blue Space")) {
//            game.getCurrentPlayer()
        } else if(space.getName().equals("Green Space")) {
//            game.getCurrentPlayer()
        } else if(space.getName().equals("Magenta Space")) {
//            game.getCurrentPlayer()
        }
    }

    public void startGame() throws IOException {
        game.getActionCardDeck();
        game.getBlueCardDeck();
        game.getCareerCardDeck();
        game.getHouseCardDeck();
        game.getSalaryCardDeck();

        // Make it in a way so that it'll loop (through buttons)
        for(int i = 0; i < this.numPlayers; i++) {
            // ask for Path
            Stage getPathStage = new Stage();
            getPathStage.initStyle(StageStyle.UNDECORATED);
            getPathStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader getPathLoader = new FXMLLoader(getClass().getResource("/view/GetPath.fxml"));
            GetPathController getPathController = new GetPathController(i + 1, game.getCareerPath(), game.getCollegePath());
            getPathLoader.setController(getPathController);

            getPathStage.setScene(new Scene(getPathLoader.load()));

            getPathStage.showAndWait();
        }
    }
}
