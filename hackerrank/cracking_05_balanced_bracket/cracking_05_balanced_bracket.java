import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char current;
        char corresponding;
        for(int i = 0; i < expression.length(); i++){
            current = expression.charAt(i);
            if(checkPushable(current)){
                stack.push(current);
            } else {
                if(stack.isEmpty() || stack.pop() != getCorrespodingChar(current)){
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static boolean checkPushable(char bracket){
        boolean ret = false;
        if(bracket == '{' || bracket == '[' || bracket == '('){
            ret = true;
        }
        return ret;
    }
    public static char getCorrespodingChar(char bracket){
        char ret = 0;
        switch(bracket){
            case '}' : ret = '{';
                       break;
            case ']' : ret = '[';
                       break;
            case ')' : ret = '(';
                       break;
        }
        return ret;
    }
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
