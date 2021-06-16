public class DP_Fibonacci
{
	static long calls = 0;
	static long[] cache = new long[10]; // cache array

	// 1 1 2 3 5 8 13 21 34 55
	public static void main(String[] args)
	{
		System.out.println("fib(5)=" + recursiveFib(5) + "; called " + calls + "x");

		// initializing cache to be -1 to indicate that nothing is saved
		populatingArray();
		printingArray();

		calls = 0;
		System.out.println("\nfib(5)=" + memoizedFib(5) + "; called " + calls + "x");
		printingArray();

		calls = 0;
		System.out.println("\nfib(5)=" + tabulationFib(5) + "; called " + calls + "x");
		printingArray();

		calls = 0;
		System.out.println("\nfib(5)=" + adhocFib(5) + "; called " + calls + "x");
		printingArray();
	}

	public static void populatingArray()
	{
		for (int i = 0; i < cache.length; i++)
		{
			cache[i] = -1;
		}
	}

	public static void printingArray()
	{
		for (int i = 0; i < cache.length; i++)
		{
			System.out.print(cache[i] + " ");
		}
	}

	// RECURSION TC=O(2^N) SC=O(1)
	public static long recursiveFib(int n)
	{
		if (n == 0 || n == 1)
		{
			return n;
		}

		calls++;

		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}

	// -----MEMOIZATION & TABULATION ARE ALTERNATIVE APPROACHES ----//
	// MEMOIZATION TC=O(N) SC=O(N) due to cache array creation
	public static long memoizedFib(int n)
	{
		if (n == 0 || n == 1)
		{
			return n;
		}

		if (cache[n] == -1) // if the cache is not updated than populate the cache
		{
			calls++;
			long fibo = memoizedFib(n - 1) + memoizedFib(n - 2);
			cache[n] = fibo;
			return fibo;
		}
		else // if the cache is calculated then return the cache
		{
			return cache[n];
		}
	}

	// TABULATION TC=O(N) SC=O(N) not using recursion at all
	public static long tabulationFib(int n)
	{
		if (n == 0 || n == 1)
		{
			return n;
		}

		cache[0] = 0; // fib(0)=0
		cache[1] = 1; // fib(1)=1

		for (int i = 2; i <= n; i++)
		{
			calls++;
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n];
	}

	// TC=O(N) SC=O(1) due to not using arrays
	public static long adhocFib(int n)
	{
		long first = 0; // fib(0)=0 deliberate initialization
		long second = 1; // fib(1)=1 deliberate initialization
		long current = 0;// random initialization

		for (int i = 2; i <= n; i++)
		{
			calls++;
			current = first + second;
			first = second; // updating first
			second = current; // updating second
		}

		return current;
	}
}
