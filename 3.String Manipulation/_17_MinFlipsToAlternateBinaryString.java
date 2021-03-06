

public class _17_MinFlipsToAlternateBinaryString
{
	public static void main(String[] args)
	{
		String binaryString = "0001010111";
		minFlipsToAlternateBinaryStrings(binaryString);
	}
	public static void minFlipsToAlternateBinaryStrings(String binaryString)
	{
		int flipsToGetCase_1=0; //01010
		int flipsToGetCase_2=0; //10101
		
		for(int i=0; i<=binaryString.length()-1;i++)
		{
			//does 0 exist at odd positions
			if(i%2!=0 && binaryString.charAt(i)=='0')
			{
				flipsToGetCase_1++;
			}
			//does 1 exist at even positions
			if(i%2==0 && binaryString.charAt(i)=='1')
			{
				flipsToGetCase_1++;
			}
			//does 1 exist at odd positions
			if(i%2!=0 && binaryString.charAt(i)=='1')
			{
				flipsToGetCase_2++;
			}
			//does 0 exist at even positions
			if(i%2==0 && binaryString.charAt(i)=='0')
			{
				flipsToGetCase_2++;
			}
		}
		int minFlips = Math.min(flipsToGetCase_1, flipsToGetCase_2);
		System.out.println(minFlips);
	}
}
