/* package whatever; // don't place package name! */

import java.util.*;
class Queue{
	int[] array;
	int front;
	int back;
	public Queue(){
		array = new int[20000];
		front = 10000;
		back = 10001;
	}
	public void push_front(int value){
		array[front--] = value;
	}
	public int pop_front(){
		return (back == front + 1) ? -1 : array[++front];
	}
	public void push_back(int value){
		array[back++] = value;
	}
	public int pop_back(){
		return (back == front + 1) ? -1 : array[--back];
	}
	public int size(){
		return back - front - 1;
	}
	public int empty(){
		return (back == front + 1) ? 1 : 0;
	}
	public int front(){
		return (back == front + 1) ? -1 : array[front+1];
	}
	public int back(){
		return (back == front + 1) ? -1 : array[back-1];
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
    			case "push_front" : queue.push_front(scan.nextInt());
				break;
    			case "push_back" : queue.push_back(scan.nextInt());
				break;
    			case "pop_front" : System.out.println(queue.pop_front());
				break;
    			case "pop_back" : System.out.println(queue.pop_back());
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
