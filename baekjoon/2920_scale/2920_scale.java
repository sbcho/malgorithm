/* package whatever; // don't place package name! */

import java.util.*;

public class Main{
	
	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    
    	boolean asc = true;
    	boolean des = true;
    	int cur = scan.nextInt();
    	int pre = cur;
    	for(int i = 1; i < 8; i++){
    		cur = scan.nextInt();
    		if(cur >= pre) des = false;
    		if(pre >= cur) asc = false;
    		pre = cur;
    	}
    	if(asc) System.out.println("ascending");
    	else if(des) System.out.println("descending");
    	else System.out.println("mixed");
	}
}
