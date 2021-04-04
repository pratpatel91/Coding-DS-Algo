import java.util.Arrays;

public class _14_MaximizeSumOfAll_ai_i
{

	public static void main(String[] args)
	{
		int[] array = {999898,102458,653421,864532,567324,784516,386591,546137,875431,986534,777445};
		bruteforce_Sum(array);
	}
	
	public static void bruteforce_Sum(int[] array)
	{
		//sorting the array so that higher values of i are
		//multiplied with larger elements in order to maximize
		//the sum of a[i]*i
		Arrays.sort(array);
		int mod = 1000000007;
		
		//traverse the array and have an accumulating sum variable
		int accumulatingSum=0; //long is 8 bytes
		
		for(int i=0;i<=array.length-1;i++)
		{
			accumulatingSum=(accumulatingSum%mod+((array[i]%mod * i%mod)%mod))%mod;
		}
		System.out.println("Accumulating Sum:"+ accumulatingSum);
	}

}
