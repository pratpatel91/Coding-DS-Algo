import java.util.Stack;

public class _10_CelebrityProblem
{
	static Stack<Integer> stack = new Stack<>();
	static int[][] matrix = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };

	public static void main(String[] args)
	{
		int people = 3;
		System.out.println("Stack Solution");
		stackSolutionForCelebCheck(people);
		System.out.println("Two Pointers Solution");
		twoPointerSolutionForCelebCheck(people);
	}

	public static int knows(int p1, int p2)
	{
		return matrix[p1][p2];
	}

	//TBD CODE BRUTEFORCE
	
	//since we have to compare 2 people thus 2Pointers is a valid approach
	public static void twoPointerSolutionForCelebCheck(int people)
	{
		int p1 = 0;
		int p2 = people - 1;
		int celeb = 0;

		while (p1 < p2)
		{
			if (knows(p1, p2) == 1) // p1 knows p2
			{
				celeb = p2;
				p1++;
			} else // if(knows(p1,p2)==0) p1 doesnt know p2
			{
				celeb = p1; // celeb candidate
				p2--;
			}
		}
		System.out.println(celebCheck(people, celeb));
	}

	
	public static void stackSolutionForCelebCheck(int people)
	{
		// 1st, populating the stack
		for (int i = 0; i < people; i++) // i=0,1,2
		{
			stack.push(i);
		}

		// 2nd, iterating the stack
		int celeb = 0;

		while (stack.size() > 1)
		{
			//selecting 2 people from the top
			int p1 = stack.peek();
			stack.pop(); // top element is updated
			int p2 = stack.peek();
			stack.pop(); // top element is updated

			if (knows(p1, p2) == 1) // checking to see if p1 knows p2
			{
				celeb = p2; // p2 is a potential candidate for being a celebrity
			} else
			{
				celeb = p1; // p1 is a potential candidate for being a celebrity
			}

			stack.push(celeb);
		}
		System.out.println(celebCheck(people, celeb));
	}

	public static int celebCheck(int people, int celeb)
	{
		// checking to see if the potential candidate is a real celebrity
		boolean isCeleb = true;

		for (int i = 0; i < people; i++) // i=0,1,2
		{
			if (i != celeb)
			{
				if (knows(i, celeb) == 1 && knows(celeb, i) == 0)
				{
					continue;
				} else
				{
					isCeleb = false; // assignment
					break; // done searching
				}
			}
		}

		if (isCeleb == true) // checking
		{
			return celeb;
		} else
		{
			return -1;
		}
	}

}
