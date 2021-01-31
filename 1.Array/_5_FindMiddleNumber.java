
public class _5_FindMiddleNumber
{
	public static void main(String[] args)
	{
		System.out.println(findMiddleNumber(4,3,1));
	}

	public static int findMiddleNumber(int a, int b, int c)
	{
		if (a > b)
		{
			if (b > c) //a>b>c
			{
				return b;
			} else if (c > a) //c>a>b
			{
				return a;
			} else //a>c>b
			{
				return c;
			}
		} else
		{
			if (b < c) //a<b<c
			{
				return b;
			} else if (c < a) //c<a>b
			{
				return a;
			} else          //b>c>a
			{
				return c;
			}
		}
	}

}
