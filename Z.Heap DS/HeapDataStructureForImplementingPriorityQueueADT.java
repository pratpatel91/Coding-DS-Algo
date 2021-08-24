import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapDataStructureForImplementingPriorityQueueADT
{
	public static void main(String[] args)
	{
		int[] heapArray = {1, 10, 5, 3, 4, 7, 6, 9, 8};
		System.out.print("Array before minHeapSort: ");
		System.out.println(Arrays.toString(heapArray)); //printing the regular array
		
		minHeapSort(heapArray);
		System.out.print("Array after minHeapSort: ");
		System.out.println(Arrays.toString(heapArray)); //printing the minheap sorted array
		
		maxHeapSort(heapArray);
		System.out.print("Array after maxHeapSort: ");
		System.out.println(Arrays.toString(heapArray)); //printing the maxheap sorted array
	}
	
	public static void minHeapSort(int[] heapArray)
	{
		//Using Heap Data Structure to implement the Priority Queue ADT
		//For MinHeap use the default priority queue works
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		//adding the array into the minHeap
		for(int i=0; i<heapArray.length;i++)
		{
			minHeap.add(heapArray[i]);
		}
		
		//adding the minHeap back into the array
		for(int i=0; i<heapArray.length;i++)
		{
			heapArray[i] = minHeap.poll();
		}
	}
	
	public static void maxHeapSort(int[] heapArray)
	{
		//Using Heap Data Structure to implement the Priority Queue ADT
		//For MaxHeap override the Comparator Interfaces compare method
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(heapArray.length-1, new Comparator<Integer>() 
		{
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a; 
		    }
		}); 
		
		//adding the array into the minHeap
		for(int i=0; i<heapArray.length;i++)
		{
			maxHeap.add(heapArray[i]);
		}
		
		//adding the maxHeap back into the array
		for(int i=0; i<heapArray.length;i++)
		{
			heapArray[i] = maxHeap.poll();
		}
	}
}

