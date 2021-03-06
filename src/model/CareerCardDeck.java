package model;
import java.util.*;

public class CareerCardDeck
{
    private ArrayList<CareerCard> careerCards = new ArrayList<>();

    public void generateCareerCardDeck ()
    {
        int randomValue;
        randomValue = (int) (Math.random() * (8 - 5 + 1) + 5);
        careerCards.add(new CareerCard(randomValue, "Lawyer", true));
        randomValue = (int) (Math.random() * (7 - 4 + 1) + 4);
        careerCards.add(new CareerCard(randomValue, "Accountant", true));
        randomValue = (int) (Math.random() * (7 - 3 + 1) + 3);
        careerCards.add(new CareerCard(randomValue, "Computer Consultant", true));
        randomValue = (int) (Math.random() * (8 - 5 + 1) + 5);
        careerCards.add(new CareerCard(randomValue, "Doctor", true));
        randomValue = (int) (Math.random() * (4 - 1 + 1) + 1);
        careerCards.add(new CareerCard(randomValue, "Server", false));
        randomValue = (int) (Math.random() * (8 - 2 + 1) + 2);
        careerCards.add(new CareerCard(randomValue, "Racecar Driver", false));
        randomValue = (int) (Math.random() * (6 - 1 + 1) + 1);
        careerCards.add(new CareerCard(randomValue, "Athlete", false));
    }

    public void shuffleCareerCards ()
    {
        Collections.shuffle(careerCards);
    }

    /* @TODO Remember this for null pointer exception (possible bug area) */
    public CareerCard pickTopCareerCard (boolean collegeDegreeRequired)
    {
        for (int i = 0; i < careerCards.size(); i ++) {
            if (careerCards.get(i).getCareerCardDegreeRequired() == collegeDegreeRequired) {
                if (careerCards.get(i).getCareerCardPicked() == false) {
                    careerCards.get(i).setCareerCardPicked(true);
                    return careerCards.get(i);
                }
            }
        }
        return null;
    }

    public ArrayList<CareerCard> getCareerCards ()
    {
        return careerCards;
    }
}