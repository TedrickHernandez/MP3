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
    private String playerHouse = "Homeless";
    private String playerCareer;
    private boolean playerMarried = false;
    private Path path;

    public Player (String insertCareer, int insertSalary, int insertTaxDue, Path insertPath)
    {
        playerCount ++;
        playerID = playerCount;
        playerCareer = insertCareer;
        playerSalary = insertSalary;
        playerTaxDue = insertTaxDue;
        path = insertPath;
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
    public int getPlayerCash ()
    {
        return playerCash;
    }

    public int getPlayerSalary ()
    {
        return playerSalary;
    }

    public int getPlayerTaxDue ()
    {
        return playerTaxDue;
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

    public String getPlayerHouse ()
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
}