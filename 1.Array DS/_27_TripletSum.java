
public class _27_TripletSum
{

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// bruteForceTripletSum(array, 85);
		optimizedTripletSum(array, 10);
	}

	public static void optimizedTripletSum(int[] array, int X)
	{
		boolean isTripletPresent = false;

		// -------------------Hashing----------------------------------//
		// 10^6 is random but larger than array[max]=9
		int[] hashArray = new int[1000000];

		// for loop to do the hashing
		for (int i = 0; i <= array.length - 1; i++)
		{
			hashArray[array[i]]++;
		}

		// a+b+c=x
		// 1st we pick a
		// 2nd we have a for loop to iterate b & also to iterate c

		for (int i = 0; i <= array.length - 1; i++)
		{
			int a = array[i];
			// we need 3 variables such that a+b+c=X
			//targetSum=b+c=X-a(knowns)
			int targetSum = X - a; 

			// now the problem is reduced to a+b=c
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				int b = array[j];
				int c = targetSum - b; //targetSum=b+c

				if (hashArray[c] >= 1)
				{
					isTripletPresent = true;
					break;// reports 1 instance only
				}
			}

			if (isTripletPresent == true)
			{
				break;
			}
		}

		// Displays the output at the end
		if (isTripletPresent == true)
		{
			System.out.println("yes");
		} else
		{
			System.out.println("no");
		}

	}

	public static void bruteForceTripletSum(int[] array, int X)
	{
		// a+b+c=x
		// 1st we pick a
		// 2nd we have a for loop to iterate b & also to iterate c

		// picking a
		boolean isTripletPresent = false;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int a = array[i];

			// iterates over b for a selected a value
			for (int j = i + 1; j <= array.length - 1; j++)
			{
				int b = array[j];

				// iterates over c for selected a,c values
				for (int k = j + 1; k <= array.length - 1; k++)
				{
					int c = array[k];

					if (a + b + c == X)
					{
						isTripletPresent = true;
						System.out.println("yes the triplet sum is present");
						break;//
					}
				}

				// breaks the middle for loop (creative use of booleans)
				if (isTripletPresent == true)
				{
					break;
				}
			}

			// breaks the outer for loop (creative use of booleans)
			if (isTripletPresent == true)
			{
				break;
			}
		}

		// displays once is because when the flow breaks out of the for loop
		// then the if statement is the only control flow structure
		// that dictates the single display

		// if the sum isnt found (creative use of booleans)
		if (isTripletPresent == false)
		{
			System.out.println("no the triplet sum isnt present");
		}
	}
}
