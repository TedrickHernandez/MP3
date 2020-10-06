package model;
import java.util.*;

public class ActionCardDeck
{
    private int actionCardAmount;
    private int actionCardIndex = 0;
    private ArrayList<ActionCard> actionCards = new ArrayList<>();

    public ActionCardDeck (int insertActionCardAmount)
    {
        actionCardAmount = insertActionCardAmount;
    }

    public void generateActionCardDeck ()
    {
        int generateCtr = 0, iterativeCtr, randomIndex, randomValue;
        String[] collectNames = {"Tax refund!", "Sell an item!", "Bonus payday!", "Write a book!"};
        String[] payNames = {"Buy an item!", "Visit a place!", "Watch a show!", "Traffic violation!"};
        String[] payPlayerNames = {"Lawsuit", "Christmas Bonus"};
        String[] collectPlayerNames = {"File a Lawsuit", "It's Your Birthday"};
        for (iterativeCtr = 0; iterativeCtr < actionCardAmount * 0.4; iterativeCtr ++)
        {
            randomIndex = (int) (Math.random() * 4);
            randomValue = ((int) (Math.random() * (100 - 10 + 1) + 10)) * 1000;
            actionCards.add(new ActionCard("Collect from the Bank", randomValue));
            actionCards.get(generateCtr).setActionCardTitle(collectNames[randomIndex]);
            generateCtr ++;
        }
        for (iterativeCtr = 0; iterativeCtr < actionCardAmount * 0.4; iterativeCtr ++)
        {
            randomIndex = (int) (Math.random() * 4);
            randomValue = ((int) (Math.random() * (100 - 10 + 1) + 10)) * 1000;
            actionCards.add(new ActionCard("Pay the Bank", randomValue));
            actionCards.get(generateCtr).setActionCardTitle(payNames[randomIndex]);
            generateCtr ++;
        }
        for (iterativeCtr = 0; iterativeCtr < actionCardAmount * 0.1; iterativeCtr ++)
        {
            randomIndex = (int) (Math.random() * 2);
            randomValue = ((int) (Math.random() * (100 - 10 + 1) + 10)) * 1000;
            actionCards.add(new ActionCard("Pay the Player/s", randomValue));
            actionCards.get(generateCtr).setActionCardTitle(payPlayerNames[randomIndex]);
            generateCtr ++;
        }
        for (iterativeCtr = 0; iterativeCtr < actionCardAmount * 0.1; iterativeCtr ++)
        {
            randomIndex = (int) (Math.random() * 2);
            randomValue = ((int) (Math.random() * (100 - 10 + 1) + 10)) * 1000;
            actionCards.add(new ActionCard("Collect from Player/s", randomValue));
            actionCards.get(generateCtr).setActionCardTitle(collectPlayerNames[randomIndex]);
            generateCtr ++;
        }
    }

    public void shuffleActionCards ()
    {
        Collections.shuffle(actionCards);
    }

    public int getActionCardAmount ()
    {
        return actionCardAmount;
    }

    public int getActionCardIndex ()
    {
        return actionCardIndex;
    }

    public ArrayList<ActionCard> getActionCards ()
    {
        return actionCards;
    }

    public void resetActionCardDeck ()
    {
        shuffleActionCards();
        actionCardIndex = 0;
    }

    public void addActionCardIndex ()
    {
        actionCardIndex ++;
    }
}