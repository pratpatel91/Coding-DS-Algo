public class Recursion_FactorialOfN
{
	public static void main(String[] args)
	{
		int N = 4;
		System.out.println(factorialOfN(N));
	}

	public static int factorialOfN(int N)
	{
		if (N == 1)
		{
			return  1;
		}
		return N * factorialOfN(N - 1);
	}
		//Alternate Lengthy Code
		/*
		 int sum = 0;
		 
		 if (N == 1)
		{
			sum = 1;
		}
		else if (N > 1)
		{
			sum = N * factorialOfN(N - 1);
		}
		return sum;
		*/
}