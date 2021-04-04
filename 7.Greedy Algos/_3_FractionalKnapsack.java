import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Goods
{
	int value;
	int weight;
	int valuePerWeight; // we want to maximize this (greedy approach)

	// constructor (creating goods objects)
	Goods(int value, int weight)
	{
		this.value = value;
		this.weight = weight;
		this.valuePerWeight = (int) (value / weight);
	}
}

public class _3_FractionalKnapsack
{
	public static void main(String[] args)
	{
		// N = 3, W = 50 values[] = {60,100,120} weight[] = {10,20,30}

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int bagCapacity = input.nextInt();

		Goods[] goods = new Goods[N];

		for (int i = 0; i < N; i++)
		{
			int value = input.nextInt();
			int weight = input.nextInt();
			goods[i] = new Goods(value, weight);
		}

		// printing the pair type array
		for (int i = 0; i < N; i++)
		{
			System.out.println(
					"goods {" + goods[i].value + ", " + goods[i].weight + ", " + goods[i].valuePerWeight + "}");
		}

		System.out.println();

		// sort the goods array by max valuePerWeight (descending order)
		// object comparison (a,b)
		Arrays.sort(goods, new Comparator<Goods>()
		{
			@Override // overriding an interfaces method
			public int compare(Goods g1, Goods g2)
			{
				return Integer.compare(g2.valuePerWeight, g1.valuePerWeight);
			}

		});

		// printing the pair type array
		for (int i = 0; i < N; i++)
		{
			System.out.println(
					"goods {" + goods[i].value + ", " + goods[i].weight + ", " + goods[i].valuePerWeight + "}");
		}

		// ---------------------core logic------------------//
		int maxProfit = 0; // accumulating variables
		int currentBagWeight = 0; // accumulating variables

		for (int curr = 0; curr <= goods.length - 1; curr++)
		{
			if ((currentBagWeight + goods[curr].weight) <= bagCapacity)
			{
				currentBagWeight += goods[curr].weight;
				maxProfit += goods[curr].value;
			}
			else // handles fractional profit calculation
			{
				int remainingCapacity = bagCapacity - currentBagWeight;
				int fractionalProfit = goods[curr].value / goods[curr].weight;
				maxProfit += fractionalProfit * remainingCapacity;
				break;
			}
		}
		System.out.println("Max Profit:" + maxProfit);
	}

}
