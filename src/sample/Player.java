package sample;

public class Player
{
    private int playerCash = 200000;
    private int playerSalary;
    private int playerTaxDue;
    private int playerPayRaises = 0;
    private int playerLoans = 0;
    private int playerSpace;
    private int playerChildren = 0;
    private String playerHouse = "Homeless";
    private String playerCareer;
    private boolean playerMarried = false;

    public Player (String insertCareer, int insertSalary, int insertTaxDue, int insertSpace)
    {
        playerCareer = insertCareer;
        playerSalary = insertSalary;
        playerTaxDue = insertTaxDue;
        playerSpace = insertSpace;
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
}