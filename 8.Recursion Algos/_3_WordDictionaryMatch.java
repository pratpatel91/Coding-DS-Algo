import java.util.HashSet;
import java.util.Scanner;

public class _3_WordDictionaryMatch
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int wordsInDict = input.nextInt();
		
		HashSet<String> dictionary = new HashSet<>();

		for(int i=0;i<wordsInDict;i++)
		{
			String word = input.next();
			dictionary.add(word);
		}
		
		String sentence = input.next();
		
		wordBreak(sentence, dictionary, "");
	}

	public static void wordBreak(String sentence, HashSet<String> dictionary, String s)
	{
		//base case
		if(sentence.length()==0)
		{
			System.out.println(s);
			return;
		}
		
		for(int i=0;i<sentence.length();i++)
		{
			String left = sentence.substring(0,i+1);
			if(dictionary.contains(left))
			{
				String right = sentence.substring(i+1); //i+1-----end of string
				wordBreak(right, dictionary, s+left+" ");
			}
		}
		
	}

}
