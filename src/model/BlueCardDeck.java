package model;
import java.util.*;

public class BlueCardDeck
{
    private int blueCardIndex = 0;
    private ArrayList<BlueCard> blueCards = new ArrayList<>();

    public void generateBlueCardDeck ()
    {
        int randomValue;
        randomValue = ((int) (Math.random() * (15 - 5 + 1) + 5)) * 10000;
        blueCards.add(new BlueCard(randomValue, "Lawsuit"));
        blueCards.add(new BlueCard(0, "Salary Tax Due"));
        blueCards.add(new BlueCard(0, "Tip the Server"));
        blueCards.add(new BlueCard(0, "Ski Accident"));
        blueCards.add(new BlueCard(0, "Computer Repair"));
        blueCards.add(new BlueCard(0, "World Cup"));
        blueCards.add(new BlueCard(0, "F1 Race"));
    }

    public void shuffleBlueCards ()
    {
        Collections.shuffle(blueCards);
    }

    public int getBlueCardIndex ()
    {
        return blueCardIndex;
    }
}
