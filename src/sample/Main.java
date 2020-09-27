package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("That's Life!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        /* Card Deck Generations & Shuffling */

        ActionCardDeck actionCardDeck = new ActionCardDeck(50);
        BlueCardDeck blueCardDeck = new BlueCardDeck();
        CareerCardDeck careerCardDeck = new CareerCardDeck();
        SalaryCardDeck salaryCardDeck = new SalaryCardDeck();
        HouseCardDeck houseCardDeck = new HouseCardDeck();

        actionCardDeck.generateActionCardDeck();
        actionCardDeck.shuffleActionCards();

        blueCardDeck.generateBlueCardDeck();
        blueCardDeck.shuffleBlueCards();

        careerCardDeck.generateCareerCardDeck();
        careerCardDeck.shuffleCareerCards();

        salaryCardDeck.generateSalaryCardDeck();
        salaryCardDeck.shuffleSalaryCards();

        houseCardDeck.generateHouseCardDeck();
        houseCardDeck.shuffleHouseCards();

        /* Whatever the hell this is */

        launch(args);
    }
}