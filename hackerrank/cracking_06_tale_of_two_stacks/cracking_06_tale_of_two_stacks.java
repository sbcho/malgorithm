import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue <Integer> {

        private Stack<Integer> inBox = new Stack<Integer>();
        private Stack<Integer> outBox = new Stack<Integer>();

        public void enqueue(Integer item) {
            inBox.add(item);
        }

        public Integer dequeue() {

            if (outBox.isEmpty()) {
                while(!inBox.isEmpty()) {
                    outBox.push(inBox.pop());
                }
            }
            return outBox.pop();
        }
        public Integer peek() {
            if (outBox.isEmpty()) {
                while(!inBox.isEmpty()) {
                    outBox.push(inBox.pop());
                }
            }
            return outBox.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}