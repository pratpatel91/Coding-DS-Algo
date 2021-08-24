import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class BinaryMaxHeapAPI
{
	static PriorityQueue<Integer> maxHeapAPI = new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void printMinHeapAPI()
	{
//      Traverse the Queue without destroying it
		Iterator<Integer> i = maxHeapAPI.iterator();

		while (i.hasNext())
		{
			System.out.print(i.next() + " ");
		}
		System.out.println();

//      Traverse the Queue while destroying it
//		while(minHeapAPI.size()!=0)
//		{
//			System.out.println(minHeapAPI.poll());
//		}
	}

	public static void main(String args[])
	{
		// queue
		maxHeapAPI.add(1);
		maxHeapAPI.add(4);
		maxHeapAPI.add(3);
		maxHeapAPI.add(2);
		printMinHeapAPI();

		System.out.println("maxHeap.peek() = " + maxHeapAPI.peek() + "\n");
		printMinHeapAPI();

		System.out.print("maxHeap.poll() = " + maxHeapAPI.poll() + "\n");
		printMinHeapAPI();

		System.out.print("maxHeap.remove(1) = " + maxHeapAPI.remove(1) + "\n");
		printMinHeapAPI();

	}
}