
public class _18_MissingNumInAPSeries
{

	public static void main(String[] args)
	{
		// A = 1, B = 3, C = 2
		int start = 1;
		int commonDiff = 2;
		int target = -9;
		System.out.println("is " + target + " in the AP series: " + isNumPresentInAPSeries(start, commonDiff, target));
	}

	public static boolean isNumPresentInAPSeries(int start, int commonDiff, int target)
	{
		// since the AP series uses a common difference
		// therefore we can use the modulo operation in order to find intermediate
		// values
		// in the AP series

		// handling the case for when start is the same as the target
		if (start == target)
		{
			return true;
		} //we added target > start because a neg numbers modulo gives a 0 always thus
		// a neg number falsely passes the if condition and falsely prints true when it should be false
		else if (commonDiff > 0 && (target > start) && (target - start) % commonDiff == 0)
		{
			// due to being a perfector divisor we know that the target is part of the AP
			// Series
			return true;
		}
		// if nothing else happens then the target is not a part of the AP series
		return false;
	}

}
