public class _27_IsomorphicStrings {

	public static void main(String[] args) {
		String s1= "aab";
		String s2="xhy";
		System.out.println(isomorphicChecker(s1, s2));
	}
	
	public static boolean isomorphicChecker(String s1, String s2)
	{
		//1.checking if the strings are isomorphic via lengths
		if(s1.length() != s2.length())
		{
			return false; // due to mismatching lengths we dont have a 1:1 mapping
		}
		
		//2.comparison of hash tables
		
		int[] hash_s1 = new int[26]; //size of 26 supports lowercase alphabet only
		int[] hash_s2= new int[26];  //size of 26 supports lowercase alphabet only
		
		//2.1for loops to populate the hash array
		for(int i=0; i<=s1.length()-1;i++)
		{
			// s1.charAt(i) ranges from 97(ASCI of a) - 97+26
			//s1.charAt(i)-'a' ranges from 0-25
			hash_s1[s1.charAt(i)-'a']++;
		}
		
		for(int i=0; i<=s2.length()-1;i++)
		{
			// s2.charAt(i) ranges from 97(ASCI of a) - 97+26
			//s2.charAt(i)-'a' ranges from 0-25
			hash_s2[s2.charAt(i)-'a']++;
		}
		
		//2.2 hash table comparisons to find if a string is isomorphic
		for(int i=0; i<=s1.length()-1;i++)
		{
			//s1.charAt(i) gives the current character in s1
			//s2.charAt(i) gives the current character in s2
			
			//finding frequencies of the current char in both the strings
			if(hash_s1[s1.charAt(i)-'a']!=hash_s2[s2.charAt(i)-'a'] )
			{
				return false;
			}	
		}
		//incase if the strings are isomorphic
		return true;	
	}
}
