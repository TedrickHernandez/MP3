package model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> activePlayers;
    private ArrayList<Player> retiredPlayers;
    private ActionCardDeck actionCardDeck = new ActionCardDeck(50);
    private BlueCardDeck blueCardDeck = new BlueCardDeck();
    private CareerCardDeck careerCardDeck = new CareerCardDeck();
    private SalaryCardDeck salaryCardDeck = new SalaryCardDeck();
    private HouseCardDeck houseCardDeck = new HouseCardDeck();
    private Path collegePath, careerPath;
    private int turn = 0;

    public Game(int numPlayers) {
        activePlayers = new ArrayList<>();
        retiredPlayers = new ArrayList<>();

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

        generatePaths();
    }

    public void generatePaths() {
        Path retirementPath = new Path("Retirement Path");
        Path careerPath2 = new Path("Career Path", retirementPath);
        Path changeCareerPath = new Path("Change Career Path", retirementPath);
        careerPath = new Path("Career Path", careerPath2, changeCareerPath);
        collegePath = new Path("College Path", careerPath2);
    }

    public ArrayList<Player> getActivePlayers() {
        return activePlayers;
    }

    public ArrayList<Player> getRetiredPlayers() {
        return retiredPlayers;
    }

    public ActionCardDeck getActionCardDeck() {
        return actionCardDeck;
    }

    public BlueCardDeck getBlueCardDeck() {
        return blueCardDeck;
    }

    public CareerCardDeck getCareerCardDeck() {
        return careerCardDeck;
    }

    public HouseCardDeck getHouseCardDeck() {
        return houseCardDeck;
    }

    public SalaryCardDeck getSalaryCardDeck() {
        return salaryCardDeck;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getCurrentPlayer() {
        return activePlayers.get(turn);
    }

    public Path getCollegePath() {
        return collegePath;
    }

    public Path getCareerPath() {
        return careerPath;
    }
}
