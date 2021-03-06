
public class _1_FirstAndLastPositionInSortedArray 
{

	public static void main(String[] args) 
	{
		//given sorted array
		int[] array = {1,3,5,5,5,5,67,123,135};
		int target =5;
		System.out.println("First occurence of 5 is at i="+firstOccurence(array,target));
		System.out.println("Last occurence of 5 is at i="+lastOccurence(array,target));
	}
	
	public static int firstOccurence(int[] array, int target)
	{
		int firstOccurence = -1;
		
		//due to being a sorted array we can do binary searching
		
		//initialization for binary search
		int left =0; //index position
		int right = array.length-1; //index position
		
		//core logic for binary search
		//while loop is used as we dont know ahead of time
		//how many comparisons we need to make to reach our target
		while (left <= right)
		{
			//1.we need to compute the mid
			int mid =(left+right)/2;
			System.out.println("mid:" + mid + " a[mid]:"+ array[mid]);
			//logic for updating pointers
			if(array[mid]==target)
			{
				firstOccurence=mid;
				right=mid-1; //checking to see if target is on the left side 
			}
			else if (array[mid]> target)
			{
				right=mid-1; //checking to see if target is on the left side
			}
			else //if (array[mid]<target)
			{
				left=mid+1;//checking to see if target is on the right side 
			}
		}
		return firstOccurence;
	}
	
	public static int lastOccurence(int[] array, int target)
	{
		int lastOccurence = -1;
		
		//due to being a sorted array we can do binary searching
		
		//initialization for binary search
		int left =0; //index position
		int right = array.length-1; //index position
		
		//core logic for binary search
		//while loop is used as we dont know ahead of time
		//how many comparisons we need to make to reach our target
		while (left <= right)
		{
			//1.we need to compute the mid
			int mid =(left+right)/2;
			System.out.println("mid:" + mid + " a[mid]:"+ array[mid]);
			//logic for updating pointers
			if(array[mid]==target)
			{
				lastOccurence=mid;
				left=mid+1; //checking to see if target is on the right side 
			}
			else if (array[mid]> target)
			{
				right=mid-1; //checking to see if target is on the left side
			}
			else //if (array[mid]<target)
			{
				left=mid+1;//checking to see if target is on the right side 
			}
		}
		return lastOccurence;
	}
	

}
