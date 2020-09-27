package sample;

public class BlueCard
{
    private int blueCardValue;
    private String blueCardType;

    public BlueCard (int insertBlueCardValue, String insertBlueCardType)
    {
        blueCardValue = insertBlueCardValue;
        blueCardType = insertBlueCardType;
    }

    public int getBlueCardValue ()
    {
        return blueCardValue;
    }

    public String getBlueCardType ()
    {
        return blueCardType;
    }
}