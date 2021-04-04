import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _4_RemoveInvalidParens
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter # of test cases: ");
		int testCases = input.nextInt();

		while (testCases != 0)
		{
			System.out.print("\nEnter the string of parenthesis: ");
			String s = input.next();
			ArrayList<String> list = removeInvalidParentheses(s);
			printArrayList(removeInvalidParentheses(s));
			testCases--;
		}
	}
	
	//TC=O(N*2^N)....branches^depth
	//SC=O(2^N)
	public static ArrayList<String> removeInvalidParentheses(String s)
	{
		ArrayList<String> list = new ArrayList<>();
		if (s == null || s.length() == 0)
		{
			list.add("");
			return list;
		}
		Queue<String> queue = new LinkedList<>();
		HashSet<String> hash = new HashSet<>();
		boolean found = false;
		queue.offer(s);
		while (!queue.isEmpty())
		{
			String str = queue.poll();
			if (isParensBalanced(str))
			{
				list.add(str);
				found = true;
			}
			if (found)
			{
				continue;
			}
			for (int i = 0; i < str.length(); i++)
			{
				char c = str.charAt(i);
				if (c == '(' || c == ')')
				{
					String sub = str.substring(0, i) + str.substring(i + 1);
					if (!hash.contains(sub))
					{
						queue.offer(sub);
						hash.add(sub);
					}
				}
			}
		}
		return list;
	}

	public static void printArrayList(ArrayList<String> list)
	{
		Iterator<String> i = list.iterator();

		while (i.hasNext())
		{
			System.out.println(i.next() + " ");
		}
	}

	public static boolean isParensBalanced(String s)
	{
		int isBalanced = 0;

		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				// System.out.println("if part of if-else ...");
				isBalanced++;
			}
			else if (s.charAt(i) == ')')
			{
				// System.out.println("else part of if-else ...");
				isBalanced--;
			}
			if (isBalanced < 0)
			{
				// System.out.println("if ...");
				return false;
			}
		}
		// System.out.println("return statement ...");
		return (isBalanced == 0);
	}
}
