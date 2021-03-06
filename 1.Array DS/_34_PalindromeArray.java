import java.util.Scanner;

public class _34_PalindromeArray
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			int arraySize = input.nextInt();

			int[] array = new int[arraySize];

			for (int i = 0; i <= arraySize - 1; i++)
			{
				array[i] = input.nextInt();
			}

			System.out.println("\n"+isPalindromicArray(array));
			T--;
		}

	}

	public static boolean isPalindromicArray(int[] array)
	{
		boolean answer = true; // assumed palindromic array

		// iterate the array
		for (int i = 0; i <= array.length - 1; i++)
		{
			if (isPalindrome(array[i]))
			{
				System.out.println("\n " + array[i] + " is a palindrome array element");
				continue; // start the next iteration of the for loop
			} else
			{
				System.out.println("\n " + array[i] + " isnt a palindrome array element");
				answer = false;
				break;// breaks the for loop and returns answer
			}
		}
		return answer;
	}

	public static boolean isPalindrome(int number)
	{
		int reverseNum = 0;
		int lastDigit = 0;
		int originalNum = number;

		// repeating the reverse number process until the number
		// is reduced to zero which indicates that reverse is compelete
		while (number > 0)
		{
			System.out.println("\n----------While loop Iteration--------------");
			// getting the last number
			lastDigit = number % 10;
			System.out.print("number: " + number + ", lastDigit: " + lastDigit);
			// adding last number to reverseNum
			reverseNum = reverseNum * 10 + lastDigit;
			// removing the last number
			number /= 10;
			System.out.print(", reverseNum: " + reverseNum + ", number: " + number + "\n");
		}

		return reverseNum == originalNum;
	}

//	public static boolean isPalindrome(int number)
//	{
//		int revNum = 0;
//		int originalNum = number;
//
//		while (number > 0)
//		{
//			revNum = revNum * 10 + number % 10;
//			number /= 10;
//		}
//
//		return revNum == originalNum;
//	}
}
