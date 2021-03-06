import java.util.*;

//Need a class because we dont have any data structure to store start and end
class Interval
{
	// global variables
	int start, end;

	// constructor
	// constructor creates an object so cant use static
	// constructor doesnt return anything so cant use void
	public Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
}

public class _16_MergingOverlapIntervals
{
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args)
	{
		// creating 5 pairs of start and end
		// this is an array of objects
		Interval[] array = new Interval[5];

		Scanner input = new Scanner(System.in);

		// populating the pairs based on user input
		for (int i = 0; i <= array.length - 1; i++)
		{
			int start = input.nextInt();
			int end = input.nextInt();
			array[i] = new Interval(start, end); //creating an array of objects
		}

		Arrays.sort(array, new Comparator<Interval>()//TC=O(nlogn)
		{
			public int compare(Interval I1, Interval I2)
			{
				// sorting on the basis of end I1.end - I2.end

				// sorting on the basis of start
				return (I1.start - I2.start);
			}
		}); // sorted array in order to do solve for overlapping

		// toString works on primitive data types only so we need
		// to implement a comparator in order to sort the interval objects
		printArray(array, array.length);
		
		optimized_mergeInterval(array);

	}
	//TC=O(n*nlogn)
	public static void optimized_mergeInterval(Interval[] array)
	{
		int prev=0; //previous interval
		
		for (int i = 1; i < array.length; i++)
		{
			//merging overlapping intervals
			if(array[prev].end> array[i].start )
			{
				array[prev].start=Math.min(array[prev].start, array[i].start);
				array[prev].end=Math.max(array[prev].end, array[i].end);
			}
			else //if the intervals are not overlapping
			{
				prev++;
				array[prev]=array[i];
			}
		}
		int totalCountOfMergedIntervals=prev+1;
		printArray(array, totalCountOfMergedIntervals);
	}

	public static void printArray(Interval[] array, int size)
	{
		System.out.println("");
		for (int i = 0; i <= size-1; i++)
		{
			System.out.println("{" + array[i].start + ", " + array[i].end + "}");
		}
	}

}
