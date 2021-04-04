import java.util.Arrays;
import java.util.Scanner;

class JobInfo
{
	int jobId;
	int deadline;
	int profit;

	// constructor (creating job info objects)
	JobInfo(int jobId, int deadline, int profit)
	{
		this.jobId = jobId;
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class _2_JobSchedulingProblem
{

	public static void main(String[] args)
	{
		// Jobs = (1,4,20)(2,1,10)(3,1,40)(4,1,30)
		// N=4
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		JobInfo[] jobs = new JobInfo[N];

		for (int i = 0; i < N; i++)
		{
			int id = input.nextInt();
			int deadline = input.nextInt();
			int profit = input.nextInt();
			jobs[i] = new JobInfo(id, deadline, profit);
		}

		// printing the pair type array
		for (int i = 0; i < N; i++)
		{
			System.out.println("jobs {" + jobs[i].jobId + ", " + jobs[i].deadline + ", " + jobs[i].profit + "}");
		}

		System.out.println();

		// sort the jobs array by max profit (descending order)
		// object comparison (a,b)
		Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

		// printing the pair type array
		for (int i = 0; i < N; i++)
		{
			System.out.println("jobs {" + jobs[i].jobId + ", " + jobs[i].deadline + ", " + jobs[i].profit + "}");
		}

		// ---------------------core logic------------------//
		int maxJobs = 0; // accumulating variables
		int maxProfit = 0; // accumulating variables

		boolean[] isJobPerformOnThisDay = new boolean[N]; //f,f,f,f,f
		

		// traversing the jobs array
		for (int curr = 0; curr < N; curr++)
		{
			for (int currDeadline = jobs[curr].deadline - 1; currDeadline >= 0; currDeadline--)
			{
				if(isJobPerformOnThisDay[currDeadline]==false)
				{
					isJobPerformOnThisDay[currDeadline]=true;
					maxJobs++;
					maxProfit+=jobs[curr].profit;
					break;// breaking because we can only do 1 job in a day
				}
			}
		}
		System.out.println("Max Jobs:"+maxJobs);
		System.out.println("Max Profit:"+maxProfit);
	}

}
