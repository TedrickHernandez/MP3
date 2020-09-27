package model;

public class ActionCard
{
    private int actionCardValue;
    private String actionCardType;
    private String actionCardTitle;

    public ActionCard (String insertActionCardType, int insertActionCardValue)
    {
        actionCardValue = insertActionCardValue;
        actionCardType = insertActionCardType;
    }

    public void setActionCardTitle (String insertActionCardTitle)
    {
        actionCardTitle = insertActionCardTitle;
    }

    public int getActionCardValue ()
    {
        return actionCardValue;
    }

    public String getActionCardType ()
    {
        return actionCardType;
    }

    public String getActionCardTitle ()
    {
        return actionCardTitle;
    }
}