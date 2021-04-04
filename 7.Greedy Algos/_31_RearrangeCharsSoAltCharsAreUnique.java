import java.util.Comparator;
import java.util.PriorityQueue;

//ADT (anytime we have an ADT we need to create a comparator)
class Pair
{
	char character;
	int freq;
	
	Pair(char character, int freq)
	{
		this.character=character;
		this.freq=freq;
	}
}

class SortByMaxFreq implements Comparator<Pair>
{

	@Override
	public int compare(Pair o1, Pair o2)
	{
		//descending order of freq
		return o2.freq-o1.freq;
	}
	
}

public class _31_RearrangeCharsSoAltCharsAreUnique
{
	
	public static void main(String[] args)
	{
		String s = "aaaaabbbbcccc";
		getStringWithAltChars(s);
	}
	
	public static void getStringWithAltChars(String s)
	{	
		char[] hashArray = new char[26]; //a-z support
		
		for(int i=0;i<=s.length()-1;i++)
		{
			hashArray[s.charAt(i)-'a']++;
			
		}
		
		PriorityQueue<Pair> rearrangeChars = new PriorityQueue<>(new SortByMaxFreq());
	
		//populating max heap char and freq per each char 
		for(int i=0;i<=hashArray.length-1;i++)
		{
			if(hashArray[i]>0)
			{
				char character = (char) (i+'a');
				int freq = hashArray[i];
				rearrangeChars.add(new Pair(character,freq));
			}
		}
		
		String result = "";
		
		//tracking prev top so dont have 2 adj chars that are the same
		Pair prevTop = new Pair('+',-1);
		
		//emptying the max heap
		while(rearrangeChars.size()>0)
		{
			Pair top = rearrangeChars.poll();
			result+=top.character;
			
			if(prevTop.freq >0)
			{
				rearrangeChars.add(prevTop);
			}
			
			top.freq--; //decreasing freq after removing from the root node
			prevTop=top;
		}
		
		System.out.println(result);
		
	}
	
}
