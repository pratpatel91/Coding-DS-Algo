import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays
{

	public static void main(String[] args)
	{
		int[][] kSortedArrays = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		MergeSort_kSortedArrays(kSortedArrays);

		int[] sortedArray = new int[kSortedArrays.length * kSortedArrays[0].length];
		int size = kSortedArrays.length;
		System.out.println("Size:" + size);
		better_MergeSortedKArrays(kSortedArrays, 0, size - 1, sortedArray);
		best_MergeSortedKArrays(kSortedArrays);
	}
	
	
	//BruteForce
	//Sorting on an unsorted array(size NK) using bubble sort
	// TC=N^2K^2


	//MergeSort
	// Dump the k arrays into a single array and then sort the single array
	// TC=O(NK*log (NK)) because we are sorting an array that is sized NK
	// SC=O(NK) due to storing an array that is sized NK
	public static void MergeSort_kSortedArrays(int[][] kSortedArrays)
	{
		int[] singleArray = new int[kSortedArrays.length * kSortedArrays[0].length];

		int index = 0;

		// traversing the matrix to sort the matrix into an array
		for (int i = 0; i <= kSortedArrays.length - 1; i++)
		{
			for (int j = 0; j <= kSortedArrays[i].length - 1; j++)
			{
				singleArray[index++] = kSortedArrays[i][j];
			}
		}

		Arrays.sort(singleArray); // Built in Sorting Algorithm takes TC=NK*log (NK)

		// print the array
		for (int i = 0; i <= singleArray.length - 1; i++)
		{
			System.out.print(singleArray[i] + " ");
		}

	}

	// TC=O(NK * log(K)) .... log(K) due to the arrays being sorted
	// .... log(NK) due to the arrays being unsorted
	// SC=O(NK) due to storing an array that is sized NK
	public static void better_MergeSortedKArrays(int[][] kSortedArrays, int first, int last, int[] sortedArray)
	{
		int N = kSortedArrays[0].length; // rows

		// single array is sorted
		if (first == last)
		{
			for (int i = 0; i <= kSortedArrays[0].length - 1; i++)
			{
				sortedArray[i] = kSortedArrays[first][i];
			}
			return;
		}

		// merging adjacent arrays
		if (last - first == 1)
		{
			mergeArrays(kSortedArrays[first], kSortedArrays[last], sortedArray);
			return;
		}

		int mid = (first + last) / 2; // avoids int overflow

		int[] leftArray = new int[N * (mid - first + 1)];
		int[] rightArray = new int[N * (last - mid)];
		System.out.println("mid:" + mid + ", first:" + first + ",last:" + last);
		System.out.println("Num of Arrays: " + N);
		System.out.println("Left Array Size: " + leftArray.length);
		System.out.println("Right Array Size: " + rightArray.length);
		better_MergeSortedKArrays(kSortedArrays, first, mid, leftArray);
		better_MergeSortedKArrays(kSortedArrays, mid + 1, last, rightArray);
		mergeArrays(leftArray, rightArray, sortedArray);

		// print the array
		for (int i = 0; i <= sortedArray.length - 1; i++)
		{
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
	}

	public static void mergeArrays(int[] array1, int[] array2, int[] sortedArray)
	{
		int size1 = array1.length;
		int size2 = array2.length;

		int i = 0, j = 0, k = 0;

		while (i < size1 && j < size2)
		{
			if (array1[i] < array2[j])
			{
				sortedArray[k++] = array1[i++];
			}
			else
			{
				sortedArray[k++] = array2[j++];
			}
		}

		while (i < size1)
		{
			sortedArray[k++] = array1[i++];
		}

		while (j < size2)
		{
			sortedArray[k++] = array2[j++];
		}

	}

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
		public int compareTo(MergeKSortedArrays.PairADT pair)
		{
			// when i create a new object for the first time that is stored in this.element
			// when you push a pair on the heap its stored in pair.element
			return this.element - pair.element; //we want element at the top of the min heap
			//pair.element-this.element does maxHeap
		}
	}

	// TC=O(NK * log(K)) .... log(K) due to the arrays being sorted
	// .... log(NK) due to the arrays being unsorted
	// SC=O(K) due to storing an array that is sized K
	public static void best_MergeSortedKArrays(int[][] kSortedArrays)
	{
		// creating priority queue ot pairadt data type
		PriorityQueue<PairADT> minHeapAPI = new PriorityQueue<>();

		// storing all the pairs back into an array/ adding another O(K) space
		int[] storedPairs = new int[kSortedArrays.length * kSortedArrays[0].length];
		int index = 0;

		for (int row = 0; row <= kSortedArrays.length - 1; row++)
		{
			PairADT pair = new PairADT(kSortedArrays[row][0], 0, row);
			minHeapAPI.add(pair);
			System.out.println("first element of row" + row + " is " + kSortedArrays[row][0]);
		}

		while (minHeapAPI.size() > 0)
		{
			PairADT pair = minHeapAPI.remove();
			storedPairs[index++] = pair.element; // extra datastructure for visualization
			System.out.println("pair.element is min element" + pair.element + " ");
			pair.indice++; // iterator

			if (pair.indice < kSortedArrays[pair.rowNum].length)
			{
				pair.element = kSortedArrays[pair.rowNum][pair.indice];
				minHeapAPI.add(pair);
				System.out.println("element of row" + pair.rowNum + " is " + kSortedArrays[pair.rowNum][pair.indice]);
			}
		}

		// print the array
		for (int i = 0; i <= storedPairs.length - 1; i++)
		{
			System.out.print(storedPairs[i] + " ");
		}
	}

}
