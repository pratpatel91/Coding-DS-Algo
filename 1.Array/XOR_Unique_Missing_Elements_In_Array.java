
public class XOR_Unique_Missing_Elements_In_Array
{

	public static void main(String[] args)
	{
		int[] data = { 1, 2, 2, 3, 5, 6 };

		// Step3
		int xorArray = xorArray(data);
		// System.out.println("xorArray: " + xorArray);
		int xorFrom1ToN = xorFrom1ToN(data);
		// System.out.println("xorFrom1ToN: " + xorArray);
		int combinedXor = xorArray ^ xorFrom1ToN;
		int setbit = combinedXor & ~(combinedXor - 1);

		// Step4
		int x_missing = 0;
		int y_repetitive = 0;

		// Step5
		for (int i = 0; i < data.length; i++)
		{
			if ((setbit & data[i]) != 0)
			{
				x_missing = x_missing ^ data[i];
			} else
			{
				y_repetitive = y_repetitive ^ data[i];
			}
		}

		// Step6
		for (int i = 1; i <= data.length; i++)
		{
			if ((setbit & i) != 0)
			{
				x_missing = x_missing ^ i;
			} else
			{
				y_repetitive = y_repetitive ^ i;
			}
		}

		boolean answerFound = verifyMissing(data, x_missing);
		if (answerFound)
		{
			//Swap method
			int temp = x_missing;
			x_missing = y_repetitive;
			y_repetitive = temp;
		}

		// Step7
		System.out.println("Missing Elements: " + x_missing);
		System.out.println("Repeated Elements: " + y_repetitive);
	}

//	public static void swapValues(int x_missing, int y_repetitive)
//	{
//		int temp = x_missing;
//		x_missing = y_repetitive;
//		y_repetitive = temp;
//		System.out.println("x_missing: " + x_missing);
//		System.out.println("y_repetitive: " + y_repetitive);
//	}

	public static boolean verifyMissing(int[] data, int x_missing)
	{
		boolean answerFound = false;

		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == x_missing)
			{
				answerFound = true;
			}
		}
		return answerFound;
	}

	// Step1
	public static int xorArray(int[] data)
	{
		int xorArray = 0;

		for (int i = 0; i < data.length; i++)
		{
			xorArray = xorArray ^ data[i];
		}
		return xorArray;
	}

	// Step2
	public static int xorFrom1ToN(int[] data)
	{
		int N = data.length; // 3

		int xorFrom1ToN = 0;

		for (int i = 1; i <= N; i++) // i=0,1,2,3
		{
			xorFrom1ToN = xorFrom1ToN ^ i;
		}
		return xorFrom1ToN;
	}

}
