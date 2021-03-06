public class _24_SmallestWindowContainingMatchingChars
{

	public static void main(String[] args)
	{
		String S = "timetopractice";
		String P = "toc";
		smallestWindowContainingSameChars(S, P);
	}

	public static void smallestWindowContainingSameChars(String S, String P)
	{
		int start = 0;
		int sliding_start = 0;
		int smallestWindow = S.length();
		int sp_CharMatch = 0;

		int[] hash_P = new int[10000]; // 10000 >>256 is specified to avoid index out of bound errors

		// hashing the pattern
		for (int i = 0; i <= P.length() - 1; i++)
		{
			hash_P[P.charAt(i)]++;
		}

		// print array
		for (int i = 0; i <= hash_P.length - 1; i++)
		{
			if (hash_P[i] > 0)
			{
				System.out.print(hash_P[i] + " ");
			}
		}
		System.out.println("");
		
		int[] hash_S = new int[100000]; // 10000 >>256 is specified to avoid index out of bound errors

		// hashing the string
		for (int i = 0; i <= S.length() - 1; i++)
		{
			hash_S[S.charAt(i)]++;
			System.out.println("\nCurrent char:" + S.charAt(i));
			System.out.println("string pattern freq: " + hash_S[S.charAt(i)]);
			if (hash_P[S.charAt(i)] != 0 && hash_S[S.charAt(i)] <= hash_P[S.charAt(i)])
			{
				sp_CharMatch++;
			}

			// updating the start of the window
			if (sp_CharMatch == P.length())
			{
				while (hash_S[S.charAt(start)] > hash_P[S.charAt(start)] || hash_P[S.charAt(start)] == 0)
				{
					System.out.println("hash pattern freq:" + hash_P[S.charAt(start)] + ", string pattern freq: "
							+ hash_S[S.charAt(start)]);
					//
					if(hash_S[S.charAt(start)]>hash_P[S.charAt(start)])
					{
						hash_S[S.charAt(start)]--;
					}
					
					System.out.println("hash pattern freq:" + hash_P[S.charAt(start)] + ", string pattern freq: "
							+ hash_S[S.charAt(start)]);
					start++;
				}
				int window = i - start + 1;
				System.out.println("start: " + start + ", end: " + i + ", window: " + window);
				System.out.println("current smallest window: " + smallestWindow);

				if (smallestWindow > window)
				{
					smallestWindow = window;
					sliding_start = start;
				}
				System.out.println("--------Intermediate Result------------");
				for (int j = sliding_start; j <= i; j++)
				{
					System.out.print(S.charAt(j));
				}
			}

		}
		System.out.println("\n--------Final Answer------------");
		for (int i = sliding_start; i <= sliding_start+smallestWindow-1; i++)
		{
			System.out.print(S.charAt(i));
		}

	}

}
