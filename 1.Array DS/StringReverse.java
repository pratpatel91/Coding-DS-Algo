import java.util.Scanner;

public class StringReverse
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String inputString = input.next();
		reverseStringUsingRecursion(inputString);
	}

	public static void reverseStringUsingRecursion(String str)
	{
		if ((str == null) || (str.length() <= 1))
			System.out.println(str);
		else
		{
			System.out.print(str.charAt(str.length() - 1));
			reverseStringUsingRecursion(str.substring(0, str.length() - 1));
		}
	}
}
