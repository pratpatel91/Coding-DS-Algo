import java.util.LinkedList;
import java.util.Queue;

public class _32_FirstNonRepeatitiveCharInStream
{
	// For First Occuring Problems we should resort to using queues
	static Queue<Character> queue = new LinkedList<>();
	static char[] hashArray = new char[26];// supports a-z lowercase

	public static void main(String[] args)
	{
		String stream = "aabcbdegs";
		System.out.println(stream);
		
		//1st char is non repeating so we directly add it to the queue
		queue.add(stream.charAt(0));
		hashArray[stream.charAt(0) - 'a']++;
		System.out.print(queue.peek());

		//checking 2nd till last char for repetition when adding it onto the queue
		for (int i = 1; i < stream.length(); i++)
		{
			System.out.print(firstNonRepeatCharInStream(stream.charAt(i)));
		}
	}

	public static char firstNonRepeatCharInStream(char input)
	{
		queue.add(input);
		hashArray[input - 'a']++; // input - 'a' is the charIndex

		while (!queue.isEmpty())
		{
			if (hashArray[input - 'a'] > 1) //checking for repeated elements in the hasharray
			{
				queue.remove();// removing repeated elements from the queue
			} else
			{
				break; //avoids infinite loop (aa becomes a then it skips if conditon and 
					   //never satisfied the termination condition of the while loop
			}
		}
		if (queue.isEmpty())
		{
			return '#';
		} else
		{
			return queue.peek(); // gives the first non repeating char
		}
	}
}
