import java.util.PriorityQueue;

public class SmallestRangeInKLists
{

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		bruteForce_SmallestRange(matrix);
		best_smallestRange(matrix);
	}

	// KPointersMinAndMaxComparisons
	// TC=O(N*Klists*klists)
	// SC=O(Klists)
	public static void bruteForce_SmallestRange(int[][] matrix)
	{
		int k = matrix.length;
		int[] kPointers = new int[k + 1];
		int N = matrix[0].length; // cols
		int range = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE; // intermitten variables
		int max = Integer.MIN_VALUE; // intermitten variables

		int minIndex = 0;
		boolean isEndOfRow;

		// setting kPointers Array to zero
		for (int i = 0; i <= k; i++)
		{
			kPointers[i] = 0;
		}

		while (true)
		{
			isEndOfRow = false;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			for (int i = 0; i < k; i++)
			{
				if (kPointers[i] == N)
				{
					isEndOfRow = true;
					break;
				}
				if (kPointers[i] < N && matrix[i][kPointers[i]] < min)
				{
					min = matrix[i][kPointers[i]];
					minIndex = i;
				}
				if (kPointers[i] < N && matrix[i][kPointers[i]] > max)
				{
					max = matrix[i][kPointers[i]];
				}
			}

			if (isEndOfRow == true)
			{
				break;
			}
			// increasing minIndexPointer for the array containing the min element
			kPointers[minIndex]++;

			if (range > (max - min))
			{
				range = max - min;
				start = min;
				end = max;
			}
			System.out.print("\nSmallest Range:" + start + "-" + end + "\n");
		}
	}

	// heap solution

	// constructor was called in a static function
	// so the class was made to be static
	// Min Heap works on int by default (due to using abstract data type we get
	// Comparable Exception Error)
	public static class PairADT implements Comparable<PairADT>
	{
		int element;
		int rowNum;
		int indice; // row index

		PairADT(int element, int indice, int rowNum)
		{
			this.element = element;
			this.indice = indice;
			this.rowNum = rowNum;
		}

		@Override
		public int compareTo(SmallestRangeInKLists.PairADT pair)
		{
			// when i create a new object for the first time that is stored in this.element
			// when you push a pair on the heap its stored in pair.element
			return this.element - pair.element; // we want element at the top of the min heap
			// pair.element-this.element does maxHeap
		}
	}

	// TC=O(NK * log(K)) .... log(K) due to the arrays being sorted
	// .... log(NK) due to the arrays being unsorted
	// SC=O(K) due to storing an array that is sized K
	public static void best_smallestRange(int[][] kSortedArrays)
	{
		int range = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE; // intermitten variables
		int max = Integer.MIN_VALUE; // intermitten variable

		// creating priority queue ot pairadt data type
		PriorityQueue<PairADT> minHeapAPI = new PriorityQueue<>();

		// storing all the pairs back into an array/ adding another O(K) space
		// int[] storedPairs = new int[kSortedArrays.length * kSortedArrays[0].length];
		int index = 0;

		for (int row = 0; row <= kSortedArrays.length - 1; row++)
		{
			PairADT pair = new PairADT(kSortedArrays[row][0], 0, row);
			minHeapAPI.add(pair);
			//System.out.println("first element of row" + row + " is " + kSortedArrays[row][0]);
			if (kSortedArrays[row][0] > max)
			{
				max = kSortedArrays[row][0]; // 9
			}
			if (kSortedArrays[row][0] < min)
			{
				min = kSortedArrays[row][0]; // 1
			}
		}
		
		while (minHeapAPI.size() > 0)
		{
			PairADT pair = minHeapAPI.peek();
			minHeapAPI.poll();
			min = pair.element; // 2
			System.out.println("Min:"+pair.element + " currentTop:"+minHeapAPI.peek().element);
			
			// update range
			if (range > (max - min))
			{
				range = max - min;
				start = min;
				end = max;
			}
			System.out.println("Smallest Range:" + start + "-" + end);
			// storedPairs[index++] = pair.element; // extra datastructure for visualization
			// System.out.println("pair.element is min element" + pair.element + " ");
			pair.indice++; // iterator
			
			if (pair.indice < kSortedArrays[pair.rowNum].length)
			{
				pair.element=kSortedArrays[pair.rowNum][pair.indice]; //updating the pairs element
				
				// pair.element = kSortedArrays[pair.rowNum][pair.indice];
				System.out.println("element of row" + pair.rowNum + " is " + kSortedArrays[pair.rowNum][pair.indice] + " indice:"+pair.indice);
				
				minHeapAPI.add(pair);
				//System.out.println("element of row" + pair.rowNum + " is " + kSortedArrays[pair.rowNum][pair.indice]);
				if (pair.element > max)
				{
					max = pair.element;
				}
			}
			else
			{
				break;
			}
		}
	}
}
