/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();

		ArrayList<Integer> p = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++){
			p.add(scan.nextInt());
		}
		int res = lis(p);
		
		System.out.println(res);
		
	}

	private static int lis(ArrayList<Integer> p) {
		int max = 0;
		for(int i = 0; i < p.size(); i++){
			ArrayList<Integer> z = new ArrayList<Integer>();
			for(int j = i + 1; j < p.size(); j++){
				if(p.get(i) < p.get(j)){
					z.add(p.get(j));
				}
			}
			max = Math.max(max, 1 + lis(z));
		}
		return max;
	}
}
