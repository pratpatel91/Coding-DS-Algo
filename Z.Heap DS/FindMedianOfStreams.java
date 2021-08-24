import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedianOfStreams
{
	// ------- Using PriorityQueues to implement the heaps-----//
	// --- If we had to manually maintain a heap then doing insert/delete for heap
	// for N elements means heap sorting algorithms would take TC=O(N log N)
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // default of a PriorityQueue is min-heap
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // reversing means max-heap

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int size = 100000;
		// stream is better modeled as an arraylist (not array) due to dynamically
		// growing in size
		ArrayList<Integer> streamData = new ArrayList<>();
		int index = 0;

		while (true)
		{
			int userInput = input.nextInt();
			// breaking out of the stream of supplied inputs
			if (userInput == -1)
			{
				break;
			}
			else
			{
				streamData.add(userInput);
				// System.out.println("Brute Force Median=" +
				// bruteForce_findMedian(streamData));
				optimized_2Heaps_findMedian(userInput);
				System.out.println("Optimized Median=" + computeMedian());
			}
		}
	}

	// TC=O(N)*N*log(N) we are resorting the list everytime before adding a new
	// number
	// Sc=O(N) due to creating an array list
	public static int bruteForce_findMedian(ArrayList<Integer> streamData)
	{
		Collections.sort(streamData); // using built in sorting algorithms means TC of O(N log N)
		int mid;
		mid = streamData.size() / 2;

		if (streamData.size() % 2 == 0)
		{
			return (streamData.get(mid - 1) + streamData.get(mid)) / 2;
		}
		else
		{
			return streamData.get(mid);
		}
	}

	// A min-heap contains larger half of elements, with root = min element
	// A max-heap contains smaller half of the elements, with root = max element
	// TC-O(log N) doe to adding and removing elements from the heap
	// SC=O(N) due to using priority queues to hold the data
	public static void optimized_2Heaps_findMedian(int element)
	{
		// 3 cases
		// Heaps are balanced
		if (minHeap.size() == maxHeap.size())
		{
			// starting out we can place the element blindly in
			// maxHeap or minHeap
			if (maxHeap.size() == 0)
			{
				maxHeap.add(element); // adding 1 element onto the N sized heap means TC=O(log N)
			}
			else if (element < maxHeap.peek())
			{
				maxHeap.add(element); // adding the lesser values onto the maxHeap means TC=O(log N)
			}
			else
			{
				minHeap.add(element); // adding the greater values onto the minHeap means TC=O(log N)
			}
		}
		else if (maxHeap.size() > minHeap.size())
		{
			if (element >= maxHeap.peek())
			{
				minHeap.add(element); // adding the greater values onto the minHeap means TC=O(log N)
			}
			else
			{
				// --Balancing the heaps --//
				System.out.println("MinHeapSize:" + minHeap.size() + ", MaxHeapSize:" + maxHeap.size());
				int pop = maxHeap.remove(); // removing 1 element from the N sized heap means TC=O(log N)
				System.out.println("CurrentElement " + element + " is a candidate to be on maxHeap as " + maxHeap.peek()
						+ " is having a greater value than currentElement and we want to keep min elements on maxHeap");
				minHeap.add(pop); // adding 1 element onto the N sized heap means TC=O(log N)
				maxHeap.add(element); // adding 1 element onto the N sized heap means TC=O(log N)
				System.out.println("MinHeapSize:" + minHeap.size() + ", MaxHeapSize:" + maxHeap.size());
			}
		}
		else // if (minHeap.size()>maxHeap.size()) // syntax error missing ;
		{
			if (element <= minHeap.peek())
			{
				maxHeap.add(element); // adding the lesser values onto the maxHeap
			}
			else
			{
				// --Balancing the heaps --//
				System.out.println("MinHeapSize:" + minHeap.size() + ", MaxHeapSize:" + maxHeap.size());
				int pop = minHeap.remove(); // removing 1 element from the N sized heap means TC=O(log N)
				System.out.println("CurrentElement " + element + " is a candidate to be on minHeap as " + minHeap.peek()
						+ " is having a smaller value than currentElement and we want to keep max elements on minHeap");
				maxHeap.add(pop); // adding 1 element onto the N sized heap means TC=O(log N)
				minHeap.add(element); // adding 1 element onto the N sized heap means TC=O(log N)
				System.out.println("MinHeapSize:" + minHeap.size() + ", MaxHeapSize:" + maxHeap.size());
			}
		}
	}

	// TC=O(1) for computeMedian()
	// computing median as the average of the root elements of both the heaps
	// otherwise the root element of the heap with more elements is the median.
	public static int computeMedian()
	{
		if (minHeap.size() == maxHeap.size())
		{
			if (minHeap.size() == 0)
			{
				return -1;
			}
			else
			{
				// computing median as the average of the root elements of both the heaps
				int min = minHeap.peek(); // TC=O(1) to access min/root element of the minHeap
				int max = maxHeap.peek(); // TC=O(1) to access max/root element of the maxHeap
				return (min + max) / 2;
			}
		}
		// maxHeap has more elements so the root of the maxHeap is the median
		else if (maxHeap.size() > minHeap.size())
		{
			return maxHeap.peek(); // TC=O(1) to access max in a heap
		}
		// minHeap has more elements so the root of the minHeap is the median
		else
		{
			return minHeap.peek(); // TC=O(1) to access min in a heap
		}
	}

}
