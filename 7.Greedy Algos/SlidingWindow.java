public class SlidingWindow
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5};
		slidingWindow(array,2);
	}
	
	public static void slidingWindow(int[] array, int windowSize)
	{
		System.out.println();
		int i,j;
		
		for(i=0;i<=array.length-windowSize;i++)
		{
			int windowStart = array[i];
			int windowEnd = array[array.length-windowSize];
			System.out.println("WindowStart:"+windowStart+",WindowEnd:"+windowEnd);
			
		}
	}
}
