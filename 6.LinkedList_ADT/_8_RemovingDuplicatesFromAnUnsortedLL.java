import java.util.Scanner;

public class _8_RemovingDuplicatesFromAnUnsortedLL
{
	static LLNode_ADT head = null;

	// Nested Class (LLNode is the ADT, int is the primitive data type)
	static class LLNode_ADT
	{
		int data;
		LLNode_ADT next;

		// constructor
		LLNode_ADT(int data)
		{
			this.data = data;
			next = null;
		}
	}

	public void insertAtBack(int data)
	{
		// 1st, we created a node
		LLNode_ADT newNode = new LLNode_ADT(data);

		if (head == null)
		{
			head = newNode;
		} else
		{
			// added a new node pointing void losing heads info
			LLNode_ADT traversalNode = head;

			while (traversalNode.next != null)
			{
				traversalNode = traversalNode.next; // updating the traversalNode pointer
			}
			traversalNode.next = newNode;
		}
	}

	public void printLinkedList(LLNode_ADT head)
	{
		// LL TRAVERSAL----------------//
		// added a new node pointing void losing heads info
		LLNode_ADT traversalNode = head;
		int size = 0;

		while (traversalNode != null)
		{
			System.out.print(traversalNode.data + " ");
			size++;
			traversalNode = traversalNode.next; // updating the traversalNode pointer
		}
		System.out.println();
	}

	public LLNode_ADT removeDuplicates(LLNode_ADT head)
	{
		LLNode_ADT current = head;
		LLNode_ADT newHead = null;
		LLNode_ADT tempNode = null;

		boolean[] isVisited = new boolean[100];
		
		while(current!=null)
		{
			int value = current.data;
			
			if(isVisited[value]==false)
			{
				//if its not visited before make it true
				isVisited[value]=true;
				//System.out.println("isVisited:" + value);
				
				if(newHead==null)
				{
					tempNode=new LLNode_ADT(value);
					newHead=tempNode;
					
				}
				else //handles creation of node during the first visit
				{
					LLNode_ADT tempNode_1=new LLNode_ADT(value);
					tempNode.next=tempNode_1;
					tempNode=tempNode.next;
				}
			}
			current=current.next; //eliminates infinite loop
		}
		//printLinkedList(newHead);
		return newHead;
	}
	
	public static void main(String[] args)
	{
		// creating the linked list
		_8_RemovingDuplicatesFromAnUnsortedLL ll = new _8_RemovingDuplicatesFromAnUnsortedLL(); // head->null
		Scanner input = new Scanner(System.in);

		// populating the linked list
		for (int i = 1; i <= 10; i++)
		{
			int value = input.nextInt();
			ll.insertAtBack(value);
		}

		ll.printLinkedList(head);

		head = ll.removeDuplicates(head);

		ll.printLinkedList(head);
	}

}
