import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class _24_LRUCacheImplementation
{
	// INTERFACE=CONSTRUCTOR
	static HashSet<Integer> hashSet; // declaration
	static int pageFault = 0; // is text isnt in current screen then pageFault++

	// deque uses a linkedlist (pointer based)
	// which is why TC=O(1) instead of O(N) which was array based
	static Deque<Integer> deque; // declaration

	//CONSTRUCTOR
	_24_LRUCacheImplementation()
	{
		hashSet = new HashSet<>(); // empty initialization
		deque = new LinkedList<>(); // empty initialization
	}

	public static void main(String[] args)
	{
		_24_LRUCacheImplementation lruCache = new _24_LRUCacheImplementation();

		int[] text =
		{ 1, 2, 3, 1, 1, 4 }; // stream of messages
		int cacheSize = 4; // 4 messages per phone screen

		// iterate over the array
		for (int i = 0; i <= text.length - 1; i++)
		{
			int currentPerson = text[i];
			lruCache.findPerson(currentPerson, cacheSize);
			printCurrentWindow();
		}
	}

	public static void findPerson(int currentPerson, int cacheSize)
	{
		System.out.println("Current person: " + currentPerson);

		if (!(hashSet.contains(currentPerson)))
		{
			pageFault++;
			System.out.println("Page Fault:" + pageFault);

			// checking if deque is full
			if (deque.size() == cacheSize)
			{
				int removedFromLast = deque.removeLast(); // make a space for current person
				hashSet.remove(removedFromLast);// remove person from the window
			}
		} else // if((hashSet.contains(currentPerson))
		{
			deque.remove(currentPerson); // removing the least recent currentPerson
											// from the window
		}
		deque.push(currentPerson); // currentPerson goes to the top of window
		hashSet.add(currentPerson);
	}

	public static void printCurrentWindow()
	{
		// Iterator is analagous to a for loop for predefined classes
		Iterator<Integer> dequeTraversal = deque.iterator();

		// stops when it faces a null pointer O(N)
		while (dequeTraversal.hasNext())
		{
			System.out.print(dequeTraversal.next() + " ");
		}
		System.out.println();
	}

}
