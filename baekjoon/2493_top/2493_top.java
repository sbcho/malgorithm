/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	int n = scan.nextInt();
    	int[] top = new int[n];
		int res;
		
    	for(int i = 0; i < n; i++){
    		top[i] = scan.nextInt();
    		res = 0;
    		for(int j = i-1; j >=0; j--){
    			if(top[j] >= top[i]){
    				res = j + 1;
    				break;			
    			}
    		}
    		System.out.print(res + " ");
    	}
	}
}
