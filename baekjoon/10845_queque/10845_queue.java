/* package whatever; // don't place package name! */

import java.util.*;
class Queue{
	int[] array;
	int front;
	int back;
	public Queue(){
		array = new int[10000];
	}
	public void push(int value){
		array[back++] = value;
	}
	public int pop(){
		return (front == back) ? -1 : array[front++];
	}
	public int size(){
		return back - front;
	}
	public int empty(){
		return (front == back) ? 1 : 0;
	}
	public int front(){
		return (front == back) ? -1 : array[front];
	}
	public int back(){
		return (front == back) ? -1 : array[back-1];
	}
}

public class Main{
	
	public static void main(String[] args){
    	
    	Scanner scan = new Scanner(System.in);
    
    	int cases = scan.nextInt();
    	Queue queue = new Queue();
    	
    	String temp;
    	while(cases-- > 0){
    		temp = scan.next();
    		switch(temp){
    			case "push" : queue.push(scan.nextInt());
    				break;
    			case "pop" : System.out.println(queue.pop());
    				break;
    			case "size" : System.out.println(queue.size());
    				break;
    			case "empty" : System.out.println(queue.empty());
    				break;
    			case "front" : System.out.println(queue.front());
    				break;
    			case "back" : System.out.println(queue.back());
    				break;
			}
		}
	}
}
