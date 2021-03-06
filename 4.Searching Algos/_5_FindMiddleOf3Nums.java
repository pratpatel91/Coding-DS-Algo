
public class _5_FindMiddleOf3Nums
{

	public static void main(String[] args)
	{
		int a = 5;
		int b= 2;
		int c = 1;
		System.out.println(minComparisons(a,b,c));
	}
	
	//6 Comparisons
	//a>b>c (2 comparisons)
	//b>a>c (2 comparisons)
	//a>c>b (2 comparisons)
	
	//Reduced from 6 to 3 comparisons
	public static int minComparisons(int a, int b, int c)
	{
		int isALargerThanB = a-b;
		int isBLargerThanC=b-c;
		int isALargerThanC=a-c;
		
		//a>b>c
		if(isALargerThanB *isBLargerThanC >0)
		{
			return b; //middle
		}
		//a>c>b
		else if(isALargerThanB*isALargerThanC>0)
		{
			return c;
		}
		else
		{
			return a;
		}
	}

}
