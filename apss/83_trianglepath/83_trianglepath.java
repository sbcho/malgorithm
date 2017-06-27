/* package whatever; // don't place package name! */

import java.util.*;

public class Main{

	static int memo[][];

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int n = 0;


		int cases = scan.nextInt();

		while(cases-- > 0){
			n = scan.nextInt();
			memo = new int[n][n];

			memo[0][0] = scan.nextInt();
			memo[1][0] = scan.nextInt() + memo[0][0];
			memo[1][1] = scan.nextInt() + memo[0][0];

			int temp = 0;
			for(int i = 2; i < n; i++){
				for(int j = 0; j <= i; j++){
					temp = scan.nextInt();
					if(j == 0) memo[i][j] = temp + memo[i-1][j];
					else if(j == i) memo[i][j] = temp + memo[i-1][j-1];
					else  memo[i][j] = Math.max(temp + memo[i-1][j-1], temp + memo[i-1][j]);
				}
			}
			
			int res = 0;
			for(int i = 0; i < n; i++){
				res = Math.max(res, memo[n-1][i]);
			}

			System.out.println(res);	
		}
	}
}
