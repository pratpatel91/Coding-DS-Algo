
public class _20_MinTimeToCookParatha
{

	public static void main(String[] args)
	{
		int parathaOrdered = 100;
		int numChefs = 1;
		int[] chefRatings = { 1 };
		System.out.println(minTimeToPrepareOrder(parathaOrdered, numChefs, chefRatings));
	}

	public static int minTimeToPrepareOrder(int parathaOrdered, int numChefs, int[] chefRatings)
	{
		int minTime = 0;
		int low = 1;// A Rank1 Chef is able to complete 1 paratha in 1 min
		int high = 10000; // if high < currentChefTime then we get 0

		// logic for the binary search
		while (low <= high)
		{
			int time_t = (high + low) / 2;

			//System.out.println("Given time:" + time_t);

			if (canWeCookInTime_T(time_t, parathaOrdered, numChefs, chefRatings))
			{
				minTime = time_t;
				high = time_t - 1;
			} else
			{
				low = time_t + 1;
			}
		}
		return minTime;
	}

	public static boolean canWeCookInTime_T(int time_t, int parathaOrdered, int numChefs, int[] chefRatings)
	{
		int parathaCooked = 0;

		for (int i = 0; i <= numChefs - 1; i++)
		{
			int round = 2;

			int currentChefTime = chefRatings[i];

			while (currentChefTime <= time_t)
			{
				parathaCooked++;
				//System.out.println("chef name:" + (i + 1) + ", current time:" + currentChefTime + ", parathas cooked:"
						//+ parathaCooked);
				currentChefTime += (chefRatings[i] * round); // 1,3,6 series storing time to cook parathas
				round++; // 2,3,4,5
			}
		}
		//System.out.println("Num of chefs:" + numChefs + ", time given:" + time_t + ", parathascooked:" + parathaCooked);

		if (parathaCooked >= parathaOrdered)
		{
			return true;
		} else
		{
			return false;
		}
	}
}
