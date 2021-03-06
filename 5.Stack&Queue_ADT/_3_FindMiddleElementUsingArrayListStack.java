import java.util.ArrayList;

class Stack_ADT
{
	//Stack ADT is implemented by an ArrayList
	private ArrayList<Integer> stackArrayList;

	public Stack_ADT()
	{
		System.out.println("--Object Creation Method----");
		stackArrayList = new ArrayList<Integer>(); //SC=O(N)
	}
	
	//TC=O(1)
	public void pushIntoTop(int data)
	{
		System.out.println("\nAdded To The Top:" + data);
		stackArrayList.add(data);
	}
	
	//TC=O(1)
	public void popFromTop()
	{
		int top = stackArrayList.size() - 1;
		int topElement = stackArrayList.get(top);
		System.out.println("\nDeleting From The Top:" + topElement);
		stackArrayList.remove(top);
	}
	
	//TC=O(1)
	public void getMiddle()
	{
		int middle = stackArrayList.size() / 2;
		int middleElement = stackArrayList.get(middle);
		System.out.println("\nFound At Middle:" + middleElement);
	}
	
	//TC=O(N)
	//Array list uses an array internally which means
	//deleting an element means running a for loop that shifts all the 
	//elements to the left by one.
	public void deleteMiddle()
	{
		int middle = stackArrayList.size() / 2;
		int middleElement = stackArrayList.get(middle);
		System.out.println("\nDeleting From The Middle:" + middleElement);
		stackArrayList.remove(middle);
	}
	
	//TC=O(N)
	public void displayStack()
	{
		System.out.print("Stack: ");

		for (int i = 0; i <= stackArrayList.size() - 1; i++)
		{
			System.out.print(stackArrayList.get(i) + " ");
		}
		System.out.println("");
	}
}

public class _3_FindMiddleElementUsingArrayListStack
{
	public static void main(String[] args)
	{
		Stack_ADT stackADT = new Stack_ADT();
		stackADT.pushIntoTop(1);
		stackADT.pushIntoTop(2);
		stackADT.pushIntoTop(3);
		stackADT.displayStack();
		stackADT.getMiddle();
		stackADT.deleteMiddle();
		stackADT.displayStack();
		stackADT.popFromTop();
		stackADT.displayStack();
	}

}
