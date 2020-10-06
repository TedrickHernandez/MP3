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
    private Path collegePath, careerPath, mixedPath1, mixedPath2, retirementPath;
    private Path changeCareerPath, startFamilyPath;
    private int turn = 0;

    private int winnerID;
    private int winnerID2;
    private int winnerFinalCash;
    private int drawGame;

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

        retirementPath = createRetirementPath();
        mixedPath2 = createMixedPath("Mixed Path 2", retirementPath, null);
        changeCareerPath = createChangeCareerPath("Change Career Path", mixedPath2, null);
        startFamilyPath = createStartFamilyPath("Start Family Path", mixedPath2, null);
        mixedPath1 = createMixedPath("Mixed Path 1", changeCareerPath, startFamilyPath);
        // Path startingPaths[] = {createCareerPath("Career Path", MP1, null), createCollegePath("College Path", MP1, null)};

        // return startingPaths;

        careerPath = createCareerPath("Career Path", mixedPath1, null);
        collegePath = createCollegePath("College Path", mixedPath1, null);
    }

    public Path createRetirementPath ()
    {
        Path retirementPath = new Path("Retirement Path", null);
        retirementPath.getSpaces().add(new Space("Orange Space"));
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

    public Path getMixedPath1 ()
    {
        return mixedPath1;
    }

    public Path getMixedPath2 ()
    {
        return mixedPath2;
    }

    public Path getRetirementPath ()
    {
        return retirementPath;
    }

    public Path getChangeCareerPath ()
    {
        return changeCareerPath;
    }

    public Path getStartFamilyPath ()
    {
        return startFamilyPath;
    }

    public void determineWinner ()
    {
        int cash1 = 0, cash2 = 0, cash3 = 0;
        cash1 = retiredPlayers.get(0).getPlayerFinalCash();
        cash2 = retiredPlayers.get(1).getPlayerFinalCash();
        if (retiredPlayers.size() > 2)
        {
            cash3 = retiredPlayers.get(2).getPlayerFinalCash();
        }

        if (cash1 > cash2)
        {
            if (cash1 > cash3)
            {
                winnerID = retiredPlayers.get(0).getPlayerID();
                winnerFinalCash = cash1;
            }
            else
            {
                if (cash1 == cash3)
                {
                    winnerID = retiredPlayers.get(0).getPlayerID();
                    winnerID2 = retiredPlayers.get(2).getPlayerID();
                    winnerFinalCash = cash1;
                    drawGame = 1;
                }
                else
                {
                    winnerID = retiredPlayers.get(2).getPlayerID();
                    winnerFinalCash = cash3;
                }
            }
        }
        else
        {
            if (cash1 == cash2)
            {
                if (cash2 == cash3)
                {
                    winnerFinalCash = cash1;
                    drawGame = 2;
                }
                else
                {
                    if (cash1 < cash3)
                    {
                        winnerID = retiredPlayers.get(2).getPlayerID();
                        winnerFinalCash = cash3;
                    }
                    else
                    {
                        winnerID = retiredPlayers.get(0).getPlayerID();
                        winnerID2 = retiredPlayers.get(1).getPlayerID();
                        winnerFinalCash = cash1;
                        drawGame = 1;
                    }
                }
            }
            else
            {
                if (cash2 == cash3)
                {
                    winnerID = retiredPlayers.get(1).getPlayerID();
                    winnerID2 = retiredPlayers.get(2).getPlayerID();
                    winnerFinalCash = cash2;
                    drawGame = 1;
                }
                else
                {
                    if (cash2 > cash3)
                    {
                        winnerID = retiredPlayers.get(1).getPlayerID();
                        winnerFinalCash = cash2;
                    }
                    else
                    {
                        winnerID = retiredPlayers.get(2).getPlayerID();
                        winnerFinalCash = cash3;
                    }
                }
            }
        }
    }

    public int getWinnerID ()
    {
        return winnerID;
    }

    public int getWinnerID2 ()
    {
        return winnerID2;
    }

    public int getWinnerFinalCash ()
    {
        return winnerFinalCash;
    }

    public int getDrawGame ()
    {
        return drawGame;
    }
}