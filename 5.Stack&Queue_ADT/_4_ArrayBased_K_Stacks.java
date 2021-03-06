import java.util.Arrays;

public class _4_ArrayBased_K_Stacks
{
	// ideally should be private access for OOP
	static int[] kTop;
	static int[] nextIndex;
	static int[] answer;
	static int freeIndex;

	// CONSTRUCTOR
	_4_ArrayBased_K_Stacks(int K, int N)
	{
		nextIndex = new int[N];
		answer = new int[N];
		kTop = new int[K];
		freeIndex = 0;

		// kTops array is populated to be -1
		for (int i = 0; i <= K - 1; i++)
		{
			kTop[i] = -1;
		}

		// nextAvailIndexArray is 1,2,3,4 etc
		for (int i = 0; i <= N - 1; i++)
		{
			nextIndex[i] = i + 1;
		}
		// last element is -1 because after i=14 we are the end of the array so
		// no more next avail index exists
		nextIndex[N - 1] = -1;
	}

	public void push(int value, int stackNum)
	{
		if (isFull() == true)
		{
			System.out.println("Cant insert into a full stack");
		} else
		{
			// PUSH
			int i = freeIndex;
			answer[i] = value;
			System.out.println("free Index:" + i + ", pushing into answer[i] " + answer[i]);
			freeIndex = nextIndex[i];
			System.out.println("next avail Index:" + freeIndex);
			nextIndex[i] = kTop[stackNum];
			System.out.println("Storing prev top in nextArray: " + nextIndex[i]);
			kTop[stackNum] = i;
			System.out.println("current top of stack " + stackNum + "is " + answer[i]);
		}
	}

	public void pop(int stackNum)
	{
		if (isEmpty(stackNum) == true)
		{
			System.out.println("Cant delete from an empty stack");
		} else
		{
			// POP
			int i = kTop[stackNum];
			System.out.println("value to pop from the stack: " + kTop[stackNum] + ", index for deletion: " + i);
			kTop[stackNum] = nextIndex[i];// setting the ktop to be the previous element
			System.out.println("current top: " + answer[i] + " , prev top: " + kTop[stackNum]);

			nextIndex[i] = freeIndex; // updating the free index
			System.out.println("updating the free index: " + freeIndex);
			freeIndex = i;// resetting the free index
			System.out.println("in pop current free index is : " + freeIndex);
		}
	}

	public static boolean isEmpty(int stackNum)
	{
		if (kTop[stackNum] == -1)
		{
			return true;
		}
		return false;
	}

	public static boolean isFull()
	{
		if (freeIndex == -1)
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		int N = 15;
		int K = 5; // stacks range from 0-4

		_4_ArrayBased_K_Stacks stack = new _4_ArrayBased_K_Stacks(K, N);

		stack.push(3, 1); // pushing 3 into the 0th stack
		stack.push(4, 4);
		stack.push(2, 1);
		System.out.println(Arrays.toString(nextIndex));
		System.out.println(Arrays.toString(answer));
		System.out.println();
		
		stack.pop(4);
		System.out.println(Arrays.toString(nextIndex));
		System.out.println(Arrays.toString(answer));
		System.out.println();
		
		stack.push(5,4);
		System.out.println(Arrays.toString(nextIndex));
		System.out.println(Arrays.toString(answer));
		
	}

}
