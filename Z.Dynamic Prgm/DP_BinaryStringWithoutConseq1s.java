public class DP_BinaryStringWithoutConseq1s
{
	public static void main(String[] args)
	{
		System.out.println("tab_binStrings: "+ tab_binaryStringWithoutConseq1s(3));
		System.out.println("adhoc_binStrings: "+ adhoc_binaryStringWithoutConseq1s(3));
	}

	//recursive
	//memoized
	
	
	//TC=O(N) SC=O(N)
	public static int tab_binaryStringWithoutConseq1s(int length)
	{
		int[] zeroesDp = new int[length+1];
		int[] onesDp= new int[length+1];
		
		zeroesDp[1]=1;
		onesDp[1]=1;
		
		for(int i=2; i<=length;i++)
		{
			zeroesDp[i]=zeroesDp[i-1]+onesDp[i-1];
			onesDp[i]=zeroesDp[i-1];
		}
		return zeroesDp[length]+onesDp[length];
	}
	
	//TC=O(N) SC=O(1) a+b=c
	public static int adhoc_binaryStringWithoutConseq1s(int length)
	{
		int oldOnes = 1;
		int oldZeroes = 1;
		
		for(int i=2; i<=length;i++)
		{
			int newZeroes = oldOnes + oldZeroes;
			int newOnes =oldZeroes;
			
			oldOnes=newOnes;
			oldZeroes=newZeroes;
		}
		return oldOnes+oldZeroes;
	}
}
