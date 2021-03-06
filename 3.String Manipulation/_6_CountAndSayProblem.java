import java.util.Scanner;

public class _6_CountAndSayProblem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		
		System.out.println("i =" + N + "answer = " +countAndSay(N));
		
		
	}
	
	public static StringBuilder countAndSay(int N)
	{
		StringBuilder answer = new StringBuilder();
		answer.append("1");
		//System.out.println("i: " + "1"+ ", answer: " + answer);
		//System.out.println("--------------------------------");
		
		//1st decrements N, 2nd does next iteration
		for(int i=1; i<=N;i++)
		{
			StringBuilder temp = new StringBuilder();
			
			//iterate over the string
			for (int j=0; j<=answer.length()-1;j++)
			{
				int count=1;
				
				//i < answer.length()-1 means S[i+1] goes till last index which prevents index out of bounds error
				while(j < answer.length()-1 && answer.charAt(j)==answer.charAt(j+1) )
				{
					count++;
					j++;
				}
				//converting int into string
				temp.append(count).append(answer.charAt(j));
				
			}
			System.out.println("i: " + i+ ", answer: " + answer);
			answer=temp;
			
		}
		return answer;		
	}

	
}
