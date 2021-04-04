public class MaxHeap
{
	static class MaxHeap_ADT
	{
		private int[] heapArray;
		private int heapArraySize;

		public MaxHeap_ADT(int capacity)
		{
			heapArraySize = 0;
			heapArray = new int[capacity + 1]; // due to 1 based indexing
			heapArray[0] = Integer.MAX_VALUE; // 1st element is not used for storing heap elements
		}

		private int getParent(int i)
		{
			return i / 2;
		}

		private int getLeftChild(int i)
		{
			return (2 * i); // due to 1 based indexing
		}

		private int getRightChild(int i)
		{
			return (2 * i) + 1; // due to 1 based indexing
		}

		private void swapNodesToRetainHeapProperty(int fpos, int spos)
		{
			int tmp;
			tmp = heapArray[fpos];
			heapArray[fpos] = heapArray[spos];
			heapArray[spos] = tmp;
		}

		private void heapifyDown(int i)
		{
			if (i >= (heapArraySize / 2) && i <= heapArraySize)
			{
				return;
			}

			if (heapArray[i] < heapArray[getLeftChild(i)] || heapArray[i] < heapArray[getRightChild(i)])
			{

				if (heapArray[getLeftChild(i)] > heapArray[getRightChild(i)])
				{
					swapNodesToRetainHeapProperty(i, getLeftChild(i));
					heapifyDown(getLeftChild(i));
				}
				else
				{
					swapNodesToRetainHeapProperty(i, getRightChild(i));
					heapifyDown(getRightChild(i));
				}
			}
		}

		public void heapifyUp(int i)
		{
			int temp = heapArray[i];

			while (i > 0 && temp > heapArray[getParent(i)])
			{
				heapArray[i] = heapArray[getParent(i)];
				i = getParent(i);
			}
			heapArray[i] = temp;
		}
		
		public void insert(int value)
		{
			heapArraySize++;
			heapArray[heapArraySize] = value;
			int current = heapArraySize;
			heapifyUp(current);

		}

		// Remove an element from max heap
		public void removeFromRootNode()
		{
			int max = heapArray[1];
			heapArray[1] = heapArray[heapArraySize];
			heapArraySize--;
			heapifyDown(1);
			System.out.println("Popped Max From RootNode:" + max);
		}

		public void printHeapTree()
		{
			System.out.println("--------------Heap Complete---------------");
			for (int i = 1; i <= heapArraySize / 2; i++)
			{
				System.out.print(
						"P:" + heapArray[i] + ",L:" + heapArray[getLeftChild(i)] + ",R:" + heapArray[getRightChild(i)]);
				System.out.println();
			}
		}

		public int getMaxArrayElement()
		{
			int max = heapArray[1];
			heapArray[1] = heapArray[heapArraySize--];
			heapifyDown(1);
			
			return max;
		}

		public void printHeapArray()
		{
			System.out.println("--------------Heap Array---------------");
			for (int i = 0; i <= heapArray.length - 1; i++)
			{
				System.out.print(heapArray[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] arg)
	{
		MaxHeap_ADT maxHeap = new MaxHeap_ADT(20);
		maxHeap.insert(15);
		maxHeap.insert(13);
		maxHeap.insert(7);
		maxHeap.insert(5);
		maxHeap.insert(52);
		maxHeap.insert(23);
		maxHeap.insert(16);
		maxHeap.insert(9);
		maxHeap.insert(21);
	
		maxHeap.printHeapArray();
		maxHeap.printHeapTree();
		System.out.println("The max is " + maxHeap.getMaxArrayElement());
		
		//maxHeap.poll();
		
		maxHeap.printHeapArray();
		maxHeap.printHeapTree();
		System.out.println("The max is " + maxHeap.getMaxArrayElement());
		
	}

}