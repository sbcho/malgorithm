/* package whatever; // don't place package name! */

import java.util.*;
class Stack{
	int[] array;
	int top;
	
	public Stack(){
		array = new int[10000];
	}
	public void push(int value){
		array[top++] = value;
	}
	public int pop(){
		return (top == 0) ? -1 : array[--top];
	}
	public int size(){
		return top;
	}
	public int empty(){
		return (top == 0) ? 1 : 0;
	}
	public int top(){
		return (top == 0) ? -1 : array[top-1];
	}
}

public class Main{
	
	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    
    	int cases = scan.nextInt();
    	Stack stack = new Stack();
    	
    	String temp;
    	while(cases-- > 0){
    		temp = scan.next();
    		switch(temp){
    			case "push" : stack.push(scan.nextInt());
    				break;
    			case "pop" : System.out.println(stack.pop());
    				break;
    			case "size" : System.out.println(stack.size());
    				break;
    			case "empty" : System.out.println(stack.empty());
    				break;
    			case "top" : System.out.println(stack.top());
				break;
			}
		}
	}
}
