import java.util.Arrays;
import java.util.Scanner;

public class _27_RearrangingAmplifiersForMaxSignal
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int arraySize = input.nextInt();
		int[] amplifiers = new int[arraySize];

		// 1^n=1 (keep amplifiers with 1 at the front)
		// n^1=n
		int onesCount = 0;

		int[] AmpfreqMoreThan1 = new int[arraySize]; // educated guess for size
		int j = 0;
		for (int i = 0; i <= amplifiers.length - 1; i++)
		{
			amplifiers[i] = input.nextInt();
			if (amplifiers[i] == 1)
			{
				onesCount++;
			}
			else
			{
				AmpfreqMoreThan1[j] = amplifiers[i];
				j++;
			}
		}

		while (onesCount > 0)
		{
			System.out.print("1");
			onesCount--;
		}

		Arrays.sort(AmpfreqMoreThan1);

		if (j == 2 && AmpfreqMoreThan1[0] == 2 && AmpfreqMoreThan1[1] == 3)
		{
			System.out.print("2 3");
		}
		else // to avoid duplicate printout
		{
			for (int i = AmpfreqMoreThan1.length - 1; i >= 0; i--)
			{
				System.out.print(AmpfreqMoreThan1[i] + " ");
			}
		}

	}

}
