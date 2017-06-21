import java.util.*;

public class Main{
	
	static int[][] map;
	static int[][] memo;
	static int n;
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		map = new int[100][100];
		memo = new int[100][100];
		
		int cases = scan.nextInt();
		
		while(cases-- > 0){
			n = scan.nextInt();
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					map[i][j] = scan.nextInt();
					memo[i][j] = -1;
				}
			}
			
			if(solve(0,0) == 1) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	private static int solve(int i, int j) {
		if(i == n-1 && j == n-1) return 1;
		if(i >= n || j >= n) return 0;
		if(memo[i][j] >= 0) return memo[i][j];
		
		boolean result = solve(i + map[i][j], j) == 1 || solve(i, j + map[i][j]) == 1;
		if(result) memo[i][j] = 1;
		else memo[i][j] = 0;
		
		return memo[i][j];
	}
}
