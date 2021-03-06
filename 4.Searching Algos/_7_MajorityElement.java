
public class _7_MajorityElement
{

	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5};
		System.out.println(mooreVotingMajorityElement(array));
	}

	public static int mooreVotingMajorityElement(int[] array)
	{
		//-----------------------------------CORE LOGIC------------------------------//
		int candidateCount =1; //1st element is the candidate by default
		int candidateElement=array[0];
		

		for (int i=1;i<=array.length-1;i++)
		{
			int currentElement=array[i];
			//if we find a repeating candidate
			System.out.println("Curr element:"+array[i] + " candidate:" +candidateElement);
			
			if(candidateElement == currentElement)
			{
				candidateCount ++; // then we increase the count
			}
			else //if we dont find a repeating candidate
			{
				candidateCount --;// then we decrease the count
			}
			//otherwise pick a new candidate & reset the candidate count
			if(candidateCount ==0)
			{
				System.out.println("Resetting the candidate");
				candidateElement=array[i];
				candidateCount =1;
				System.out.println("Curr element:"+array[i] + " candidate:" +candidateElement);
			}
		}
		//-------------------------------------------------------------------------------//
		int desiredFreq=0;
		
		System.out.println("Checking if the candidate exists more than N/2");
		System.out.println(" candidate:" +candidateElement + ", Candidate Count:"+candidateCount);
		
		for (int i=0;i<=array.length-1;i++)
		{
			if(candidateElement==array[i])
			{
				desiredFreq++;
			}
		}
		System.out.println(" candidate:" +candidateElement + ", desired Freq:"+desiredFreq);
		
		
		//printing logic
		if(desiredFreq>array.length/2)
		{
			System.out.println("Majority Element:"+candidateElement);
			return candidateElement;
		}
		else
		{
			return -1;
		}
		
		
	}
}
