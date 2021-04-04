
public class _32_MaxSumEqualToThreeStacks
{

	public static void main(String[] args)
	{
		int[] a = {3,2,1,1,1};
		int[] b = {4,3,2};
		int[] c = {1,1,4,1};
		
		int aSum=arraySum(a);
		int bSum=arraySum(b);
		int cSum=arraySum(c);
		System.out.println("aSum:"+aSum+",bSum:"+bSum+",cSum:"+cSum);
		
		int maxSum=0;
		int topA=0,topB=0,topC=0;
		
		while(topA<a.length && topB<b.length && topC<c.length)
		{
			if(aSum==bSum && aSum==cSum)
			{
				maxSum=aSum;
				break;
			}
			else
			{
				System.out.println("aSum:"+aSum+",bSum:"+bSum+",cSum:"+cSum);
				//Greedy Approach (selecting max sum stack and updating the top)
				if(aSum>=bSum && aSum>=cSum)
				{
					aSum-=a[topA];
					topA++;
				}
				else if(bSum>=aSum && bSum>=cSum)
				{
					bSum-=b[topB];
					topB++;
				}
				else if (cSum>=aSum && cSum>=bSum)
				{
					cSum-=c[topC];
					topC++;
				}
				System.out.println("after " + "aSum:"+aSum+",bSum:"+bSum+",cSum:"+cSum);
			}
			
		}
		System.out.println("maxSum:"+maxSum);
	}
	
	public static int arraySum(int[] array)
	{
		int arraySum =0;
		
		for(int i=0;i<=array.length-1;i++)
		{
			arraySum+=array[i];
		}
		return arraySum;
	}
	

}
