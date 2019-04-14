import java.util.Stack;

public class S20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.isEmpty() && match(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        return stack.isEmpty();
    }

    private boolean match(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        S20 tester = new S20();
        System.out.println(tester.isValid(""));
    }
}
