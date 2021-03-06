import java.util.HashMap;
import java.util.Scanner;

public class _21_CountTripletPairsInASortedDLL
{
	static Node head = null; // created a node to preserve heads info (iterative case)

	static class Node
	{
		int data;
		Node next;
		Node prev;

		Node(int data)
		{
			this.data = data;
			prev = null;
			next = null;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		_21_CountTripletPairsInASortedDLL ll = new _21_CountTripletPairsInASortedDLL();
		System.out.print("\nWhat is your targetSum?: ");
		int targetSum = input.nextInt();

		// populating the linked list
		for (int i = 6; i >=1; i--)
		{
			ll.insertAtBack(i);
		}
		printLL(head);
		
		//TC=O(N^3) SC=O(1)
		bruteForce_tripletPairsInASortedDLL(head, targetSum);
		//TC=O(N^2) SC=O(N) due to creating a hashmap ds
		hashing_tripletPairsInASortedDLL(head, targetSum);
	}

	public static void bruteForce_tripletPairsInASortedDLL(Node head, int targetSum)
	{
		System.out.println("\n...bruteForce_computeTripletPairsInADLL(head, targetSum)");
		Node i; Node j; Node k;
		int tripletPairs = 0;

		// generating all the combinations for the three pairs (using nested loops)
		for (i = head; i != null; i = i.next)
		{
			for (j = i.next; j != null; j = j.next)
			{
				for (k = j.next; k != null; k = k.next)
				{
					int tripletSum=i.data+j.data+k.data;
					System.out.println("{"+(i.data)+","+(j.data)+","+(k.data)+"}=" + tripletSum);
					
					if (tripletSum == targetSum)
					{
						System.out.println("\tTriplet Pair Found: {"+(i.data)+","+(j.data)+","+(k.data)+"}=" + tripletSum);
						tripletPairs++;
					}
				}
			}
		}
		System.out.println("Found " + (tripletPairs) + " pairs that sum upto " + targetSum);
		System.out.println("---------------------------------------------------------");
	}

	public static void hashing_tripletPairsInASortedDLL(Node head, int targetSum)
	{
		System.out.println("...hashing_computeTripletPairsInADLL(head, targetSum)");
		// -----Pointer 1 is used to store all the node addresses in a hashmap-----//
		Node i;

		HashMap<Integer, Node> map = new HashMap<Integer, Node>();

		for (i = head; i != null; i = i.next)
		{
			map.put(i.data, i);
		}
		map.forEach((key, value) -> System.out.println("key:" + key + ", value:" + value));
		System.out.println();
		
		// -----------------Two Pair Sum Approach ---------------------------------//
		Node j; Node k;

		// outer for loop starting at i=0(head for ll)
		int tripletPairs = 0;
		// generating all the combinations for the two pairs (using nested loops)
		for (j = head; j != null; j = j.next)
		{
			// inner for loop starting at j=i+1
			for (k = j.next; k != null; k = k.next)
			{
				int twoPairSum = j.data + k.data;
				int remainingSum = targetSum - twoPairSum;

				if (map.containsKey(remainingSum) && map.get(remainingSum) != j && map.get(remainingSum) != k)
				{
					tripletPairs++;
				}
			}
		}
		System.out.println("Found " + (tripletPairs/3) + " pairs that sum upto " + targetSum);
		System.out.println("---------------------------------------------------------");
	}
	
	//-----------------------------HELPER FUNCTIONS---------------------------------//
	
	public void insertAtBack(int data)
	{
		// 1st, we created a node
		Node newNode = new Node(data);

		if (head == null) // if the list is empty
		{
			head = newNode;
			return; // breaks out of the sequential flow after the else statement
		} else
		{
			// added a new node pointing void losing heads info
			Node traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // insert at back
			}
			traversalNode.next = newNode; // forward linkage
			newNode.prev = traversalNode; // backward linkage
		}
	}
	
	public static void printLL(Node head)
	{
		// added a new node pointing void losing heads info
		Node traversalNode = head;
		System.out.print("LL: ");
		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}
}
