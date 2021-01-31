
public class _7_StringSubsequence {

	public static void main(String[] args) {
		String word = "abc";
		printSubsequence(word);
	}

	public static void printSubsequence(String word)
	{
		int num_subsequences = (int) (Math.pow(2, word.length())-1);
		
		//iterating the subsequence
		for(int i=0; i<=num_subsequences;i++)
		{
			//iterate over the string
			for(int j=0; j<=word.length();j++)
			{
				if ( (i & (1<<j) )!=0 )
				{
						System.out.print(word.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
