
public class _15_RomanNumeral_Into_Decimal
{

	public static void main(String[] args)
	{
		String romanNumerals = "XIXIXIXIX";
		System.out.println(romanNumeralIntoInt(romanNumerals));
	}

	public static int value(char symbol)
	{
		if (symbol == 'I')
		{
			return 1;
		}
		if (symbol == 'V')
		{
			return 5;
		}
		if (symbol == 'X')
		{
			return 10;
		}
		if (symbol == 'L')
		{
			return 50;
		}
		if (symbol == 'C')
		{
			return 100;
		}
		if (symbol == 'D')
		{
			return 500;
		}
		if (symbol == 'M')
		{
			return 1000;
		}
		return -1; //roman char not found
	}

	// TC=O(n) SC=O(1)
	public static int romanNumeralIntoInt(String string)
	{
		int accumulatingSum=0;
		
		
		for (int i = 0; i <= string.length()-1; i++)
		{
			int currentValue= value(string.charAt(i));
			
			if(i+1<string.length()) //checks till the 2nd last index
			{
				int nextValue = value(string.charAt(i+1));
				if (currentValue ==nextValue) //handling XX case
				{
					accumulatingSum+=currentValue;
				}
				else if(currentValue < nextValue) //handling IX case
				{
					accumulatingSum+=(nextValue-currentValue);
				}
			}
			else //when i is at the last index
			{
				accumulatingSum+=currentValue;
			}

			System.out.println("i:"+i+", accumulatingSum:"+accumulatingSum);
			
		}
		return accumulatingSum ;

	}

}
