import java.util.Arrays;

public class _13_MaxSumAfterKSignSwaps
{

	public static void main(String[] args)
	{
		int[] array = {1,2,-3,4,5};
		int K=20;

		Arrays.sort(array);
		
		int operations=0;
		int arraySum=0;
		
		int i=0;
		//negation logic (handles negative elements only)
		for(i=0;i<=K;i++)
		{
			//handles index out of bound
			if(i==array.length)
			{
				break;
			}
			if(array[i]<0) //from -3,1,2,4,5 to 3,1,2,4,5
			{
				operations++;
				array[i]=array[i]*-1;
				K--; 
			}
			else //if(array[i]>0)
			{
				break;
			}
		}
		//negation logic (handles positive elements only)
		//changing the sign when K is odd
		if(K%2==1) //time complexity= O(1)
		{
			array[i]=array[i]*-1;
			operations++;
		}
		//-----------------ALTERNATIVE CODE-----------------//
		//i=1, K = 19
		/*
		while(K>0) //time complexity= O(1)
		{
			array[i]=array[i]*-1;
			operations++;
			K--;
		}
		*/
		
		//arraysum {3 -1 2 4 5 }
		for(i=0;i<=array.length-1;i++)
		{
			 arraySum+=array[i];
		}
		
		System.out.println("arraySum:"+arraySum);
		System.out.println("operations:"+operations);
	}
	
	

}
