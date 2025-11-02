
import java.util.*;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // Push all opening brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } // Handle closing brackets
            else {
                if (stack.isEmpty()) {
                    return false; // nothing to match
                }
                char top = stack.pop();
                if ((c == ')' && top != '(')
                        || (c == ']' && top != '[')
                        || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // After processing all characters, stack should be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "((({[]})))",
            "(",
            "){"
        };

        for (String test : tests) {
            System.out.println("Input: " + test + " → " + isValid(test));
        }
    }
}
