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
        blueCards.add(new BlueCard(randomValue, "Lawsuit", "Lawyer"));
        blueCards.add(new BlueCard(0, "Salary Tax Due", "Accountant"));
        blueCards.add(new BlueCard(0, "Tip the Server", "Server"));
        blueCards.add(new BlueCard(0, "Ski Accident", "Doctor"));
        blueCards.add(new BlueCard(0, "Computer Repair", "Computer Consultant"));
        blueCards.add(new BlueCard(0, "World Cup", "Athlete"));
        blueCards.add(new BlueCard(0, "F1 Race", "Racecar Driver"));
    }

    public void shuffleBlueCards ()
    {
        Collections.shuffle(blueCards);
    }

    public int getBlueCardIndex ()
    {
        return blueCardIndex;
    }

    public ArrayList<BlueCard> getBlueCards ()
    {
        return blueCards;
    }

    public void addBlueCardDeckIndex ()
    {
        blueCardIndex ++;
    }

    public void resetBlueCardDeck ()
    {
        shuffleBlueCards();
        blueCardIndex = 0;
    }
}
