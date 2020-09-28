package model;
import java.util.*;

public class SalaryCardDeck
{
    ArrayList<SalaryCard> salaryCards = new ArrayList<>();

    public void generateSalaryCardDeck ()
    {
        int randomValue1; // For the salary amount
        int randomValue2; // For the tax due amount
        int iterativeCtr;
        for (iterativeCtr = 0; iterativeCtr < 10; iterativeCtr ++)
        {
            randomValue1 = ((int) (Math.random() * (15 - 5 + 1) + 5)) * 10000;
            randomValue2 = ((int) (Math.random() * (15 - 5 + 1) + 5)) * 1000;
            salaryCards.add(new SalaryCard(randomValue1, randomValue2));
        }
    }

    public void shuffleSalaryCards ()
    {
        Collections.shuffle(salaryCards);
    }

    /* @TODO Create the same thing from CareerCardDeck */
    public SalaryCard pickTopSalaryCard ()
    {
        for (int i = 0; i < salaryCards.size(); i ++) {
            if (salaryCards.get(i).getSalaryCardPicked() == false)
            {
                salaryCards.get(i).setSalaryCardPicked(true);
                return salaryCards.get(i);
            }
        }
        return null;
    }
}