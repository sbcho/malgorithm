/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	
    	for(int i = 0; i <= n; i++) array.add(i);
    	
    	String res = "";
    	int next = m;
    	for(int i = n-1; i > 0; i--) {
    		res += array.remove(next--) +", ";
    		next = (next + m) % i;
    		if(next == 0) next = i;
    	}
    	System.out.println("<" + res + array.remove(next) + ">");
	}
}
