import java.util.Arrays;

class Meetings // ADT (Data type is abstract because the Meeting datatype is not built in like int or char)
{
	int startTime;
	int endTime;

	// constructor (For creating Meeting Objects)
	Meetings(int startTime, int endTime)
	{
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

public class _11_ShowMaxMeetingsInOneRoom
{
	public static void main(String[] args)
	{
		int[] startTimes = { 5, 3, 0, 5, 8, 1 };
		int[] finishTimes = { 9, 4, 6, 7, 9, 2 };
		
		// Meetings Data Type Array called meetings
		Meetings[] meetings = new Meetings[startTimes.length];
		
		// for loop to create individual meeting objects
		for (int i = 0; i <= startTimes.length - 1; i++)
		{
			meetings[i] = new Meetings(startTimes[i], finishTimes[i]);
		}

		printingTheObjectsArray(meetings);

		// obj comparision sort by end times (ASCENDING ORDER FOR END TIMES)
		Arrays.sort(meetings, (a, b) -> a.endTime - b.endTime);

		printingTheObjectsArray(meetings);

		greedyAlgorithm_ActivitySelection(startTimes, meetings);
	}

	public static void printingTheObjectsArray(Meetings[] meetings)
	{
		// printing the list of meeting objects (pair type array)
		for (int i = 0; i <= meetings.length - 1; i++)
		{
			System.out.println("Meeting Obj {start:" + meetings[i].startTime + ", end:" + meetings[i].endTime + "}");
		}
		System.out.println();
	}

	public static void greedyAlgorithm_ActivitySelection(int[] startTimes, Meetings[] meetings)
	{
		int maxMeetings = 1; // setting i=0 as the 1st meeting
		int prev = 0; // previous meeting pointer
		System.out.println("M:"+meetings[prev].startTime +"-"+meetings[prev].endTime);
		
		for (int curr = 1; curr <= startTimes.length - 1; curr++)
		{
			if (meetings[curr].startTime > meetings[prev].endTime)
			{
				System.out.println("M:"+meetings[curr].startTime +"-"+meetings[curr].endTime);
				maxMeetings++;
				prev = curr;
			}
		}
		System.out.println("Max Meetings:" + maxMeetings);
	}
}