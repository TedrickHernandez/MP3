package sample;

public class CareerCard
{
    private int careerCardPayRaiseLimit;
    private String careerCardName;
    private boolean careerCardDegreeRequired;
    private boolean careerCardPicked = false;

    public CareerCard (int insertCareerCardPayRaiseLimit, String insertCareerCardName, boolean insertCareerCardDegreeRequired)
    {
        careerCardPayRaiseLimit = insertCareerCardPayRaiseLimit;
        careerCardName = insertCareerCardName;
        careerCardDegreeRequired = insertCareerCardDegreeRequired;
    }

    public void setCareerCardPicked (boolean insertCareerCardPicked)
    {
        careerCardPicked = insertCareerCardPicked;
    }

    public int getCareerCardPayRaiseLimit ()
    {
        return careerCardPayRaiseLimit;
    }

    public String getCareerCardName ()
    {
        return careerCardName;
    }

    public boolean getCareerCardDegreeRequired ()
    {
        return careerCardDegreeRequired;
    }

    public boolean getCareerCardPicked ()
    {
        return careerCardPicked;
    }
}