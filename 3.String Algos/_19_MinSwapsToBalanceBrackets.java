
public class _19_MinSwapsToBalanceBrackets
{

	public static void main(String[] args)
	{
		String brackets = "]]]][[[[";
		System.out.println(minSwapsToBalanceBrackets(brackets));
	}

	public static int minSwapsToBalanceBrackets(String brackets)
	{
		int OB = 0;
		int CB = 0;
		int unbalanced = 0;
		int minSwaps = 0;

		// iterate the string
		for (int i = 0; i <= brackets.length() - 1; i++)
		{
			if (brackets.charAt(i) == '[')
			{
				OB++;
				if (unbalanced > 0)
				{
					System.out.println("OB:" + (OB - 1) + ", CB:" + CB + ", unbalanced:" + unbalanced);
					minSwaps += unbalanced;
					unbalanced--;
					System.out.println(
							"OB:" + OB + ", CB:" + CB + ", unbalanced:" + unbalanced + ", minSwaps:" + minSwaps);
				}
			} else
			{
				CB++;
				unbalanced = CB - OB;
				System.out.println("OB:" + OB + ", CB:" + CB + ", unbalanced:" + unbalanced);
			}

		}

		return minSwaps;
	}
}
