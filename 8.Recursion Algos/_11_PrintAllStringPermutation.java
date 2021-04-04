import java.util.Arrays;

public class _11_PrintAllStringPermutation
{
	public static void main(String[] args)
	{
		String s = "BAC";
		char[] charArray = s.toCharArray();

		//Arrays.sort(charArray,0, charArray.length - 1);
		bubbleSort(charArray,0, charArray.length - 1);
		
		genAllStringPermutations(charArray, 0, charArray.length - 1);
	}

	//TC=O(N*N!) due to finding string combinations
	public static void genAllStringPermutations(char[] charArray, int cPos, int end)
	{
		//BASE CASE
		if (cPos == end)
		{
			System.out.println(Arrays.toString(charArray));
		}
		else
		{
			bubbleSort(charArray,cPos, end);
			//Arrays.sort(charArray,cPos, end);

			for (int i = cPos; i <= end; i++)
			{
				// do
				swap(charArray, cPos, i);
				// recurr permutation for next position
				genAllStringPermutations(charArray, cPos + 1, end);
				// undo
				swap(charArray, cPos, i);
			}
		}
	}

	//TC=O(N^2)
	//can use a mergesort to minimize TC
	public static void bubbleSort(char[] charArray, int cPos, int end)
	{
		for (int i = cPos; i <= end - 1; i++)
		{
			for (int j = i + 1; j <= end; j++)
			{
				// internally it does ASCI values
				if (charArray[i] > charArray[j])
				{
					swap(charArray, i, j);
				}
			}
		}
	}

	public static void swap(char[] charArray, int a, int b)
	{
		char temp = charArray[a];
		charArray[a] = charArray[b];
		charArray[b] = temp;
	}

}
