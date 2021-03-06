import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap
{
	public static void main(String[] args)
	{
		int[] array = { 4, 7, 2, 9, 13, 6, 3 };
		int targetSum = 9;
		HashMap<Integer, Integer> hashMap_ChoicesForB = genHashMap(array);
		printHashMap(hashMap_ChoicesForB);
		hashMap_TwoSum(targetSum, array, hashMap_ChoicesForB);
	}

	public static void hashMap_TwoSum(int targetSum, int[] array, Map<Integer, Integer> hashMap)
	{
		// we know that a+b =sum this means if we know a and the sum then we can
		// calculate b = sum-a

		// Using a for loop to search for element a takes O(n)
		for (int i = 0; i <= array.length - 1; i++)
		{
			int currentA = array[i];
			int constrainedB = targetSum - currentA;
			// Using a hashmap to search for element b takes O(1) time complexity
			int finalB = hashMapToFindElementB(constrainedB, hashMap);
			
			if(isPairSumValid(currentA, finalB, targetSum) == true)
			{
				System.out.println("PairSum:{" + currentA + ", " + finalB + "}= " + targetSum);
				break;// strategically displaying the first pair sum found only
			}
		}
	}

	public static boolean isPairSumValid(int currentA, int finalB, int targetSum)
	{
		boolean isPairSumValid = false;
		
		if (currentA + finalB == targetSum)
		{
			isPairSumValid=true;

		} else
		{
			isPairSumValid=false;
		}
		return isPairSumValid;
	}

	public static int hashMapToFindElementB(int b, Map<Integer, Integer> hashMap)
	{
		int chosenB = 0;

		for (Integer element : hashMap.keySet())
		{
			int key = element;

			if (key == b)
			{
				chosenB = key;
			}
		}
		return chosenB;
	}

	public static HashMap<Integer, Integer> genHashMap(int[] array)
	{
		HashMap<Integer, Integer> BList = new HashMap<Integer, Integer>();

		for (int i = 0; i <= array.length - 1; i++)
		{
			BList.put(array[i], i);// key is arrays element, value is the arrays index
		}
		return BList;

	}

	public static void printHashMap(Map<Integer, Integer> hashMap)
	{
		for (Integer element : hashMap.keySet())
		{
			int key = element; // key is arrays element
			int value = hashMap.get(element); // value is the arrays index
			System.out.println("{" + key + ", " + value + "}");
		}
	}

}
