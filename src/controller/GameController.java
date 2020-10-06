package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    private Label label_playerNo;

    @FXML
    private Label label_playerCash;

    @FXML
    private Label label_playerCareer;

    @FXML
    private Label label_playerSalary;

    @FXML
    private Label label_playerTaxDue;

    @FXML
    private Label label_playerMarried;

    @FXML
    private Label label_playerChildren;

    @FXML
    private Label label_playerHouse;

    @FXML
    private Label label_playerLoans;

    @FXML
    private Label label_playerPath;

    @FXML
    private Label label_playerSpace;

    @FXML
    private Label label_playerSpaceType;

    public GameController(int numPlayers) {
        this.numPlayers = numPlayers;
        game = new Game(numPlayers);
    }

    @FXML
    /*public void onClickBackToMenu(ActionEvent ae) throws IOException {
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
        MenuController menuController = new MenuController();
        menuLoader.setController(menuController);

        stage.setScene(new Scene(menuLoader.load()));
    }*/

    public void rollDice(ActionEvent ae) throws IOException {
        if(game.getActivePlayers().size() == 0) {
            /* Final comparisons */
            int winnerID = 0, winnerID2 = 0, winnerCash = 0, drawGame = 0;
            game.determineWinner();
            winnerID = game.getWinnerID();
            winnerID2 = game.getWinnerID2();
            winnerCash = game.getWinnerFinalCash();
            drawGame = game.getDrawGame();

            /* Display results */
            Stage retirementScreenStage = new Stage();
            retirementScreenStage.initStyle(StageStyle.UTILITY);
            retirementScreenStage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader retirementScreenLoader = new FXMLLoader(getClass().getResource("/view/RetirementScreen.fxml"));
            RetirementScreenController retirementScreenController = new RetirementScreenController(winnerID, winnerID2, winnerCash, drawGame);
            retirementScreenLoader.setController(retirementScreenController);
            retirementScreenStage.setScene(new Scene(retirementScreenLoader.load()));
            retirementScreenStage.showAndWait();
        } else {
            /*Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();*/

            Random random = new Random();
            // int rolled = random.nextInt(10) + 1;
            int rolled = 1;
            System.out.println(game.getCurrentPlayer().getPlayerID() + " has rolled " + rolled);

            Stage diceNotifStage = new Stage();
            diceNotifStage.initStyle(StageStyle.UTILITY);
            diceNotifStage.initModality(Modality.APPLICATION_MODAL);

            FXMLLoader diceNotifLoader = new FXMLLoader(getClass().getResource("/view/DiceNotif.fxml"));
            DiceNotifController diceNotifController = new DiceNotifController(game.getCurrentPlayer().getPlayerID(), rolled);
            diceNotifLoader.setController(diceNotifController);
            diceNotifStage.setScene(new Scene(diceNotifLoader.load()));
            diceNotifStage.showAndWait();

            String spaceLanded = game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName();
            game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).removePlayer(game.getCurrentPlayer());
            for(int i = 0; i < rolled; i++) {

                /* Path Traversal Codes */

                if (game.getCurrentPlayer().getPlayerSpace() >= game.getCurrentPlayer().getPlayerPath().getNSpaces() - 1)
                // if (game.getCurrentPlayer().getPlayerSpace() >= 5)
                {
                    switch (game.getCurrentPlayer().getPlayerPath().getName())
                    {
                        /* Single Path Traversals */
                        case "College Path":
                        case "Career Path":
                            game.getCurrentPlayer().setPath(game.getMixedPath1());
                            break;
                        case "Change Career Path":
                        case "Start Family Path":
                            game.getCurrentPlayer().setPath(game.getMixedPath2());
                            break;
                        case "Mixed Path 2":
                            game.getCurrentPlayer().setPath(game.getRetirementPath());
                            break;

                            /* Multiple Path Traversals */

                        case "Mixed Path 1":
                            Stage getPathStage = new Stage();
                            getPathStage.initStyle(StageStyle.UNDECORATED);
                            getPathStage.initModality(Modality.APPLICATION_MODAL);
                            FXMLLoader getPathLoader = new FXMLLoader(getClass().getResource("/view/GetPath.fxml"));
                            GetPathController getPathController = new GetPathController(game.getCurrentPlayer().getPlayerID(), game.getChangeCareerPath(), game.getStartFamilyPath());
                            getPathLoader.setController(getPathController);
                            getPathStage.setScene(new Scene(getPathLoader.load()));
                            getPathStage.showAndWait();
                            Path chosenPath = getPathController.returnPath();
                            game.getCurrentPlayer().setPath(chosenPath);
                            break;
                    }
                }

                game.getCurrentPlayer().addPlayerSpace();

                spaceLanded = game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName();
                System.out.println(game.getCurrentPlayer().getPlayerID() + " has landed on a/n " + spaceLanded);

                // magenta space so break
                //if(game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName().equals("Magenta Space")) break;
                switch (game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName())
                {
                    case "Retirement Space":
                    case "Career Choice Space":
                    case "Get Married Space":
                    case "Buy House Space":
                    case "Graduation Space":
                        i = rolled;
                        break;
                }
            }
            handleSpace(spaceLanded);
            // game.getCurrentPlayer().getPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).addPlayer(game.getCurrentPlayer());

            if (spaceLanded != "Retirement Space") {
                turn++;
            }

            if (turn >= game.getActivePlayers().size()) {
                turn = 0;
            }
            game.setTurn(turn);

            if (game.getActivePlayers().size() > 0) {
                label_playerNo.setText("Player " + game.getCurrentPlayer().getPlayerID());
                label_playerCash.setText("PHP " + game.getCurrentPlayer().getPlayerCash());
                label_playerCareer.setText(game.getCurrentPlayer().getPlayerCareer());
                label_playerSalary.setText("SAL: " + game.getCurrentPlayer().getPlayerSalary());
                label_playerTaxDue.setText("TAX: " + game.getCurrentPlayer().getPlayerTaxDue());
                if (game.getCurrentPlayer().getPlayerMarried() == true) {
                    label_playerMarried.setText("Married");
                } else {
                    label_playerMarried.setText("Single");
                }
                label_playerChildren.setText("Children: " + game.getCurrentPlayer().getPlayerChildren());
                label_playerHouse.setText(game.getCurrentPlayer().getPlayerHouse().getHouseCardName());
                label_playerLoans.setText("Loans: " + game.getCurrentPlayer().getPlayerLoans());
                label_playerPath.setText(game.getCurrentPlayer().getPlayerPath().getName());
                label_playerSpace.setText("Space: " + game.getCurrentPlayer().getPlayerSpace());
                label_playerSpaceType.setText(game.getCurrentPlayer().getPlayerPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName());
            }
        }
        if(game.getActivePlayers().size() == 0) rollButton.setText("End Game");
    }

    /**
     *
     * @param insertSpace String name of the landed space.
     */
    public void handleSpace(String insertSpace) throws IOException {
        if(insertSpace.equals("Orange Space")) {
            String cardType = game.getActionCardDeck().getActionCards().get(game.getActionCardDeck().getActionCardIndex()).getActionCardType();
            String cardTitle = game.getActionCardDeck().getActionCards().get(game.getActionCardDeck().getActionCardIndex()).getActionCardTitle();
            int cardValue = game.getActionCardDeck().getActionCards().get(game.getActionCardDeck().getActionCardIndex()).getActionCardValue();

            Stage landOrangeSpaceStage = new Stage();
            landOrangeSpaceStage.initStyle(StageStyle.UTILITY);
            landOrangeSpaceStage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader landOrangeSpaceLoader = new FXMLLoader(getClass().getResource("/view/LandOrangeSpace.fxml"));
            LandOrangeSpaceController landOrangeSpaceController = new LandOrangeSpaceController(game.getCurrentPlayer().getPlayerID(), cardType, cardTitle, cardValue);
            landOrangeSpaceLoader.setController(landOrangeSpaceController);
            landOrangeSpaceStage.setScene(new Scene(landOrangeSpaceLoader.load()));
            landOrangeSpaceStage.showAndWait();

            switch (cardType)
            {
                case "Collect from the Bank":
                    game.getCurrentPlayer().addPlayerCash(cardValue);
                    break;

                case "Pay the Bank":
                    game.getCurrentPlayer().reducePlayerCash(cardValue);
                    break;

                case "Pay the Player/s":
                    switch (cardTitle) {
                        case "Lawsuit":
                            switch (game.getActivePlayers().size()) {
                                case 1:
                                    game.getCurrentPlayer().reducePlayerCash(cardValue);
                                    break;
                                case 2:
                                    switch (turn) {
                                        case 0:
                                            game.getCurrentPlayer().reducePlayerCash(cardValue);
                                            game.getActivePlayers().get(turn + 1).addPlayerCash(cardValue);
                                            break;
                                        case 1:
                                            game.getCurrentPlayer().reducePlayerCash(cardValue);
                                            game.getActivePlayers().get(turn - 1).addPlayerCash(cardValue);
                                            break;
                                    }
                                    break;
                                case 3:
                                    Player player1 = null;
                                    Player player2 = null;
                                    int chosenPlayerID;
                                    switch (turn)
                                    {
                                        case 0:
                                            player1 = game.getActivePlayers().get(turn + 1);
                                            player2 = game.getActivePlayers().get(turn + 2);
                                            break;
                                        case 1:
                                            player1 = game.getActivePlayers().get(turn - 1);
                                            player2 = game.getActivePlayers().get(turn + 1);
                                            break;
                                        case 2:
                                            player1 = game.getActivePlayers().get(turn - 2);
                                            player2 = game.getActivePlayers().get(turn - 1);
                                            break;
                                    }
                                    Stage choosePlayerStage = new Stage();
                                    choosePlayerStage.initStyle(StageStyle.UNDECORATED);
                                    choosePlayerStage.initModality(Modality.APPLICATION_MODAL);
                                    FXMLLoader choosePlayerLoader = new FXMLLoader(getClass().getResource("/view/ChoosePlayer.fxml"));
                                    ChoosePlayerController choosePlayerController = new ChoosePlayerController(player1, player2);
                                    choosePlayerLoader.setController(choosePlayerController);
                                    choosePlayerStage.setScene(new Scene(choosePlayerLoader.load()));
                                    choosePlayerStage.showAndWait();
                                    chosenPlayerID = choosePlayerController.returnPlayerID();

                                    game.getCurrentPlayer().reducePlayerCash(cardValue);
                                    switch (chosenPlayerID)
                                    {
                                        case 1:
                                            game.getActivePlayers().get(0).addPlayerCash(cardValue);
                                            break;
                                        case 2:
                                            game.getActivePlayers().get(1).addPlayerCash(cardValue);
                                            break;
                                        case 3:
                                            game.getActivePlayers().get(2).addPlayerCash(cardValue);
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case "Christmas Bonus":
                            switch (turn)
                            {
                                case 0:
                                    game.getCurrentPlayer().reducePlayerCash(cardValue);
                                    game.getActivePlayers().get(turn + 1).addPlayerCash(cardValue);
                                    if (game.getActivePlayers().size() == 3)
                                    {
                                        game.getCurrentPlayer().reducePlayerCash(cardValue);
                                        game.getActivePlayers().get(turn + 2).addPlayerCash(cardValue);
                                    }
                                    break;
                                case 1:
                                    game.getCurrentPlayer().reducePlayerCash(cardValue);
                                    game.getActivePlayers().get(turn - 1).addPlayerCash(cardValue);
                                    if (game.getActivePlayers().size() == 3)
                                    {
                                        game.getCurrentPlayer().reducePlayerCash(cardValue);
                                        game.getActivePlayers().get(turn + 1).addPlayerCash(cardValue);
                                    }
                                    break;
                                case 2:
                                    game.getCurrentPlayer().reducePlayerCash(cardValue * 2);
                                    game.getActivePlayers().get(turn - 2).addPlayerCash(cardValue);
                                    game.getActivePlayers().get(turn - 1).addPlayerCash(cardValue);
                                    break;
                            }
                            break;
                    }
                    break;
                case "Collect from Player/s":
                    switch (cardTitle) {
                        case "File a Lawsuit":
                            switch (game.getActivePlayers().size()) {
                                case 1:
                                    game.getCurrentPlayer().addPlayerCash(cardValue);
                                    break;
                                case 2:
                                    switch (turn) {
                                        case 0:
                                            game.getCurrentPlayer().addPlayerCash(cardValue);
                                            game.getActivePlayers().get(turn + 1).reducePlayerCash(cardValue);
                                            break;
                                        case 1:
                                            game.getCurrentPlayer().addPlayerCash(cardValue);
                                            game.getActivePlayers().get(turn - 1).reducePlayerCash(cardValue);
                                            break;
                                    }
                                    break;
                                case 3:
                                    Player player1 = null;
                                    Player player2 = null;
                                    int chosenPlayerID;
                                    switch (turn)
                                    {
                                        case 0:
                                            player1 = game.getActivePlayers().get(turn + 1);
                                            player2 = game.getActivePlayers().get(turn + 2);
                                            break;
                                        case 1:
                                            player1 = game.getActivePlayers().get(turn - 1);
                                            player2 = game.getActivePlayers().get(turn + 1);
                                            break;
                                        case 2:
                                            player1 = game.getActivePlayers().get(turn - 2);
                                            player2 = game.getActivePlayers().get(turn - 1);
                                            break;
                                    }
                                    Stage choosePlayerStage = new Stage();
                                    choosePlayerStage.initStyle(StageStyle.UNDECORATED);
                                    choosePlayerStage.initModality(Modality.APPLICATION_MODAL);
                                    FXMLLoader choosePlayerLoader = new FXMLLoader(getClass().getResource("/view/ChoosePlayer.fxml"));
                                    ChoosePlayerController choosePlayerController = new ChoosePlayerController(player1, player2);
                                    choosePlayerLoader.setController(choosePlayerController);
                                    choosePlayerStage.setScene(new Scene(choosePlayerLoader.load()));
                                    choosePlayerStage.showAndWait();
                                    chosenPlayerID = choosePlayerController.returnPlayerID();

                                    game.getCurrentPlayer().addPlayerCash(cardValue);
                                    switch (chosenPlayerID)
                                    {
                                        case 1:
                                            game.getActivePlayers().get(0).reducePlayerCash(cardValue);
                                            break;
                                        case 2:
                                            game.getActivePlayers().get(1).reducePlayerCash(cardValue);
                                            break;
                                        case 3:
                                            game.getActivePlayers().get(2).reducePlayerCash(cardValue);
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case "It's Your Birthday":
                            switch (turn)
                            {
                                case 0:
                                    game.getCurrentPlayer().addPlayerCash(cardValue);
                                    game.getActivePlayers().get(turn + 1).reducePlayerCash(cardValue);
                                    if (game.getActivePlayers().size() == 3)
                                    {
                                        game.getCurrentPlayer().addPlayerCash(cardValue);
                                        game.getActivePlayers().get(turn + 2).reducePlayerCash(cardValue);
                                    }
                                    break;
                                case 1:
                                    game.getCurrentPlayer().addPlayerCash(cardValue);
                                    game.getActivePlayers().get(turn - 1).reducePlayerCash(cardValue);
                                    if (game.getActivePlayers().size() == 3)
                                    {
                                        game.getCurrentPlayer().addPlayerCash(cardValue);
                                        game.getActivePlayers().get(turn + 1).reducePlayerCash(cardValue);
                                    }
                                    break;
                                case 2:
                                    game.getCurrentPlayer().addPlayerCash(cardValue * 2);
                                    game.getActivePlayers().get(turn - 2).reducePlayerCash(cardValue);
                                    game.getActivePlayers().get(turn - 1).reducePlayerCash(cardValue);
                                    break;
                            }
                            break;
                    }
                    break;
            }
            if (game.getActionCardDeck().getActionCardIndex() >= game.getActionCardDeck().getActionCardAmount() - 1)
            {
                game.getActionCardDeck().resetActionCardDeck();
            }
            else
            {
                game.getActionCardDeck().addActionCardIndex();
            }

        } else if(insertSpace.equals("Blue Space")) {
            String cardType = game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardType();
            int cardValue = game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardValue();

            Stage landBlueSpace1Stage = new Stage();
            landBlueSpace1Stage.initStyle(StageStyle.UTILITY);
            landBlueSpace1Stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader landBlueSpace1Loader = new FXMLLoader(getClass().getResource("/view/LandBlueSpace1.fxml"));
            LandBlueSpace1Controller landBlueSpace1Controller = new LandBlueSpace1Controller(game.getCurrentPlayer().getPlayerID(), cardType);
            landBlueSpace1Loader.setController(landBlueSpace1Controller);
            landBlueSpace1Stage.setScene(new Scene(landBlueSpace1Loader.load()));
            landBlueSpace1Stage.showAndWait();

            LandBlueSpace2Controller landBlueSpace2Controller = null;

            Stage landBlueSpace2Stage = new Stage();
            landBlueSpace2Stage.initStyle(StageStyle.UTILITY);
            landBlueSpace2Stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader landBlueSpace2Loader = new FXMLLoader(getClass().getResource("/view/LandBlueSpace2.fxml"));

            if (game.getCurrentPlayer().getPlayerCareer() == game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getAssociatedCareer()) {
                landBlueSpace2Controller = new LandBlueSpace2Controller(game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardType(),
                        game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardValue(), game.getCurrentPlayer().getPlayerTaxDue(),
                        game.getActivePlayers().size() + game.getRetiredPlayers().size(), game.getCurrentPlayer().getPlayerSalary(), true);
            }
            else
            {
                landBlueSpace2Controller = new LandBlueSpace2Controller(game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardType(),
                        game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getBlueCardValue(), game.getCurrentPlayer().getPlayerTaxDue(),
                        game.getActivePlayers().size() + game.getRetiredPlayers().size(), game.getCurrentPlayer().getPlayerSalary(), false);
            }

            landBlueSpace2Loader.setController(landBlueSpace2Controller);
            landBlueSpace2Stage.setScene(new Scene(landBlueSpace2Loader.load()));
            landBlueSpace2Stage.showAndWait();

            int changeValue = landBlueSpace2Controller.getFinalValue();
            boolean sameCareer = landBlueSpace2Controller.getSameCareer();

            if (sameCareer) {
                game.getCurrentPlayer().addPlayerCash(changeValue);
            } else if (!(sameCareer)) {
                game.getCurrentPlayer().reducePlayerCash(changeValue);
                for (int i = 0; i < game.getActivePlayers().size(); i ++)
                {
                    if (game.getActivePlayers().get(i).getPlayerCareer() == game.getBlueCardDeck().getBlueCards().get(game.getBlueCardDeck().getBlueCardIndex()).getAssociatedCareer())
                    {
                        game.getActivePlayers().get(i).addPlayerCash(changeValue);
                    }
                }
            }

            if (game.getBlueCardDeck().getBlueCardIndex() >= game.getBlueCardDeck().getBlueCards().size() - 1)
            {
                game.getBlueCardDeck().resetBlueCardDeck();
            }
            else
            {
                game.getBlueCardDeck().addBlueCardDeckIndex();
            }

        } else if(insertSpace.equals("Green Space")) {
//            game.getCurrentPlayer()
        } else if(insertSpace.equals("Pay Raise Space")) {
//            game.getCurrentPlayer()
        }
        else if (insertSpace.equals("Retirement Space"))
        {
            Stage playerRetiresStage = new Stage();
            playerRetiresStage.initStyle(StageStyle.UTILITY);
            playerRetiresStage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader playerRetiresLoader = new FXMLLoader(getClass().getResource("/view/PlayerRetires.fxml"));
            PlayerRetiresController playerRetiresController = new PlayerRetiresController(game.getCurrentPlayer().getPlayerID(), game.getCurrentPlayer().getPlayerCash(),
                    game.getCurrentPlayer().getPlayerChildren(), game.getCurrentPlayer().getPlayerHouse(), game.getCurrentPlayer().getPlayerLoans());
            playerRetiresLoader.setController(playerRetiresController);
            playerRetiresStage.setScene(new Scene(playerRetiresLoader.load()));
            playerRetiresStage.showAndWait();
            game.getCurrentPlayer().setPlayerFinalCash(playerRetiresController.getPlayerFinalCash());
            game.getRetiredPlayers().add(game.getCurrentPlayer());
            game.getActivePlayers().remove(turn);
        }

        for (int i = 0; i < game.getActivePlayers().size(); i ++)
        {
            while (game.getActivePlayers().get(i).getPlayerCash() < 0)
            {
                game.getActivePlayers().get(i).addPlayerLoan();
            }
        }
    }

    public void startGame() throws IOException {
        HouseCard homelessHouseCard = new HouseCard(0, 0, "Homeless");

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

            Path chosenPath = getPathController.returnPath();
            if (chosenPath.getName().equals("College Path")) {
                game.getActivePlayers().add(new Player("College", 0, 0, getPathController.returnPath(), homelessHouseCard));
                // game.getActivePlayers().add(new Player("College", 0, 0, game.getMixedPath1()));
            }
            else
            {
                CareerCard insertCareerCard = game.getCareerCardDeck().pickTopCareerCard(false);
                SalaryCard insertSalaryCard = game.getSalaryCardDeck().pickTopSalaryCard();
                String insertCareer = insertCareerCard.getCareerCardName();
                int insertSalary = insertSalaryCard.getSalaryCardValue();
                int insertTaxDue = insertSalaryCard.getSalaryCardTaxDue();
                game.getActivePlayers().add(new Player(insertCareer, insertSalary, insertTaxDue, getPathController.returnPath(), homelessHouseCard));
            }

            System.out.println(game.getActivePlayers().get(i).getPlayerID());
            System.out.println(game.getActivePlayers().get(i).getPlayerCareer());
            System.out.println(game.getActivePlayers().get(i).getPath().getName());
            System.out.println(game.getActivePlayers().get(i).getPlayerSalary());
            System.out.println(game.getActivePlayers().get(i).getPlayerTaxDue());
        }

        label_playerNo.setText("Player " + game.getCurrentPlayer().getPlayerID());
        label_playerCash.setText("PHP " + game.getCurrentPlayer().getPlayerCash());
        label_playerCareer.setText(game.getCurrentPlayer().getPlayerCareer());
        label_playerSalary.setText("SAL: " + game.getCurrentPlayer().getPlayerSalary());
        label_playerTaxDue.setText("TAX: " +  game.getCurrentPlayer().getPlayerTaxDue());
        if (game.getCurrentPlayer().getPlayerMarried() == true)
        {
            label_playerMarried.setText("Married");
        }
        else
        {
            label_playerMarried.setText("Single");
        }
        label_playerChildren.setText("Children: " + game.getCurrentPlayer().getPlayerChildren());
        label_playerHouse.setText(game.getCurrentPlayer().getPlayerHouse().getHouseCardName());
        label_playerLoans.setText("Loans: " + game.getCurrentPlayer().getPlayerLoans());
        label_playerPath.setText(game.getCurrentPlayer().getPlayerPath().getName());
        label_playerSpace.setText("Space: " + game.getCurrentPlayer().getPlayerSpace());
        label_playerSpaceType.setText(game.getCurrentPlayer().getPlayerPath().getSpaces().get(game.getCurrentPlayer().getPlayerSpace()).getName());
    }
}