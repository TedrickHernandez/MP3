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
        /*Path retirementPath = new Path("Retirement Path");
        Path careerPath2 = new Path("Career Path", retirementPath);
        Path changeCareerPath = new Path("Change Career Path", retirementPath);
        careerPath = new Path("Career Path", careerPath2, changeCareerPath);
        collegePath = new Path("College Path", careerPath2);*/

        Path RP = createRetirementPath();
        Path MP2 = createMixedPath("Mixed Path 2", RP, null);
        Path CCP = createChangeCareerPath("Change Career Path", MP2, null);
        Path SFP = createStartFamilyPath("Start Family Path", MP2, null);
        Path MP1 = createMixedPath("Mixed Path 1", CCP, SFP);
        // Path startingPaths[] = {createCareerPath("Career Path", MP1, null), createCollegePath("College Path", MP1, null)};

        // return startingPaths;

        careerPath = createCareerPath("Career Path", MP1, null);
        collegePath = createCollegePath("College Path", MP1, null);
    }

    public Path createRetirementPath ()
    {
        Path retirementPath = new Path("Retirement Path", null);
        retirementPath.getSpaces().add(new Space("Retirement Space"));

        return retirementPath;
    }

    public Path createMixedPath (String insertName, Path path1, Path path2)
    {
        Path mixedPath = new Path(insertName, path1, path2);

        for (int i = 0; i < 7; i ++) {
            mixedPath.getSpaces().add(new Space("Orange Space"));
        }
        mixedPath.getSpaces().add(new Space("Green Space"));
        for (int i = 0; i < 6; i ++) {
            mixedPath.getSpaces().add(new Space("Orange Space"));
        }
        mixedPath.getSpaces().add(new Space("Pay Raise Space"));
        for (int i = 0; i < 5; i ++) {
            mixedPath.getSpaces().add(new Space("Orange Space"));
        }

        return mixedPath;
    }

    public Path createChangeCareerPath (String insertName, Path path1, Path path2)
    {
        Path changeCareerPath = new Path(insertName, path1, path2);

        changeCareerPath.getSpaces().add(new Space("Career Choice Space"));
        for (int i = 0; i < 6; i ++) {
            changeCareerPath.getSpaces().add(new Space("Orange Space"));
        }
        changeCareerPath.getSpaces().add(new Space("Pay Raise Space"));
        for (int i = 0; i < 7; i ++) {
            changeCareerPath.getSpaces().add(new Space("Orange Space"));
        }
        changeCareerPath.getSpaces().add(new Space("Blue Space"));
        changeCareerPath.getSpaces().add(new Space("Green Space"));
        for (int i = 0; i < 6; i ++) {
            changeCareerPath.getSpaces().add(new Space("Orange Space"));
        }
        changeCareerPath.getSpaces().add(new Space("Pay Raise Space"));

        return changeCareerPath;
    }

    public Path createStartFamilyPath (String insertName, Path path1, Path path2)
    {
        Path startFamilyPath = new Path(insertName, path1, path2);

        startFamilyPath.getSpaces().add(new Space("Get Married Space"));
        for (int i = 0; i < 6; i ++) {
            startFamilyPath.getSpaces().add(new Space("Orange Space"));
        }
        startFamilyPath.getSpaces().add(new Space("Buy House Space"));
        for (int i = 0; i < 5; i ++) {
            startFamilyPath.getSpaces().add(new Space("Orange Space"));
        }
        startFamilyPath.getSpaces().add(new Space("Have a Baby Space"));
        for (int i = 0; i < 3; i ++) {
            startFamilyPath.getSpaces().add(new Space("Orange Space"));
        }
        startFamilyPath.getSpaces().add(new Space("Blue Space"));
        startFamilyPath.getSpaces().add(new Space("Pay Raise Space"));
        for (int i = 0; i < 5; i ++) {
            startFamilyPath.getSpaces().add(new Space("Orange Space"));
        }
        startFamilyPath.getSpaces().add(new Space("Green Space"));

        return startFamilyPath;
    }

    public Path createCareerPath (String insertName, Path path1, Path path2)
    {
        Path careerPath = new Path(insertName, path1, path2);

        careerPath.getSpaces().add(new Space("Orange Space"));
        careerPath.getSpaces().add(new Space("Career Choice Path"));
        for (int i = 0; i < 8; i ++) {
            careerPath.getSpaces().add(new Space("Orange Space"));
        }
        careerPath.getSpaces().add(new Space("Get Married Space"));
        for (int i = 0; i < 5; i ++) {
            careerPath.getSpaces().add(new Space("Orange Space"));
        }
        careerPath.getSpaces().add(new Space("Green Space"));
        for (int i = 0; i < 8; i ++) {
            careerPath.getSpaces().add(new Space("Orange Space"));
        }
        careerPath.getSpaces().add(new Space("Pay Raise Space"));

        return careerPath;
    }

    public Path createCollegePath (String insertName, Path path1, Path path2)
    {
        Path collegePath = new Path(insertName, path1, path2);
        for (int i = 0; i < 14; i ++) {
            collegePath.getSpaces().add(new Space("Orange Space"));
        }
        collegePath.getSpaces().add(new Space("Graduation Space"));
        collegePath.getSpaces().add(new Space("Career Choice Space"));

        return collegePath;
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
