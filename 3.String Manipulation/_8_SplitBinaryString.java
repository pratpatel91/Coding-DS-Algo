
public class _8_SplitBinaryString {

	public static void main(String[] args) {
		String binaryString =  "0100110101";
		System.out.println(binaryStringSplitter(binaryString));
	}
	
	public static int binaryStringSplitter(String binaryString)
	{
		int count_zeroes=0;
		int count_ones=0;
		int splitString=0;
		
		//for loop to iterate the string
		for(int i=0; i<=binaryString.length()-1;i++)
		{
			 if(binaryString.charAt(i)=='0')
			 {
				 count_zeroes++;
			 }
			 else if (binaryString.charAt(i)=='1')
			 {
				 count_ones++;
			 }
			
			 if(count_zeroes == count_ones)
			 {
				 System.out.println("Num_Zeroes: " + count_zeroes + ", Num_Ones: " + count_ones);
				 splitString++;
			 }
		}
		
		return splitString;
		
	}

}
