import java.util.Arrays;

class Stock
{
	int price;
	int day;
	
	Stock ( int price, int day)
	{
		this.price=price;
		this.day=day;
	}
}
public class _4_BindedData_MaximizeStocksPurchasedOn_Ith_Day
{
	public static void main(String[] args)
	{
		int[] stockPrices = { 20, 10, 7, 25, 30, 120, 90, 80 }; 
		int limit = 150;
		
		Stock[] stocks = new Stock[stockPrices.length];
		
		//populating the object array
		for(int i=0; i<=stockPrices.length-1;i++)
		{
			stocks[i]= new Stock(stockPrices[i],(i+1));
		}

		for(int i=0; i<=stocks.length-1;i++)
		{
			System.out.println("Price:"+stocks[i].price + ", day:"+stocks[i].day);
		}
		//sort in ascending order TC=O(N*LogN)
		//dsc order (b.price-a.price)
		Arrays.sort(stocks,(a,b)-> a.price-b.price);
		
		for(int i=0; i<=stocks.length-1;i++)
		{
			System.out.println("Price:"+stocks[i].price + ", day:"+stocks[i].day);
		}
		
		int maxStocks=0; 
		
		//Without Binding Data we have to use nested if else logic 
		for(int i=0; i<=stocks.length-1;i++)
		{
			int stockRange = stocks[i].day;
			int maxStockWithCurrAmount=(limit/ (stocks[i].price));
			int stockPurchased=Math.min(stockRange, maxStockWithCurrAmount);
			maxStocks+=stockPurchased;
			limit-=(stocks[i].price*stockPurchased);
		}
		
		System.out.println("Max Stocks:" + maxStocks);
	}
}
