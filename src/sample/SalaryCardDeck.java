package sample;
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
}