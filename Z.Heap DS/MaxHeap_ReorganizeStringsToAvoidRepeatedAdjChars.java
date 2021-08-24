import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap_ReorganizeStringsToAvoidRepeatedAdjChars
{

	public static void main(String[] args)
	{
		String s = "aabbccdddd";
		char[] charArrayForS1 = s.toCharArray();
		// worst_recursivelyGenPermutations(charArrayForS1, 0, s.length() - 1);
		best_isStringReorganizationValid(s);
	}

	// TC=O(N!*N) due to generating N! permutations which take O(N) time
	// SC=O(1) due to not using an extra data structures
	public static void worst_recursivelyGenPermutations(char[] charArray, int startIndex, int endIndex)
	{
		// System.out.println("----worst_recursivelyGenPermutations()----");
		// Computing the permutations is a N! process
		if (startIndex == endIndex)
		{
			// In order to get unique permutations (store it in a hashset meaning SC=O(N) )
			System.out.println("Recursively Permutated Char Array For S1: " + Arrays.toString(charArray));

			boolean isRearrangementValid = true;
			// for each permuted string w are checking to see if we have adj chars which is
			// a O(N) process
			for (int i = 0; i < charArray.length - 1; i++)
			{
				if (charArray[i] == charArray[i + 1])
				{
					isRearrangementValid = false;
				}
			}
			System.out.println("Is String Reorganization Possible? " + isRearrangementValid);
		}
		else
		{
			for (int i = startIndex; i <= endIndex; i++)
			{
				// Swapping the string by fixing a character
				swapChars(charArray, startIndex, i);
				// Recursively generate permutations for the rest of the characters
				worst_recursivelyGenPermutations(charArray, startIndex + 1, endIndex);
				// Backtracking and swapping the characters again.
				swapChars(charArray, startIndex, i);
			}
		}
	}

	public static void swapChars(char[] charArray, int fromIndex, int toIndex)
	{
		char temp = charArray[fromIndex];
		charArray[fromIndex] = charArray[toIndex];
		charArray[toIndex] = temp;
	}

	static class FreqComparator implements Comparator<PairADT>
	{
		public int compare(PairADT o1, PairADT o2)
		{
			// due to max heap we want descending sort
			if (o2.freq > o1.freq)
			{
				return 1; // descending order
			}
			if (o1.freq > o2.freq)
			{
				return -1; // ascending order
			}
			else
			{
				return 0; // no sorting
			}
		}
	}

	// sorting the freq data for the pair(char,freq)
	static class PairADT
	{
		char key;
		int freq;

		PairADT(char key, int freq)
		{
			this.key = key;
			this.freq = freq;
		}
	}

	// Tc=O(N*log N) because for N element we have to reheapify means log(N) time
	// SC=O(N) due to using an extra data structures/priority queue
	public static void best_isStringReorganizationValid(String s)
	{
		// priority queue to implement a heap
		// popping the root of the heap and tracking the popped char
		// so that the next popped character is not a repeating char
		PriorityQueue<PairADT> maxHeap = new PriorityQueue<>(new FreqComparator());

		int[] hashArrayForS1 = new int[26]; // a-z support only [0-25]

		for (int i = 0; i <= s.length() - 1; i++)
		{
			hashArrayForS1[s.charAt(i) - 'a']++;
		}

		String answer = "";
		boolean isRearrangementPossible = true;

		// insert from array into a heap
		for (int i = 0; i <= hashArrayForS1.length - 1; i++)
		{
			// adding from hasharray into max heap
			if (hashArrayForS1[i] > 0)
			{
				maxHeap.add(new PairADT((char) ((char) i + 'a'), hashArrayForS1[i]));
			}

			if (hashArrayForS1[i] > s.length() / 2)
			{
				System.out.println("Freq of char > string.length/2 so string permutation isnt possible");
				isRearrangementPossible = false;
				return;
			}

		}

		PairADT prevChar = new PairADT('@', -1);

		while (maxHeap.size() > 0)
		{
			PairADT maxElement = maxHeap.peek();
			maxHeap.poll(); // size --
			answer = answer + maxElement.key;
			// controlling removal of non repeating chars
			if (prevChar.freq > 0)
			{
				maxHeap.add(prevChar);
			}
			maxElement.freq--;
			System.out.println("max element:" + maxElement.key + ", prevChar:" + prevChar.key + ", answer:" + answer);
			prevChar = maxElement;

		}

		// print only if its a valid permutation of the original string
		if (answer.length() == s.length())
		{
			System.out.println("String Without Repeated Adj Chars: " + answer);
		}
		else
		{
			System.out.println("No String Permutation Without Repeated Adj Chars is possible");
		}

	}
}
