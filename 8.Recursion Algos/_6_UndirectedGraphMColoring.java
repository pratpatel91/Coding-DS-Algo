import java.util.Arrays;

public class _6_UndirectedGraphMColoring
{
	public static void main(String[] args)
	{
		int[][] graph = {{0,1,1,1}, {1,0,1,0},{1,1,0,1},{1,0,1,0}};
		int color=3;
		int V=4;
		int[] colorsArray = new int[V];
		System.out.println("Can color verticies?: " + isVertexColorable(graph,color, 0, V,colorsArray));
		System.out.println(Arrays.toString(colorsArray));
	}
	
	public static boolean isSafeToColor(int currVertex, int[][] graph,int color, int[] colorsArray, int V)
	{
		for(int adjVertex=0; adjVertex<V;adjVertex++)
		{
			//if the curr Vertexes neighbors have the same color
			if(graph[currVertex][adjVertex]==1 && colorsArray[adjVertex]==color)
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isVertexColorable(int[][] graph, int color, int currVertex, int V, int[] colorsArray)
	{
		//all verticies are colored (adj nodes dont have same colors)
		if(currVertex==V)
		{
			return true;
		}
		
		for(int currColor=1;currColor<=color;currColor++)
		{
			if(isSafeToColor(currVertex, graph,currColor, colorsArray, V))
			{
				//DO (vertex coloring)
				System.out.println("currColor:"+currColor + ", currVertex:"+currVertex);
				colorsArray[currVertex]=currColor;
				
				//RECUR (color the next vertex)
				if(isVertexColorable(graph, color, currVertex+1, V,colorsArray))
				{
					return true;
				}
				
				System.out.println("-> currColor:"+currColor + ", currVertex:"+currVertex);
				//UNDO (vertex coloring)
				colorsArray[currVertex]=0;
			}
		}
		return false;
	}
	
	
	
	

}
