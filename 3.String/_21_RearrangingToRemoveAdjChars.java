
public class _21_RearrangingToRemoveAdjChars {

	public static void main(String[] args) {
		String word = "geeksforgeeks";
		System.out.println(isStringWithNoAdjCharsPossible(word));
	}
	
	public static boolean isStringWithNoAdjCharsPossible(String word)
	{
		//word.length/2 means alternating elements
		int maxFreqToAvoidAdjChars=word.length()/2;
		
		//updating maxfreq per odd length string
		if(word.length()%2!=0)
		{
			maxFreqToAvoidAdjChars++;
		}
			
		System.out.println("maxFreqToAvoidAdjChars: " + maxFreqToAvoidAdjChars);
		
		//hashing
		int[] hash_word = new int[26]; //supports lower cases only
		
		//for loop to do populate the hash
		for(int i=0; i<=word.length()-1;i++)
		{
			hash_word[word.charAt(i)-'a']++;
		}
		
		//decision making logic to know if we can get a string with no adj chars
		int charWithMaxFreq=Integer.MIN_VALUE;
		
		for(int i=0; i<=hash_word.length-1;i++)
		{
			
			if(hash_word[i]>charWithMaxFreq)
			{
				charWithMaxFreq=hash_word[i];
			}
		}
		
		System.out.println("Freq of max char: " + charWithMaxFreq);
		
		if(charWithMaxFreq<=maxFreqToAvoidAdjChars)
		{
			return true;
		}
		return false;
	}

}
