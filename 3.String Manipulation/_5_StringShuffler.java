
public class _5_StringShuffler {

	public static void main(String[] args) {
		String s1= "XY";
		String s2 = "12";
		String[] array = {"X12Y","YX12"};
		
		//iterating the string array
		for(int i=0; i<=array.length-1; i++)
		{
			System.out.println(isShuffle(s1,s2,array[i]));
		}
		
	}
	
	//passing array containing string elements
	public static boolean isShuffle(String s1, String s2, String element)
	{
		int i=0;
		int j=0;
		int k=0;
		
		if(s1.length() + s2.length() != element.length())
		{
			return false;
		}
		
		while(k<element.length())
		{
			if(i<s1.length() && s1.charAt(i)==element.charAt(k))
			{
				i++;
			}
			
			if(j<s2.length() && s2.charAt(j)==element.charAt(k))
			{
				j++;
			}
			//we want to increase k no matter what increases (i or j)
			k++;
			System.out.println("i: " + i + ",j: " + j + ",k: " + k);
		}

		//-----------------Handles the case where i and j are not fully iterated due to matching chars
		if(i<s1.length() || j<s2.length())
		{
			return false;
		}
		
		return true;
		
	}
	
	

}
