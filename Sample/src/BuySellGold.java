import java.util.ArrayList;


public class BuySellGold {

	int buyDay = -1;
	int sellDay = -1;
	
	public BuySellGold(int[] price, int days){

		int i = 0;
		int lowestprice = 0;
		int HighestPrice = 0;
		int lowestpriceDay = 0;
		int HighestPriceDay = 0;
		
		while(i< days){
			if(i==0){
				lowestprice = price[i];
				HighestPrice = price[i];
			}
			if(price[i]<=lowestprice){
				System.out.println("price["+i+"]"+price[i]);
				lowestprice = price[i];
				lowestpriceDay = i;
			}
			if(price[i]>=HighestPrice){
				System.out.println("price["+i+"]"+price[i]);
				HighestPrice = price[i];
				HighestPriceDay = i; 
			}			
			i++;
		}
		System.out.println("lowestpriceDay:"+lowestprice);
		System.out.println("HighestPriceDay:"+HighestPrice);
		
		if(buyDay == -1){
			buyDay = lowestpriceDay;
		}
		if(sellDay == -1){
			sellDay = HighestPriceDay;
		}		
	}
	
	public int getBuyDay(){
		
		return buyDay;
	}
	
	public int getSellDay(){
		return sellDay;
	}
	
	public static void main(String args[]){
        // Gold prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int days = price.length;
        
		BuySellGold gold = new BuySellGold(price,days);		
		
		System.out.println("Buy Day:"+gold.getBuyDay());
		System.out.println("Sell Day:"+gold.getSellDay());
	}
}
