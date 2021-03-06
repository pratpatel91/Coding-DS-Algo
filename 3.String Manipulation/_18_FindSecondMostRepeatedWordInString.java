

import java.util.HashMap;
import java.util.Map;

public class _18_FindSecondMostRepeatedWordInString
{
	public static void main(String[] args)
	{
		String[] array = { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
		secondMostRepeatedWord(array);
	}

	public static void secondMostRepeatedWord(String[] array)
	{
		// Creating a hashmap
		HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();

		// Iterating through the word array in order to populate the hashmap
		for (int i = 0; i < array.length; i++)
		{
			// if the word already is new then add it into the hashmap
			if (!(wordFreq.containsKey(array[i])))
			{
				wordFreq.put(array[i], 1);
			}
			// if the word exists then increase the previous count by 1
			else if (wordFreq.containsKey(array[i]))
			{
				wordFreq.put(array[i], wordFreq.get(array[i]) + 1);
			}
		}
		// displaying the hashmap
		System.out.println("Hash Map:" + wordFreq);

		// iterating the hashmap to find the max freq and the second max freq
		int maxFreq = Integer.MIN_VALUE;
		int secondMaxFreq = Integer.MIN_VALUE;

		for (Map.Entry element : wordFreq.entrySet())
		{
			int currentFreq = (int) element.getValue();
			
			if (currentFreq > maxFreq)
			{   //swap values 
				secondMaxFreq = maxFreq;
				maxFreq = currentFreq;
				System.out.println("Max Freq:" + maxFreq);
			} else if (currentFreq > secondMaxFreq && currentFreq!=maxFreq)
			{
				secondMaxFreq = currentFreq;
				System.out.println("Second Max Freq:" + secondMaxFreq);
			}
		}

		
		// iterating the hashmap to find the max freq word and the second max freq word
		for (Map.Entry element : wordFreq.entrySet())
		{
			if(element.getValue().equals(maxFreq))
			{
				System.out.println("Max Freq Word:"+element.getKey());
			}
			if(element.getValue().equals(secondMaxFreq))
			{
				System.out.println("Second Max Freq Word:"+element.getKey());
			}
		}
		
	}

}
