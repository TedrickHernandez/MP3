package model;

public class SalaryCard
{
    private int salaryCardValue;
    private int salaryCardTaxDue;
    private boolean salaryCardPicked = false;

    public SalaryCard (int insertSalaryCardValue, int insertSalaryCardTaxDue)
    {
        salaryCardValue = insertSalaryCardValue;
        salaryCardTaxDue = insertSalaryCardTaxDue;
    }

    public void setSalaryCardPicked (boolean insertPicked)
    {
        salaryCardPicked = insertPicked;
    }

    public int getSalaryCardValue ()
    {
        return salaryCardValue;
    }

    public int getSalaryCardTaxDue ()
    {
        return salaryCardTaxDue;
    }

    public boolean getSalaryCardPicked ()
    {
        return salaryCardPicked;
    }
}