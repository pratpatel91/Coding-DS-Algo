
public class _28_GasFeasability
{
	public static void main(String[] args)
	{
		int[] petrol =
		{ 4, 6, 7, 4 };
		int[] distToNextPump =
		{ 6, 5, 3, 5 };
		System.out.println(startingPumpToGetCircularTrip(petrol, distToNextPump));
	}

	public static int startingPumpToGetCircularTrip(int[] petrol, int[] distToNextPump)
	{
		int startingPump = 0;
		int petrolShortage = 0;
		int tankCapacity = 0;

		// Core Logic
		for (int i = 0; i <= petrol.length - 1; i++)
		{
			
			tankCapacity +=petrol[i];
			System.out.println("current tank capacity: " + tankCapacity);

			tankCapacity-=distToNextPump[i];
			System.out.println("current tank capacity is " + tankCapacity + " after traveling a distance of " +distToNextPump[i]);
			
			// cannot start at this pump if we dont have capacity
			if (tankCapacity < 0)
			{
				System.out.println("cant start from station:" + i);
				startingPump = i + 1;
				System.out.println("as station " + i + " isnt feasible; our new station is " + startingPump);
				petrolShortage += tankCapacity;
				System.out.println("petrol shortage: " + petrolShortage);
				tankCapacity = 0;
			}
		}

		// Displaying the Answer
		if (tankCapacity + petrolShortage >= 0)
		{
			System.out.println("Start from station:" + startingPump);
			return startingPump;
		} else
		{
			return -1;
		}
	}

}
