import java.util.Scanner;

public class _25_PickingUpChickens
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		while (T > 0)
		{
			int totalChicks = input.nextInt();
			int chicksToReachBarn = input.nextInt();
			int barnPosition = input.nextInt();
			int time = input.nextInt();

			int[] positions = new int[totalChicks];

			for (int i = 0; i <= positions.length - 1; i++)
			{
				positions[i] = input.nextInt();
			}

			int[] speed = new int[totalChicks];

			for (int i = 0; i <= speed.length - 1; i++)
			{
				speed[i] = input.nextInt();
			}

			int totalSwaps = 0;
			int swap = 0;
			int reachedByItself = 0;

			//Greedy: choose a chicken closed to the barn
			for (int i = positions.length - 1; i >= 0; i--)
			{
				int distCovered = speed[i] * time;
				int distToBarn = barnPosition - positions[i];
				System.out.println("time:"+time+", speed:"+speed[i]+", distCovered:" + distCovered + ", distToBarn:" + distToBarn);

				if (distCovered >= distToBarn)
				{
					System.out.println("chicks reached by itself:" + reachedByItself);
					reachedByItself++;

					if (swap > 0)
					{
						totalSwaps += swap;
					}
				}
				else
				{
					swap++;
					System.out.println("need to use crane:" + swap);
				}
				if (reachedByItself == chicksToReachBarn)
				{
					System.out.println("Required chickens reached to barn");
					break;
				}
			}

			if (chicksToReachBarn > reachedByItself)
			{
				System.out.println("Impossible");
			}
			else
			{
				System.out.println(totalSwaps);
			}

			T--;
		}

	}

}
