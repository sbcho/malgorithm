import java.util.*;

public class Main
{
	private static int memo[][];
			
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		memo = new int [n+1][m+1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= m; j++){
				memo[i][j] = -1;
			}
		}
		memo[1][1] = 0;
		if(m > 1) memo[1][2] = 1;
		if(n > 1) memo[2][1] = 1;
		
		int result = solve(n,m);
		System.out.println(result);
	}

	private static int solve(int n, int m) {
		if(memo[n][m] >= 0) return memo[n][m];
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i < n; i++){
			min = Math.min(min, solve(i, m) + solve(n-i, m));
		}
		for(int j = 1; j < m; j++){
			min = Math.min(min, solve(n, j) + solve(n, m-j));
		}
		memo[n][m] = min+1;
		
		return min+1;
	}
}
