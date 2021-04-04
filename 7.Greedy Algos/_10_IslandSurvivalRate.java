public class _10_IslandSurvivalRate
{

	public static void main(String[] args)
	{
		int survivalDays = 7;
		int purchasePerDay = 2;
		int consumptionPerDay=3;
		
		
		if(consumptionPerDay > purchasePerDay)
		{
			System.out.println("You will starve to death");
		}
		else if(survivalDays>6 && (consumptionPerDay*7)>(purchasePerDay*6))
		{
			System.out.println("Consumption Per Day = Purchase Per Day & you'll run out on sunday");
		}
		else
		{
			int totalFoodNeededToSurvive=survivalDays * consumptionPerDay;
			int daysVisitedMarket=totalFoodNeededToSurvive/purchasePerDay;
			if(totalFoodNeededToSurvive%purchasePerDay != 0)
			{
				daysVisitedMarket++;
			}
			System.out.println("survived; visited the market:"+daysVisitedMarket);
		}
		

	}

}
