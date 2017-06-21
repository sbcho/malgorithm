import java.util.*;

public class Main{
	
	static int price[];
	static int memo[];

	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	
    	price = new int[n];
    	memo = new int[n];
    	
    	for(int i=0; i<n; i++){
    		price[i] = scan.nextInt();
    		memo[i] = -1;
    	}
    	
    	System.out.println(solve(n));
	}
	
	private static int solve(int n){
		if(n == 0) return 0;
		if(memo[n-1] >= 0) return memo[n-1];
        
		for(int i = n; i > 0; i--){
			memo[n-1] = Math.max(memo[n-1], price[i-1] + solve(n-i));
        }
	    
        return memo[n-1];
	}
}
