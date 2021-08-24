
public class ComparingGoodandBadCode
{
	public static void main(String[] args)
	{
		int[] sortedArray = { 1, 2, 3, 4, 5 };
		System.out.println(badCode_kSmallest(sortedArray, 2));
		System.out.println(goodCode_KthSmallestElementInASortedArray(sortedArray, 2));
	}

	public static int badCode_kSmallest(int[] array, int k)
	{
		int kSmall =0;

		for (int i = 0; i <= k - 1; i++)
		{
			kSmall = array[i];
		}
		return kSmall;
	}
	
	public static int goodCode_KthSmallestElementInASortedArray(int[] sortedArray, int kthSmallest)
	{
		int kthSmallestElement = 0;

		for (int currentK = 0; currentK<= kthSmallest-1; currentK++)
		{
			kthSmallestElement = sortedArray[currentK];
		}

		return kthSmallestElement;
	}
}
