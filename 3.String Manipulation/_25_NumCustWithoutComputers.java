

import java.util.ArrayList;

public class _25_NumCustWithoutComputers
{

	public static void main(String[] args)
	{

		System.out.println("Cust Without computers= " + runCustomerSimulation(1, "ABCBCADEED"));

	}

	public static int runCustomerSimulation(int n, String cust)
	{
		int availablePcs=n;
		int peopleWhoDidntGetPc=0;
		
		//hashing
		int[] status = new int[26];
				
		for(int i=0; i<=cust.length()-1; i++)
		{
			char currentCust=cust.charAt(i);
			System.out.println("current cust: " + currentCust);
			if(status[currentCust-'A']==0)
			{
				System.out.println("cust just entered the cafe: " + currentCust);
				status[currentCust-'A']=1; //new cust enters cafe (status=1 is free)
				System.out.println("current cust at the owners desk: " + currentCust);
				System.out.println("Available Pcs:"+ availablePcs);
				if(availablePcs>0)
				{
					availablePcs--;
					status[currentCust-'A']=2;//cust occupies the free pc (status=2 is occupied)
					System.out.println("allocating pc to " + currentCust + " setting status to " + status[currentCust-'A']);
				}
				else
				{
					System.out.println("current cust is " + currentCust + " didnt get the pc");
					peopleWhoDidntGetPc++; //cust entered the cafe but cant get a free pc
				}
				
			}
			else
			{
				System.out.println("This customer"+ currentCust+" was already occupying the pc & now leaving the cafe");
				if(status[currentCust-'A']==2)
				{
					System.out.println("When "+ currentCust+"leaves the # of available pcs are "+ availablePcs);
					availablePcs++;
					System.out.println("After leaving the # of available pcs are"+ availablePcs);
				}
				status[currentCust-'A']=0;//pc is freed up
			}
		}
		return peopleWhoDidntGetPc;
	}
}
