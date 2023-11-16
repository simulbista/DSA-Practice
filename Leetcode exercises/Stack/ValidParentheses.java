package Stack;

//20. Valid Parentheses (Easy)

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                //stack empty means, for a closed bracket, there is no respective open bracket in the stack
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if((top == '(' && c != ')') || (top == '{' && c != '}') || (top == '[' && c != ']') ){
                    return false;
                }
            }
        }

        //if the stack is empty, it means all respective open brackets for a given closed bracket has been popped, so condition met
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(])";
//        String s = "()[]{}";
//        String s = "(]";
        System.out.println(isValid(s));
    }
}
