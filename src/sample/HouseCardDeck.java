package sample;
import java.util.*;

public class HouseCardDeck
{
    ArrayList<HouseCard> houseCards = new ArrayList<>();

    public void generateHouseCardDeck ()
    {
        houseCards.add(new HouseCard(40000, 50000, "Split-Level"));
        houseCards.add(new HouseCard(60000, 75000, "Mobile Home"));
        houseCards.add(new HouseCard(90000, 110000, "Log Cabin"));
        houseCards.add(new HouseCard(120000, 150000, "Country Cottage"));
        houseCards.add(new HouseCard(170000, 220000, "Dutch Colonial"));
        houseCards.add(new HouseCard(250000, 320000, "Beach House"));
        houseCards.add(new HouseCard(350000, 450000, "Victorian"));
    }

    public void shuffleHouseCards ()
    {
        Collections.shuffle(houseCards);
    }
}