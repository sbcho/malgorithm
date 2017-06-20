import java.util.*;

public class Main
{
	private static int memo[][];
			
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		memo = new int [300][300];
		
		System.out.println(solve(n,m));
	}

	private static int solve(int n, int m) {
		if(memo[n][m] > 0) return memo[n][m];
		if(n == 1 && m == 1) return 0;
		if(n == 2 && m == 1 || n == 1 && m == 2) return 1;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i < n; i++){
			min = Math.min(min, solve(i, m) + solve(n-i, m));
		}
		for(int j = 1; j < m; j++){
			min = Math.min(min, solve(n, j) + solve(n, m-j));
		}
		memo[n][m] = min;
		
		return min+1;
	}
}
