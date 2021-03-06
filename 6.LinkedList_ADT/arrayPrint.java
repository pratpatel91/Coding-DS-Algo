
public class arrayPrint
{

	public static void main(String[] args)
	{
		int[] array = {1,2};
		printArray(array);

	}

	public static void printArray(int[] array)
	{
		int i=0;
		int size=0;
		
		while (i<=array.length-1)
		{
			System.out.println(array[i] + " ");
			i++;
			size++;
		}
		System.out.println(size);
	}
}
