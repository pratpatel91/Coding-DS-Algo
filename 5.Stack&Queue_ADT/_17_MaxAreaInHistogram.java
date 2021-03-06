import java.util.Stack;

public class _17_MaxAreaInHistogram
{

	public static void main(String[] args)
	{
		int[] array = { 6, 2, 5, 4, 5, 1, 6 }; // histogram data
		bruteForce_MaxArea(array);
		optimized_MaxArea(array);
	}

	public static void bruteForce_MaxArea(int[] array)
	{
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i <= array.length - 1; i++)
		{
			int minValue = array[i];

			int tempAreaToTheRight = minValue * 1;

			// updating the max area
			if (maxArea < tempAreaToTheRight)
			{
				maxArea = tempAreaToTheRight;
			}

			for (int j = i + 1; j <= array.length - 1; j++)
			{
				minValue = Math.min(minValue, array[j]);

				tempAreaToTheRight = minValue * (j + 1 - i); // calculates area to the right

				// updating the max area
				if (maxArea < tempAreaToTheRight)
				{
					maxArea = tempAreaToTheRight;
					
				}
			}
		}
		System.out.println(maxArea);
	}

	public static void optimized_MaxArea(int[] array)
	{
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int length = array.length - 1;
		int maxArea = Integer.MIN_VALUE;

		while (i <= length)
		{
			if (stack.isEmpty() || array[stack.peek()] <= array[i])
			{
		//		System.out.println("array[i]:" + array[i]);
				stack.push(i);
			//	System.out.println("Push Index: " + i + ", Pushed Element: " + array[i]);
				i++;

			} else
			{
				int topIndex = stack.peek();
				stack.pop();
			//	System.out.println("Top Index: " + topIndex + ", Top Element: " + array[topIndex]);
				int width = stack.isEmpty() ? i : i-stack.peek()-1 ;
				int height = array[topIndex];
				//System.out.println("Height: " + height + ", width: " + width);
				int tempArea = height * width;
				maxArea=Math.max(tempArea, maxArea);
			}
		}
		//System.out.println("------------");
		
		while (!stack.isEmpty())
		{
			int topIndex = stack.peek();
			stack.pop();
		//	System.out.println("Top Index: " + topIndex + ", Top Element: " + array[topIndex]);
			int width = stack.isEmpty() ? i : i-stack.peek()-1 ;
			int height = array[topIndex];
		//	System.out.println("Height: " + height + ", width: " + width);
			int tempArea = height * width;
			maxArea=Math.max(tempArea, maxArea);
		}
	//	System.out.println(maxArea);
	}

}
