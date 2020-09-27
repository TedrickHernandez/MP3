package sample;

public class HouseCard
{
    private int houseCardBuyValue;
    private int houseCardSellValue;
    private String houseCardName;
    private boolean houseCardPicked = false;

    public HouseCard (int insertHouseCardBuyValue, int insertHouseCardSellValue, String insertHouseCardName)
    {
        houseCardBuyValue = insertHouseCardBuyValue;
        houseCardSellValue = insertHouseCardSellValue;
        houseCardName = insertHouseCardName;
    }

    public void setHouseCardPicked (boolean insertHouseCardPicked)
    {
        houseCardPicked = insertHouseCardPicked;
    }

    public int getHouseCardBuyValue ()
    {
        return houseCardBuyValue;
    }

    public int getHouseCardSellValue ()
    {
        return houseCardSellValue;
    }

    public String getHouseCardName ()
    {
        return houseCardName;
    }

    public boolean getHouseCardPicked ()
    {
        return houseCardPicked;
    }
}