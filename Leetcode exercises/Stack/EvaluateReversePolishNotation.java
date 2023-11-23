package Stack;

//150. Evaluate Reverse Polish Notation (Medium)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.
//
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
//
//
//Constraints:
//
//1 <= tokens.length <= 104
//tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            Set<String> operands = new HashSet<>(Arrays.asList("+","-","/","*"));
            int x,y;
            for(String t:tokens){
                if(!operands.contains(t)){
                    //t is a number
                    stack.push(t);
                }else{
                    //t is an operand
                    // pop the last 2 items from the stack, use the current operand and push it back
                    y = Integer.parseInt(stack.pop());
                    x = Integer.parseInt(stack.pop());
                    stack.push(operationHelper(x,y,t));
                }
            }
            return Integer.parseInt(stack.peek());
    }

    public static String operationHelper(int x, int y, String op){
        int result;
        switch (op) {
            case "+":
                result=x+y;
                break;
            case "-":
                result=x-y;
                break;
            case "*":
                result=x*y;
                break;
            case "/":
                result=x/y;;
                break;
            default:
                result=0;
                break;
        }

        return result+"";
    }

    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens));
    }
}
