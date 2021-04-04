public class _11_MaxProdSubsetOfAnArray
{
	public static void main(String[] args)
	{
		int[] array = {0,0,0};
		int zeroCount = getZeroCount(array);
		
		if(zeroCount == array.length)
		{
			System.out.println("MaxProd:0");
			System.out.println("returning from main");
			return; //breaks out of the main (prevents code below from running)
		}
		
		int negCount = 0;
		int maxNegElement = Integer.MIN_VALUE;
		int maxProd= 1; //accumulator prod
				
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] != 0)
			{
				if (array[i] < 0)
				{
					if (array[i] > maxNegElement)
					{
						maxNegElement = array[i];
					}
					negCount++;
				}
				maxProd=maxProd*array[i];
			}
		}
		
		if (negCount %2 ==1)
		{
			if(negCount ==1 && (negCount+zeroCount==array.length))
			{
				System.out.println("MaxProd:0");
			}
			else
			{
				maxProd=maxProd/maxNegElement;
				System.out.println("MaxProd:"+maxProd);
			}
		}
		else
		{
			System.out.println("MaxProd:"+maxProd);
		}
		System.out.println(" executed all lines");
	}

	public static int getZeroCount(int[] array)
	{
		int zeroCount = 0;

		for (int i = 0; i <= array.length - 1; i++)
		{
			if (array[i] == 0)
			{
				zeroCount++;
			}
		}
		return zeroCount;
	}

}
