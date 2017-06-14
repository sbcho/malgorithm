import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    int max_100 = 15;
    int max_25 = 6;
    int max_coins = 23;
    long[] coins = new long[max_coins];
    int k,i,j;
    for(k = 0, i = 0, j = 0; k < max_coins; ){
      if (i<=max_100) coins[k++] = (long) Math.pow(10,i);
      if (i<=max_25) coins[k++] = (long) Math.pow(100,j)*25;
      i++;
      j++;
    }
    Arrays.sort(coins);
    
    int cases = scan.nextInt();
    long price;
    int coin_count;
    
    while(cases-- > 0){
      price = scan.nextLong();
      coin_count = 0;
      k = max_coins-1;
      while(price > 0){
        if(price / coins[k] > 0){
          coin_count += (int) (price / coins[k]);
          price %= coins[k--];
        } else {
          k--;
        }
      }
      System.out.println(String.valueOf(coin_count));
    }
  }
}