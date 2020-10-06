package model;

public class Player
{
    private int playerID;
    private static int playerCount;
    private int playerCash = 200000;
    private int playerSalary;
    private int playerTaxDue;
    private int playerPayRaises = 0;
    private int playerLoans = 0;
    private int playerSpace = 0;
    private int playerChildren = 0;
    private HouseCard playerHouse;
    private String playerCareer;
    private boolean playerMarried = false;
    private Path path;
    private int playerFinalCash;

    public Player (String insertCareer, int insertSalary, int insertTaxDue, Path insertPath, HouseCard insertHouse)
    {
        playerCount ++;
        playerID = playerCount;
        playerCareer = insertCareer;
        playerSalary = insertSalary;
        playerTaxDue = insertTaxDue;
        path = insertPath;
        playerHouse = insertHouse;
        // playerSpace = insertSpace;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
        this.playerSpace = 0;
    }

    public void addPlayerSpace() {
        playerSpace++;
    }

    public void setPlayerFinalCash (int insertPlayerFinalCash)
    {
        playerFinalCash = insertPlayerFinalCash;
    }

    public int getPlayerCash ()
    {
        return playerCash;
    }

    public int getPlayerSalary ()
    {
        return playerSalary + (10000 * playerPayRaises);
    }

    public int getPlayerTaxDue ()
    {
        return playerTaxDue + (2000 * playerPayRaises);
    }

    public int getPlayerPayRaises ()
    {
        return playerPayRaises;
    }

    public int getPlayerLoans ()
    {
        return playerLoans;
    }

    public int getPlayerSpace ()
    {
        return playerSpace;
    }

    public int getPlayerChildren ()
    {
        return playerChildren;
    }

    public HouseCard getPlayerHouse ()
    {
        return playerHouse;
    }

    public String getPlayerCareer ()
    {
        return playerCareer;
    }

    public int getPlayerID ()
    {
        return playerID;
    }

    public boolean getPlayerMarried ()
    {
        return playerMarried;
    }

    public Path getPlayerPath ()
    {
        return path;
    }

    public int getPlayerFinalCash ()
    {
        return playerFinalCash;
    }

    public void addPlayerLoan ()
    {
        playerCash += 20000;
        playerLoans += 1;
    }

    public void addPlayerCash (int insertAddCash)
    {
        playerCash += insertAddCash;
    }

    public void reducePlayerCash (int insertReduceCash)
    {
        playerCash -= insertReduceCash;
    }

    public void setPlayerMarried (boolean insertMarried)
    {
        playerMarried = insertMarried;
    }

    public void increasePayRaise ()
    {
        playerPayRaises ++;
    }

    public void resetPayRaise ()
    {
        playerPayRaises = 0;
    }
}