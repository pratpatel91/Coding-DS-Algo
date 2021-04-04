import java.util.PriorityQueue;

public class _29_MinCostOfJoiningRopes
{
	public static void main(String[] args)
	{
		long[] ropes = { 3, 2, 6, 4 };
		getMinCostOfJoiningRopes(ropes);
	}

	public static void getMinCostOfJoiningRopes(long[] ropes)
	{
		// ---------Using Inbuilt Heap DS--------------//
		// creating the heap
		PriorityQueue<Long> minCost = new PriorityQueue<>();

		// populating the heap
		for (int i = 0; i <= ropes.length - 1; i++)
		{
			minCost.add(ropes[i]);
		}

		// compute mincost if we have 2 rods
		long currMinCost = 0; // accumulator

		while (minCost.size() > 1)
		{
			long firstRod = minCost.poll(); // getting smallest
			long secondRod = minCost.poll(); // getting 2nd smallest
			long joinedRod = firstRod + secondRod;
			currMinCost += joinedRod;
			minCost.add(joinedRod); // adding joinedRod to the Heap
			System.out.println("FR:" + firstRod + ", SR:" + secondRod + ",JR:" + joinedRod + ",minCost:" + currMinCost);
		}
		System.out.println("min cost:" + currMinCost);
	}

}
