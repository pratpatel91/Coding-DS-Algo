
public class _28_BinarySearch_BookAllocation
{

	public static void main(String[] args)
	{
		int[] pages = { 12,34,67,90 };
		int books = 4;
		int students = 2;
		System.out.println(bs_minPagesAllocated(pages,books,students));
	}

	public static int bs_minPagesAllocated(int[] pages, int books, int students)
	{
		// initialization of binary search
		int minPages = 0; // min pages allocated
		int maxPages = sumArray(pages);

		int optimizedMinPages = Integer.MAX_VALUE; // want to minimize the # of pages

		while (minPages <= maxPages)
		{
			int midPages = (minPages + maxPages) / 2;
			System.out.println("minPages:" + minPages + ", midPages:"+midPages + ", maxPages:"+maxPages);
			if (isAllocationPossible(midPages, pages, books, students))
			{
				System.out.println("midPages(valid):"+midPages );
				optimizedMinPages = Math.min(optimizedMinPages, midPages);
				System.out.println("optimizedMinPages:"+ optimizedMinPages);
				maxPages = midPages - 1;
				System.out.println("new maxPages:"+maxPages);
			} else
			{
				System.out.println("midPages(not valid):"+midPages );
				minPages = midPages + 1;
				System.out.println("new minPages:"+minPages);
			}
			
		}
		return optimizedMinPages;
	}

	public static boolean isAllocationPossible(int midPages, int[] pages, int books, int students)
	{
		int sum = 0;
		int studentCount = 1;

		for (int i = 0; i <= pages.length - 1; i++)
		{
			if (pages[i] > midPages)
			{
				return false;// min pages allocation is not possible
			}
			if (pages[i] + sum > midPages)
			{
				studentCount++;
				sum = pages[i];
				System.out.println("studentCount:" + studentCount + ", assignedPages:"+sum);
				if (studentCount > students)
				{
					System.out.println("studentCount:" + studentCount + ", students:"+students);
					return false;
				}
			} else // continously assigned pages to the student
			{
				sum = sum + pages[i];
				System.out.println("studentCount:" + studentCount + ", assignedPages:"+sum);
			}
		}
		return true;
	}

	public static int sumArray(int[] pages)
	{
		int sum = 0;

		for (int i = 0; i <= pages.length - 1; i++)
		{
			sum = sum + pages[i];
		}
		return sum;
	}

}
