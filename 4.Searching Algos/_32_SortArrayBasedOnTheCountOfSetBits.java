import java.util.*;

class Pair
{
	// the pair is defined by a key and a value
	// combining num and setBit
	int num = 0;
	int setBit = 0;

	// constructor initializes variables during object creation
	// but never returns anything
	public Pair(int num, int setBit)
	{
		this.num = num;
		this.setBit = setBit;
	}
}
//-----------------------------HW is to refactor this part
// and figure out how the API for comparator works--------//
class Compare
{
	//Overriding the Comparator Classes compare method
	//which compares on the basis of setBits
	public static void compare(Pair pairArray_ADT[], int n)
	{
		Arrays.sort(pairArray_ADT, new Comparator<Pair>()
		{
			@Override 
			public int compare(Pair P1, Pair P2)
			{
				return (P2.setBit - P1.setBit);
			}
		});

		for (int i = 0; i < pairArray_ADT.length - 1; i++)
		{
			// is pair is an object by itself
			System.out.println("value:" + pairArray_ADT[i].num + ", setBit:" + pairArray_ADT[i].setBit);
		}
	}
}

public class _32_SortArrayBasedOnTheCountOfSetBits
{
	public static void main(String[] args)
	{
		int[] nums = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		int[] setBitArray =genSetBitArray(nums);
		
		Pair[] pairsArray_ADT=genPairArray(nums,setBitArray);
		sortingSetBitsArrayPerComparator(pairsArray_ADT);
		
	}

	public static int setBit(int num)
	{
		// int binary[] = new int[5];
		// int length = 0;

		int setBitCount = 0;

		// populating the binary array based on dividing
		// the int by 2
		while (num > 0)
		{
			if (num % 2 == 1)
			{
				setBitCount++;
			}
			// ----------Finding binary of an int -------//
//			binary[length] = num % 2;
//			
//			length++;
			num = num / 2;
//			printArray(binary);
		}
//
//		System.out.println("\ndisplaying the binary array");
//		for (int i = length-1; i >= 0; i--)
//		{
//			System.out.print(binary[i] + "");
//		}
		return setBitCount;
	}

	public static void sortingSetBitsArrayPerComparator(Pair[] pairArray_ADT)
	{
		//need a comparator because if we have same values for setbits
		//then we want to preserve the order of the element in the array
		Compare comparator = new Compare();
		comparator.compare(pairArray_ADT,pairArray_ADT.length);
		
	}

	public static Pair[] genPairArray(int[] array, int[] setBitArray)
	{
		// creating a pair array of pair data type
		Pair pairArray_ADT[] = new Pair[array.length];

		for (int i = 0; i <= array.length - 1; i++)
		{
			pairArray_ADT[i] = new Pair(array[i], setBitArray[i]);
		}
		return pairArray_ADT;

	}

	public static int[] genSetBitArray(int[] array)
	{
		int[] setBitArray = new int[array.length];

		for (int i = 0; i <= array.length - 1; i++)
		{
			int currentElement = array[i];
			int currentElementsSetBit = setBit(currentElement);
			setBitArray[i] = currentElementsSetBit;
			System.out.println("\nelement:" + array[i] + ", set bit:" + currentElementsSetBit);
		}
		return setBitArray;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i <= array.length - 1; i++)
		{
			System.out.print(array[i] + "");
		}
		System.out.println("");
	}
}
