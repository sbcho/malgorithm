import java.util.*;

public class Main
{
	static long[] coins;
	static long price;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int max_10 = 15;
		int max_25 = 6;
		int max_coins = 23;
		coins = new long[max_coins];
		int k,i,j,x,y;
		for(k = 0, i = 0, j = 0; k < max_coins; i++, j++){
			if (i<=max_10) coins[k++] = (long) Math.pow(10,i);
			if (i<=max_25) coins[k++] = (long) Math.pow(100,j)*25;
		}
		Arrays.sort(coins);
		
		int cases = scan.nextInt();
		
		int coin_count;
		int min = Integer.MAX_VALUE;
		int min25Coins = 0;

		while(cases-- > 0){
			price = scan.nextLong();
			coin_count = 0;
			k = max_coins-1;
			while(price > 0){
				if(k-2 >= 0 && coins[k] / coins[k-1] == 2){
					min = Integer.MAX_VALUE;
					for(x = 0 ; x * coins[k] <= price; x++){
						y = getCoinsFor25(k, x);
						if(y < min){
							min = y;
							min25Coins = x;
						}
					}
					if(min25Coins > 0){
						coin_count += min25Coins;
						price -= coins[k--] * min25Coins;
					} else {
						k--;
					}
				} else {
					if(price / coins[k] > 0){
						coin_count += (int) (price / coins[k]);
						price %= coins[k--];
					} else {
						k--;	
					}
				}
			}
			System.out.println(coin_count);
		}
	}

	private static int getCoinsFor25(int k, int x) {
		// TODO Auto-generated method stub
		long remainder1 = (long) (price - coins[k] * x);
		long remainder2 = (long) (remainder1 % coins[k-1]);
		
		if(x == 0){
			return (int) (price / coins[k-1] + price % coins[k-1] / coins[k-2]);
		} else {
			return (int) (x + remainder1 / coins[k-1] + remainder2 / coins[k-2]);
		}
	}
}