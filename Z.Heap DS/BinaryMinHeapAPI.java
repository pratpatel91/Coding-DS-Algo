import java.util.Iterator;
import java.util.PriorityQueue;

class BinaryMinHeapAPI
{
	static PriorityQueue<Integer> minHeapAPI = new PriorityQueue<>();

	public static void printMinHeapAPI()
	{
//      Traverse the Queue without destroying it
		Iterator<Integer> i = minHeapAPI.iterator();
		
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
		//queue
		minHeapAPI.add(1);
		minHeapAPI.add(4);
		minHeapAPI.add(3);
		minHeapAPI.add(2);
		printMinHeapAPI();

		System.out.println("minHeap.peek() = " + minHeapAPI.peek()+"\n");
		printMinHeapAPI();

		System.out.print("minHeap.poll() = " + minHeapAPI.poll()+"\n");
		printMinHeapAPI();

		System.out.print("minHeap.remove(1) = " + minHeapAPI.remove(1)+"\n");
		printMinHeapAPI();


	}
}
