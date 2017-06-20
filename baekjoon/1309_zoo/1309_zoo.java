import java.util.*;

public class Main{
	
	static long[][] memo;
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		memo = new long [n][3];
		memo[0][0] = 1;
		memo[0][1] = 1;
		memo[0][2] = 1;
		
		for(int i = 1; i < n; i++){
			for(int j = 0; j < 3; j++){
				switch(j){
				case 0 : memo[i][j] = memo[i-1][1] + memo[i-1][2];
						break;
				case 1 : memo[i][j] = memo[i-1][0] + memo[i-1][2];
						break;
				case 2 : memo[i][j] = memo[i-1][0] + memo[i-1][1] + memo[i-1][2];
						break;
				}
				memo[i][j] %= 9901;
			}
		}
		
		long result = memo[n-1][0] + memo[n-1][1] + memo[n-1][2];
		System.out.println(result % 9901);
		
	}
}
