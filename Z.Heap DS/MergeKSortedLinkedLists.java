import java.util.PriorityQueue;

public class MergeKSortedLinkedLists
{
	static class LLNodeADT implements Comparable<LLNodeADT>
	{
		int data;
		LLNodeADT nextPointer;

		LLNodeADT(int data)
		{
			this.data = data;
			this.nextPointer = null;
		}

		@Override
		public int compareTo(LLNodeADT o)
		{
			return this.data - o.data; // ascending sort
		}
	}

	public static void main(String[] args)
	{
		LLNodeADT[] linkedListArray = new LLNodeADT[4];
		linkedListArray[0] = new LLNodeADT(1);
		linkedListArray[0].nextPointer = new LLNodeADT(2);
		linkedListArray[0].nextPointer.nextPointer = new LLNodeADT(3);

		linkedListArray[1] = new LLNodeADT(7);
		linkedListArray[1].nextPointer = new LLNodeADT(8);
		linkedListArray[1].nextPointer.nextPointer = new LLNodeADT(9);

		linkedListArray[2] = new LLNodeADT(10);
		linkedListArray[2].nextPointer = new LLNodeADT(11);
		linkedListArray[2].nextPointer.nextPointer = new LLNodeADT(12);

		linkedListArray[3] = new LLNodeADT(4);
		linkedListArray[3].nextPointer = new LLNodeADT(5);
		linkedListArray[3].nextPointer.nextPointer = new LLNodeADT(6);

		int k_rows = 4;
		LLNodeADT headPointer =mergeKSortedLLs(linkedListArray, k_rows);
		printLL(headPointer);
	}

	//TC=O(NK * logK)
	//SC=O(NK)
	public static LLNodeADT mergeKSortedLLs(LLNodeADT[] linkedListArray, int k_rows)
	{
		PriorityQueue<LLNodeADT> minHeap = new PriorityQueue<LLNodeADT>();
		LLNodeADT headPointer = null;
		LLNodeADT lastPointer = null;
		
		//loading array into heap
		for(int i=0; i<=k_rows-1; i++)
		{
			if(linkedListArray[i]!= null)
			{
				minHeap.add(linkedListArray[i]);
			}
		}
		
		while(minHeap.size()>0)
		{
			LLNodeADT minElement = minHeap.peek();
			minHeap.poll(); //removes the root node
			if(minElement.nextPointer!=null)
			{
				minHeap.add(minElement.nextPointer);
			}
			//adding first element to LL
			if(headPointer ==null)
			{
				headPointer=minElement;
				lastPointer=minElement;
			}
			else //adding all other elements to LL
			{
				lastPointer.nextPointer=minElement;
				lastPointer=minElement;
			}
		}
		return headPointer;
	}
	
	public static void printLL(LLNodeADT headPointer)
	{
		while(headPointer!=null)
		{
			System.out.print(headPointer.data + "->");
			headPointer=headPointer.nextPointer; //i++
		}
	}
	
	
	
	
	

}
