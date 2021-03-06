public class _29_ImplementStackUsingDequeue
{
	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class Node
	{
		int data;
		Node prev;
		Node next;

		// constructor
		Node(int data)
		{
			this.data = data;
			prev = null;
			next = null;
		}
	}

	static class DoublyLL_Dequeue
	{
		// Deque here is a doubly LL
		static Node head;  //front
		static Node tail; //back

		DoublyLL_Dequeue()
		{
			head = null; //front
			tail = null; //back
		}
		// In a stack we insert at the back
		// In a queue we insert at the back
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

		// In a queue we can delete at the front
		public Node deleteAtFront()
		{
			Node newHead = head.next;
			newHead.prev = null;
			return newHead;
		}

		// In a stack we can delete at the back
		public void deleteAtBack()
		{
			if (head == null)
			{
				return;
			} else
			{
				// added a new node pointing void losing heads info
				Node beforeLastNode = head;

				while (beforeLastNode.next.next != null)
				{
					beforeLastNode = beforeLastNode.next; // updating the traversalNode pointer
				}
				beforeLastNode.next = null;
			}
		}

		public void printLL()
		{
			// LL TRAVERSAL----------------//
			// added a new node pointing void losing heads info
			Node traversalNode = head;

			while (traversalNode != null)
			{
				System.out.print(traversalNode.data + " ");
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			System.out.println();
		}
	}

	// ADAPTER DESIGN PATTERNS
	static class Stack1
	{
		DoublyLL_Dequeue ll = new DoublyLL_Dequeue(); // head->null

		public void push(int data)
		{
			ll.insertAtBack(data);
		}

		public void pop()
		{
			ll.deleteAtBack();
		}

		public void print()
		{
			ll.printLL();
		}
	}

	static class Queue1
	{
		DoublyLL_Dequeue ll = new DoublyLL_Dequeue(); // head->null

		
		public void enqueue(int data)
		{
			ll.insertAtBack(data);
		}

		public Node dequeue()
		{
			return ll.deleteAtFront();
		}

		public void print()
		{
			ll.printLL();
		}
	}
	public static void main(String[] args)
	{
		System.out.println("------Stack (Using DLLS)--------");
		Stack1 llStack = new Stack1();

		for (int i = 1; i <= 4; i++)
		{
			llStack.push(i);
		}

		llStack.print();

		System.out.println("deleted at back:");
		llStack.pop();
		llStack.print();

		System.out.println("------Queue (Using DLLS)--------");
		Queue1 llQueue = new Queue1();
		
		//llQueue.ll.head=null; //resetting the head so lls stacks answer doesnt append to llqueue
		
		for (int i = 1; i <= 4; i++)
		{
			llQueue.enqueue(i);
		}

		llQueue.print();

		System.out.println("deleted at front:");
		llQueue.ll.head = llQueue.dequeue();
		llQueue.print();
	}
}























