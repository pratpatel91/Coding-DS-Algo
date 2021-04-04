public class CrudeMaxHeap
{
	static class MaxHeap_ADT
	{
		private static int[] heapArray; // SC=O(N)
		private static int heapArraySize;

		// Constructor(used for creating the heap object)
		public MaxHeap_ADT(int size)
		{
			heapArray = new int[size - 1]; // due to using zero based index arrays
			heapArraySize = 0; // current no elements are in the heap
		}

		// ------------------------INSERTION--------------------------------------//
		public void insert(int value) // TC=O(log N)
		{
			// resizing the array
			if (heapArraySize == heapArray.length - 1)
			{
				arrayResizer(2 * heapArray.length);
			}
			heapArraySize++;
			heapArray[heapArraySize] = value;
			System.out.println("MaxHeap Array after inserting " + value);
			printMaxHeap();
			reheapifyAfterInsertion(heapArraySize);// TC=O(log N)
			System.out.println("Reheapified maxHeap Array inserting " + value);
			printMaxHeap();
		}

		private void reheapifyAfterInsertion(int k)
		{
			while (k > 1 && heapArray[k / 2] < heapArray[k])
			{
				int temp = heapArray[k];
				heapArray[k] = heapArray[k / 2];
				heapArray[k / 2] = temp;
				k = k / 2;
			}
		}

		// ------------------------DELETION--------------------------------------//
		
		
		
		
		// --------------HEPLER FUNCTIONS-------------------------------------------//
		public boolean isEmpty() // TC=O(1)
		{
			return (heapArraySize == 0);
		}

		public int size() // TC=O(1)
		{
			return (heapArraySize);
		}

		public int getParent(int index)
		{
			return (index / 2);
		}

		public int getLeftChild(int index)
		{
			return (index * 2);
		}

		public int getRightChild(int index)
		{
			return (2 * index + 1);
		}

		public void arrayResizer(int newArraySize)
		{
			int[] largerArray = new int[newArraySize];

			for (int i = 0; i <= heapArray.length - 1; i++)
			{
				largerArray[i] = heapArray[i];
			}
			heapArray = largerArray;
		}

		public void printMaxHeap() // TC=O(N)
		{
			for (int i = 1; i <= heapArray.length - 1; i++)
			{
				System.out.print(heapArray[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		MaxHeap_ADT maxHeap = new MaxHeap_ADT(3);
		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.insert(4);
	}
}
