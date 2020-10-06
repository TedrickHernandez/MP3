package model;

public class BlueCard
{
    private int blueCardValue;
    private String blueCardType;
    private String associatedCareer;

    public BlueCard (int insertBlueCardValue, String insertBlueCardType, String insertAssociatedCareer)
    {
        blueCardValue = insertBlueCardValue;
        blueCardType = insertBlueCardType;
        associatedCareer = insertAssociatedCareer;
    }

    public int getBlueCardValue ()
    {
        return blueCardValue;
    }

    public String getBlueCardType ()
    {
        return blueCardType;
    }

    public String getAssociatedCareer ()
    {
        return associatedCareer;
    }
}