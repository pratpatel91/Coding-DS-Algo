import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class _7_PrintAllPalindromicPartitions
{
	public static void main(String[] args)
	{
		String s = "NITIN";
		System.out.println(isPalindrome(s,0,s.length()-1));
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		Deque<String> currString = new LinkedList<String>();
		palindromePartitions(list,currString,s, 0, s.length());
		
		//Iterating the List of List
		//row iterator
		for(int i=0;i<=list.size()-1;i++)
		{
			//column iterator
			for(int j=0;j<=list.get(i).size()-1;j++)
			{
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	
	//Dequeue was used to mutate the string (String Class by default is immutable)
	public static void palindromePartitions(ArrayList<ArrayList<String>> list,Deque<String> currString, String s, int left, int right)
	{
		if(left>=right)
		{
			System.out.println(currString);
			list.add(new ArrayList<>(currString));
			return;
		}
		
		for(int i=left; i<=right-1;i++)
		{
			if(isPalindrome(s,left,i))
			{
				//do
				currString.add(s.substring(left,i+1));
				//recurr
				palindromePartitions(list,currString,s, left+1, right);
				//undo
				currString.removeLast();
			}
		}
	}
	
	//TC=O(N)
	public static boolean isPalindrome(String s, int left, int right)
	{
		while(left <=right)
		{
			if(s.charAt(left)!=s.charAt(right))
			{
				return false;
			}
			left ++;
			right--;
		}
		return true;
	}
}
