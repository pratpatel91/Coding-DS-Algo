public class DP_LCSOf2Strings
{
	public static int lcs(String s1, String s2, int s1Index, int s2Index)
	{
		// -----------Base Case ------------------//
		// Simplest Compution To Stop Recursion is when
		// the index is at 0
		if (s1Index == 0 || s2Index == 0)
		{
			return 0;
		}
		// ---------------Reoccuring SubProblem---------------------//
		if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1))
		{
			// when s1=s2 then s1Index--, s2Index-- together
			return 1 + lcs(s1, s2, s1Index - 1, s2Index - 1);
		}
		// when s1!=s2 then do s1Index-- and s2Index-- seperately
		return Math.max(lcs(s1, s2, s1Index, s2Index - 1), lcs(s1, s2, s1Index - 1, s2Index));
	}

	public static void main(String[] args)
	{
		String s1 = "ABCDE";
		String s2 = "ADE";

		System.out.print("lcs(ABCDE,ADE)=" + lcs(s1, s2, s1.length(), s2.length()));
	}

}