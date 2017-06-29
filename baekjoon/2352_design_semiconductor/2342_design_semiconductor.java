/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	static int[] p;
	static int[] memo;
	
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();

		p = new int[n];
		memo = new int[n];
		
		for(int i = 0; i < n; i++){
			p[i] = scan.nextInt();
			memo[i] = -1;
		}
		int res = 0;
		for(int i = 0; i < n; i++){
			res = Math.max(res, 1+ lis(i));
		}
		
		System.out.println(res);
		
	}

	private static int lis(int start) {
		if(memo[start] >= 0) return memo[start];
		int max = 0;
		for(int i = start+1; i < p.length; i++){
			if(p[start] < p[i])
				max = Math.max(max, 1 + lis(i));
		}
		memo[start] = max;
		return max;
	}
}
