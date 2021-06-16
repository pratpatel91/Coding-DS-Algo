
public class Recursion_CountDown
{
	static int staticN =3;
	
	public static void main(String[] args)
	{
		interativeCountDown();
		recursiveCountDown(3);
	}
	
	public static void interativeCountDown()
	{
		for(int i=staticN; i>=1;i--)
		{
			System.out.println(i);
		}
		System.out.println(); //creates spacing
	}
	
	public static void recursiveCountDown(int dynamicN)
	{
		//base case (simplest computation)
		if(dynamicN==1)
		{
			System.out.println(dynamicN);
			return;
		}
		
		//reoccuring subproblem
		System.out.println(dynamicN);
		recursiveCountDown(dynamicN-1);
	}
}
