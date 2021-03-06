import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _20_StackPermutation
{
	//queue uses ll implementation
	static Queue<Integer> q1 = new LinkedList<>();  
	static Queue<Integer> q2 = new LinkedList<>(); 
	static Stack<Integer> s1 = new Stack<>();
	
	//TC=O(N)
	//SC=O(N)
	public static void main(String[] args)
	{
		int[] a1 = {1,2,3,4};
		int[] a2 = {2,1,3,4};
		
		//populating the queue based on array data
		for(int i=0; i<=a1.length-1;i++)
		{
			q1.add(a1[i]);
		}
		
		for(int i=0; i<=a2.length-1;i++)
		{
			q2.add(a2[i]);
		}
		
		
		//populating the stack (holds mismatching queue elements)
		while(!q1.isEmpty())
		{
			int front = q1.poll();// updates the front pointer
			
			if(front == q2.peek())
			{
				q2.poll(); // updates the front pointer
				
				while(!s1.isEmpty())
				{
					if(s1.peek()==q2.peek())
					{
						s1.pop();
						q2.poll();
					}
					else
					{
						break;
					}
				}
			}
			else //pushing the mismatched front from the queue onto the stack
			{
				s1.push(front);
			}
		}
		
		//DISPLAY ANSWER
		if(q1.isEmpty() && s1.isEmpty())
		{
			System.out.println("q1 and q2 are permutations of each other");
		}
		else
		{
			System.out.println("q1 and q2 are not permutations of each other");
		}
		
		

	}

}
