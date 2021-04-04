import java.util.Arrays;

//creating an ADT and doing object comparison
//to sort one of the arrays while retaining pair order
class TrainTiming
{
	int arrivalTime;
	int departureTime;

	TrainTiming(int arrivalTime, int departureTime)
	{
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
}

public class _5_MinTrainPlatforms
{
	public static void main(String[] args)
	{
		int[] arrivals = { 900, 940, 950, 1100, 1500, 1800 };
		int[] departures = { 910, 1200, 1120, 1130, 1900, 2000 };

		TrainTiming[] schedule = new TrainTiming[arrivals.length];

		for (int i = 0; i <= schedule.length - 1; i++)
		{
			schedule[i] = new TrainTiming(arrivals[i], departures[i]);
		}

		for (int i = 0; i <= schedule.length - 1; i++)
		{
			System.out.println("A-Time:" + schedule[i].arrivalTime + ", D-Time:" + schedule[i].departureTime);
		}
		System.out.println();

		// Lambda functions (arrival time is in ascending order)
		Arrays.sort(schedule, (a, b) -> a.arrivalTime - b.arrivalTime);

		for (int i = 0; i <= schedule.length - 1; i++)
		{
			System.out.println("A-Time:" + schedule[i].arrivalTime + ", D-Time:" + schedule[i].departureTime);
		}

		// core logic
		int minPlatform = 1;
		int currNumOfTrainsOnPlatform = 1;
		int prev = 0;

		// starting with first train
		for (int curr = 1; curr <= schedule.length - 1;)
		{
			// train overlapping
			if (schedule[prev].departureTime >= schedule[curr].arrivalTime)
			{
				currNumOfTrainsOnPlatform++;
				minPlatform = Math.max(minPlatform, currNumOfTrainsOnPlatform);
				curr++;
			}
			else // no train overlapping
			{
				currNumOfTrainsOnPlatform--;
				prev++;
			}
		}
		System.out.println("Min Platforms Needed:" + minPlatform);
	}
}
