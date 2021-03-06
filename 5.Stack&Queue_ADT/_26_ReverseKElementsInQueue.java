import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _26_ReverseKElementsInQueue
{
	//Corner cases : adding when its full & removing when its empty
	static Queue<Integer> q= new LinkedList<>(); 
	static Stack<Integer> s = new Stack<>();
	static int K = 3;
	
	public static void main(String[] args)
	{
		int[] input = {1,2,3,4,5};
		populateQueue(input); //due to being a global variable we not need to assign it back into a variable
		reverseKQueueElements();
	}
	
	public static void populateQueue(int[] input)
	{
		for(int i=0; i<=input.length-1;i++)
		{
			int currentElement = input[i];
			q.add(currentElement);
		}
		System.out.println("Queue Before k Reversal");
		printQueue();
	}
	
	public static void printQueue()
	{
		// Iterator is analagous to a for loop for predefined classes
		Iterator<Integer> queue = q.iterator();

		// stops when it faces a null pointer O(N)
		while (queue.hasNext())
		{
			System.out.print(queue.next() + " ");
		}
		System.out.println();
	}
	
	public static void reverseKQueueElements()
	{
		int unchangedElements=q.size()-K;
		
		//1st pushing k elements onto the stack and removing them from the queue
		//travese till kth element in the queue
		//push element onto the stack
		//remove element from the queue
		for(int i=1; i<=K;i++) //for(int i=0; i<K;i++)
		{
			s.push(q.peek()); //finds the front element and adds it onto the stack
			q.poll(); //removes the front element and does front ++ 
		}
		
		//Stack = {1,2,3} queue = {4,5}
		
		//2nd pushing the stack elements back onto the queue
		//stack traversal
		while (!s.isEmpty())
		{
			q.add(s.peek()); //adding stack element onto the queue
			s.pop(); //removes the top element and does top --
		}
		
		//Stack = {} queue = {4,5,3,2,1}
		for(int i=1; i<=unchangedElements;i++) 
		{
			q.add(q.peek());  //adding queue element onto the queue
			q.poll();  //removes the front element and does front ++
		}
		
		//Stack = {} queue = {3,2,1,4,5}
		
		System.out.println("Queue after k Reversal");
		printQueue();
	}
	
	
}
