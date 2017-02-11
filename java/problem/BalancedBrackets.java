package problem;

import java.util.Stack;

/**
 * Created by gyaneshwar on 06/02/2017.
 */
public class BalancedBrackets {

    public static boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }

            if (c == '}' || c == ']' || c == ')') {

                if (stack.empty())
                    return false;

                if (c == '}' && stack.pop() != '{') {
                    return false;
                }

                if (c == ']' && stack.pop() != '[') {
                    return false;
                }

                if (c == ')' && stack.pop() != '(') {
                    return false;
                }

            }
        }

        if (!stack.empty())
            return false;

        return true;

    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();


            String expression = "{[(])}";
//        String expression = "{{[[(())]]}}";
        System.out.println((isBalanced(expression)) ? "YES" : "NO");
//        }
    }


}
