import java.util.Arrays;

public class _16_MaxConseqSumDiffInCircularArray
{
	public static void main(String[] args)
	{
		int[] array = {4,2,1,8,16,32,5,9,6,23,96};
		Arrays.sort(array); 
		
		//two pointers(pair smallest,largest then 2nd small, 2ndlarge etc)
		int[] conseq = new int[array.length];
		
		int left =0;
		int right =conseq.length-1;
		int i=0;
		while(left<=right)
		{
			//handling placement of odd element
			if(left == right)
			{
				conseq[i]=array[right];
				right--;
				left++;
				i++;
				break;
			}
			conseq[i]=array[left];
			i++;
			left++;
			
			conseq[i]=array[right];
			i++;
			right--;
		}
		
		System.out.println(Arrays.toString(conseq));
		
		int maxConseqSum=0;
		for(i=0; i<=conseq.length-2;i++)
		{
			maxConseqSum+=Math.abs(conseq[i]-conseq[i+1]);
		}
		//to account for diff between 1st and last element due to 
		//having a circular array
		maxConseqSum+=Math.abs(conseq[conseq.length-1]-conseq[0]);
		System.out.println("maxConseqSum:"+maxConseqSum);
	}

}
