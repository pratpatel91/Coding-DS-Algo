public class _8_SearchingInArrayWhereAdjElementsDifferByAtMostK
{

	public static void main(String[] args)
	{
		int[] array = { 4, 5, 6, 7, 6 };
		int k = 1;
		int x = 6;
		System.out.println(searchArrayUsingKSteps(array, x, k));
	}

	public static int searchArrayUsingKSteps(int[] array, int x, int k)
	{
		int i = 0;

		System.out.print("Searching i: ");

		while (i < array.length)
		{
			System.out.print(i + " ");
			if (x == array[i])
			{
				System.out.println("\nTarget exists at i= "+i);
				return i;
			}
			//optimization
			int steps = Math.abs(array[i] - x) / k;
			i = i + steps; //updated i to search the array
		}

		return -1;// x is not found in the array
	}

}
